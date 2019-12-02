package cn.tblack.bookstack.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tblack.bookstack.config.ResponseStatus;
import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.pojo.VerificationCode;
import cn.tblack.bookstack.sender.RegisterMessageSender;
import cn.tblack.bookstack.service.BookUserService;
import cn.tblack.bookstack.util.AccountGenerator;
import cn.tblack.bookstack.util.BookStackNavUrl;
import cn.tblack.bookstack.util.Captcha;
import cn.tblack.bookstack.util.CookieUtils;
import cn.tblack.bookstack.util.MD5Utils;
import cn.tblack.bookstack.util.VerificationCodeGenerator;

/**
 * <span>关于网页页面的控制器， 主要是对于未登录状态操作</span>
 * 
 * @author TD唐登
 * @Date:2019年8月28日
 * @Version: 1.0(测试版)
 */
@Controller
public class WebController {

	@Autowired
	BookUserService userService;

	public static final int DEFAULT_COOKIE_AGE = 24 * 60 * 60; // 默认Cookie的失效时间

	@RequestMapping("homePage")
	/**
	 * @ 返回首页
	 * 
	 * @return
	 */
	public String home() {

		return "homePage";
	}

	@RequestMapping(value = "/loginAndRegister", method = RequestMethod.GET)
	public String loginAndRegister() {

		return BookStackNavUrl.userLoginUrl();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String regsiter(BookUser user, String checkCode, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		/* @传递过来的参数构造对象失败的情况下，转到页面 */
		if (user == null) {

			return BookStackNavUrl.userRegisterUrl();
		}

		System.out.println("传递的用户:" + user);
		System.out.println("验证码对象: " + checkCode);

		/* @ 将传送过来的数据进行检查- 是否之前存在该手机号或者是之前是否存在了该用户名 */
		boolean hasDupli = false; // 检查是否存在之前已经注册的数据
		String orgCode = (String) req.getSession().getAttribute("checkCode"); // 原始验证码

		/* @ 验证码不同， 直接显示错误信息并返回 */
		if (!checkCode.equalsIgnoreCase(orgCode)) {
			req.setAttribute("code_tips", "验证码错误!");
			System.out.println("验证码错误");
			hasDupli = true;
		} else {
			if (user.getUsername() == null || userService.countByUsername(user.getUsername()) > 0) {
				req.setAttribute("name_tips", "该用户名已存在!");
				System.out.println("该用户名已存在!");
				hasDupli = true;
			}
			if (user.getPhoneNum() == null || userService.countByPhoneNum(user.getPhoneNum()) > 0) {
				req.setAttribute("phone_tips", "该手机号已注册!");
				System.out.println("该手机已存在!");
				hasDupli = true;
			}
		}

		/* @ 如果没有使用已经注册过的手机号或者是用户名的话,那么则注册成功 */
		if (!hasDupli) {

			if (user.getPhoneNum().isEmpty() || user.getUsername().isEmpty() || user.getPassword().length() < 8) {
				/* @ 当用户修改了前端代码或者提交了错误的数据的时候， 直接响应404 */
				resp.sendError(404);
				return "";
			}

			/* @ 生成一个新的账号 */
			user.setAccount(new AccountGenerator(userService).next());

//			System.out.println("生成的新用户对象： " + user);

			/* @ 插入到数据库之中 */
			System.out.println(userService.insertSelective(user));

			/* @设置Session信息 */
			req.setAttribute("account", user.getAccount());

			/* @ 清除之前设置的tips属性 */
			Enumeration<String> attributes = req.getAttributeNames();
			// 清空所有的属性对象
			while (attributes.hasMoreElements()) {
				req.removeAttribute(attributes.nextElement());
			}

		} else {
			/* @设置跳转到注册页面 */
			req.setAttribute("link", "toregister");
			req.setAttribute("username", user.getUsername());
			req.setAttribute("phoneNum", user.getPhoneNum());
		}

		/*-无论是否注册成功都转发到注册页面*/
		return BookStackNavUrl.userLoginUrl();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	/**
	 * @ 用户登录功能
	 * 
	 * @param model
	 * @return
	 */
	public String login(String token, String upassword, HttpServletRequest request, HttpServletResponse response) {

		/* @ 验证登录信息 */
		BookUser user = null;
		try {
			if (userService.verifyByAccount(Long.parseLong(token), upassword) > 0) {
				user = userService.selectByAccount(Long.parseLong(token));
			} else if (userService.verifyByPhoneNum(token, upassword) > 0) {
				user = userService.selectByPhoneNum(token);
			} else {

				request.setAttribute("tips", "用户名或密码错误");
				request.setAttribute("token", token);
				/*-登录失败*/
				return BookStackNavUrl.userLoginUrl();
			}
		} catch (NumberFormatException e) {
			request.setAttribute("tips", "当前用户不存在");
			request.setAttribute("token", token);
			/*-登录失败*/
			return BookStackNavUrl.userLoginUrl();

		}

		/* @ 当验证登录成功的时候，则设置 Cookie 数据 */
		CookieUtils.addCookie("username", user.getUsername(), request, response, DEFAULT_COOKIE_AGE);
		CookieUtils.addCookie("ssid", MD5Utils.encrypt(user.getUsername()), request, response, DEFAULT_COOKIE_AGE);

		/* @ 将登录成功的用户名设置到session当中去 */
		// request.getSession().setAttribute("username", user.getUsername());

		return "redirect:/" + BookStackNavUrl.homePageUrl() + "?time:" + System.currentTimeMillis(); 
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse resp) {

		/* @ 清除会话内的属性值 */
		System.out.println("删除Cookie");
		// req.getSession().removeAttribute("username");

		System.out.println("1");
		/* @ 清除Cookie对象 */
		CookieUtils.delCookies(CookieUtils.getFindCookiesArray(req.getCookies(), "username", "ssid"), resp);

		/* @重定向到首页 */
		return "redirect:/" + BookStackNavUrl.homePageUrl();
	}

	@RequestMapping(value = "register_captcha", method = RequestMethod.GET)
	@ResponseBody
	/**
	 * @ 向用户发送注册验证码
	 * 
	 * @param req
	 * @param resp
	 */
	public Integer senderRegisterCaptcha(String phoneNum, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		System.out.println("phone number: " + phoneNum);

		VerificationCode vCode = VerificationCodeGenerator.createFourNumberVerficationCode(phoneNum, 60);
		if (RegisterMessageSender.sendCode(vCode)) {
			return ResponseStatus.SUCCESS;
		} else {
			return ResponseStatus.VERIFICATION_CODE_ALREADY_SEND;
		}

	}

	@RequestMapping(value = "/checkCode", method = RequestMethod.GET)
	/**
	 * @ 验证码的绘制和发送到前端
	 */
	public void checkCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setHeader("Pargma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpg");

		System.out.println(resp);

		Captcha captcha = Captcha.getInstance();

		/* @ 每次请求设置随机的验证码 */
		captcha.setCode(captcha.randomCode());

		/* @ 在会话中设置该验证码 */
		req.getSession().setAttribute("checkCode", captcha.getCode());

		ImageIO.write(captcha.drawCheckImg(), "jpg", resp.getOutputStream());

	}
}
