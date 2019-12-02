package cn.tblack.bookstack.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <span>保存Cookie的工具类</span>
 * 
 * @author TD唐登
 * @Date:2019年6月13日
 * @Version: 1.0(测试版)
 */
public class CookieUtils {

	/**
	 * @ 在指定的Request对象中添加Cookie， 该Cookie的失效时间为传递的时间
	 * 
	 * @param key     键
	 * @param value   值对
	 * @param req     存放Cookie的请求对象
	 * @param resp    Cookie的响应对象
	 * @param expired 失效的时间 (以秒为单位)
	 */
	public static void addCookie(String key, String value, HttpServletRequest req, HttpServletResponse resp,
			int expired) {

		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(expired);
		resp.addCookie(cookie);

	}

	public static void delCookie(Cookie cookie, HttpServletResponse resp) {
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
	}
	/**
	 * @ 清除Cookie数组内的所有Cookie对象
	 * @param cookies
	 * @param resp
	 */
	public static void delCookies(Cookie[] cookies, HttpServletResponse resp) {
		
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
	}
	
	/**
	 * @ 在指定的Cookie数组中拿到需要查找的Cookie对象,并包装为Map对象进行返回
	 * @param cookies
	 * @param cookieName
	 * @return
	 */
	public static Map<String,String> findCookies(Cookie[] cookies, String... cookieName) {

		Map<String,String> target =  new HashMap<>();
		
		for (Cookie cookie : cookies) {

			for (String name : cookieName) {
				if (cookie.getName().equals(name)) {
					target.put(cookie.getName(), cookie.getValue());
				}
			}
		}
		return target;
	}
	
	/**
	 * @ 在指定的数组中查找提供名字的Cookie对象， 并包装为数组对象进行返回
	 * @param cookies
	 * @param cookieName
	 * @return
	 */
	public static Cookie[] getFindCookiesArray(Cookie[] cookies, String... cookieName) {

		List<Cookie> target = new ArrayList<>();
		
		for (Cookie cookie : cookies) {

			for (String name : cookieName) {
				if (cookie.getName().equals(name)) {
					target.add(cookie);
				}
			}
		}
		Cookie[] ret = new Cookie[target.size()];
		return target.toArray(ret);
	}
	
}
