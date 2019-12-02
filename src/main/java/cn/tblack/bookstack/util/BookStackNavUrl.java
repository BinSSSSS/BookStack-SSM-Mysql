package cn.tblack.bookstack.util;

/**
 * <span>用于返回书栈的首页- 登录-等一些常用页面的相对路径</span>
 * @author TD唐登
 * @Date:2019年8月30日
 * @Version: 1.0(测试版)
 */
public class BookStackNavUrl {
	
	/**
	 * @ 拿到首页对象
	 * @return 相对地址
	 */
	public static String homePageUrl() {
		
		
		return "homePage";
	}
	
	/**
	 * @ 返回用户登录页面
	 * @return 相对地址
	 */
	public static String userLoginUrl() {
		
		
		return "loginAndRegister";
	}
	
	/**
	 * @ 返回用户登录页面
	 * @return 相对地址
	 */
	public static String userRegisterUrl() {
		

		return "loginAndRegister";
	}
	/**
	 * @ 返回管理员登录页面
	 * @return
	 */
	public static String AdminLoginUrl() {
		
		return "bs/bs_login";
	}
}
