package cn.tblack.bookstack.util;

/**
 * <span>对于Cookie的有效性、正确性等进行验证</span>
 * @author TD唐登
 * @Date:2019年8月28日
 * @Version: 1.0(测试版)
 */
public class CookieVerify {

	/**
	 * @ 对于登录的Cookie进行验证
	 * @param token
	 * @param ssid
	 * @return
	 */
	public static boolean loginCookieVerify(String token, String ssid) {
		
		if(token == null || ssid ==  null || !ssid.equals(MD5Utils.encrypt(token)))
			return false;
		
		return true;
	}
}
