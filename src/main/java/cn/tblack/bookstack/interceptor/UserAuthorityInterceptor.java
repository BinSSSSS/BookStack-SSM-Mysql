package cn.tblack.bookstack.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tblack.bookstack.util.BookStackNavUrl;
import cn.tblack.bookstack.util.CookieUtils;
import cn.tblack.bookstack.util.CookieVerify;

/**
 * <span>权限验证拦截器， 用于验证用户操作是否合法。</span>
 * 
 * @author TD唐登
 * @Date:2019年8月13日
 * @Version: 1.0(测试版)
 */
public class UserAuthorityInterceptor implements HandlerInterceptor {

	@Override
	/**
	 * @ 权限验证
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean approve = true;
		Cookie[] cookies = request.getCookies();

		System.out.println(" 请求路径:" + request.getServletPath());

		/* @当请求首页的时候不进行拦截 */
		if (request.getServletPath().endsWith("/" + BookStackNavUrl.userLoginUrl())
				|| request.getServletPath().matches("\\S+\\.\\w+") || request.getServletPath().endsWith("/user/login")
				|| request.getServletPath().endsWith("/user/register")) {
			return true;
		}

		if (cookies == null) {
			approve = false;
		}else {
			/* @ 拿到缓存内对象 */
			Map<String, String> map = CookieUtils.findCookies(cookies, "username", "ssid");
			String admin = map.get("username");
			String assid = map.get("ssid");

			/* @ 如果未登录状态下操作， 跳转到登录页面 */
			if (!CookieVerify.loginCookieVerify(admin, assid)) {
				approve = false;
			}
		}
		//验证未通过，跳转到登录页面
		if(!approve) {
			response.sendRedirect(request.getContextPath() + "/" + BookStackNavUrl.userLoginUrl());
		}
		
		// 登录状态下进行放行-
		return approve;
	}

	@Override
	/**
	 * @ 在 ModelAndView
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
