package cn.tblack.bookstack.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tblack.bookstack.util.CookieUtils;
import cn.tblack.bookstack.util.CookieVerify;

/**
 * <span>拦截后台管理请求， 处理管理员请求是否合法</span>
 * 
 * @author TD唐登
 * @Date:2019年8月13日
 * @Version: 1.0(测试版)
 */
public class AdminAuthorityInterceptor implements HandlerInterceptor {

	@Override
	/**
	 * @ 在ModelAndView处理前进行操作， 通常是用于权限的验证 @ true 表示放行- false 表示不放行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Cookie[] cookies = request.getCookies();

		System.out.println(" 请求路径:" + request.getServletPath());
		
		/* @当请求首页的时候不进行拦截 */
		if (request.getServletPath().endsWith("/bs/bs_login") || request.getServletPath().matches("\\S+\\.\\w+")
				|| request.getServletPath().endsWith("/bs/login")) {
			return true;
		}

		if (cookies == null) {
			response.sendRedirect(request.getContextPath() + "/bs/bs_login");
			return false;
		}

		/* @ 拿到缓存内对象 */
		Map<String, String> map = CookieUtils.findCookies(cookies, "admin", "assid");
		String admin = map.get("admin");
		String assid = map.get("assid");

		/* @ 如果未登录状态下操作， 跳转到登录页面 */
		if (!CookieVerify.loginCookieVerify(admin, assid)) {
			response.sendRedirect(request.getContextPath() + "/bs/bs_login");
			return false;
		}
		// 登录状态下进行放行-
		return true;
	}

	@Override
	/**
	 * @ 在ModelAndView提交时进行操作，通常是注入通用的配置信息等
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	/**
	 * @ 在 ModelAndView 提交完成之后进行操作， 一般是用于日志的记录等
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
