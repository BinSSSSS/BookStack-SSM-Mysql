package cn.tblack.bookstack.config;

/**
 * <span>状态响应类： 用于存放处理之后响应的状态</span>
 * 
 * @author TD唐登
 * @Date:2019年9月4日
 * @Version: 1.0(测试版)
 */
public class ResponseStatus {

	// ##请求被成功处理
	public static final Integer SUCCESS = 0x0;

	// ##非明确状态的处理失败。
	public static final Integer FAILED = 0x1;

	// ## 当前用户已经存在
	public static final Integer USERNAME_ALREADY_EXIST = 0x2;

	// ## 当前手机号码已经存在
	public static final Integer PHONE_NUMBER_ALREADY_EXIST = 0x3;

	// ## 验证码不正确
	public static final Integer CHECK_CODE_INCORRECT = 0x4;

	// ## 手机短信验证码不正确
	public static final Integer VERIFICATION_CODE_INCORRECT = 0x5;

	// ##用户名不存在
	public static final Integer USERNAME_NOT_EXIST = 0x6;

	// ##手机号码不存在
	public static final Integer PHONE_NUMBER_NOT_EXIST = 0x7;

	// ##密码不正确
	public static final Integer PASSWORD_INCORRECT = 0x8;

	// ##短信验证码已发送
	public static final Integer VERIFICATION_CODE_ALREADY_SEND = 0x9;

	// ##管理员不存在
	public static final Integer ADMIN_NOT_EXIST = 0xA;

	// ##登录被允许
	public static final Integer LOGIN_APPROVE = 0xB;

	// ##无法删除当前已登录用户
	public static final Integer CAN_NOT_DEL_CURRENT_USER = 0xC;

	// ##当前文件不存在
	public static final Integer FILE_NOT_EXIST = 0xD;

	// ##访问被拒绝
	public static final Integer ACCESS_DENIED = 0xE;

	// ##当前用户未登录
	public static final Integer USER_UNLOGIN = 0x10;

	// ##服务器正忙
	public static final Integer SERVER_ON_BUSY = 0x11;

	// ##文件上传格式错误
	public static final Integer INCORRECT_UPLOAD_FORMAT = 0x12;

	// ##上传文件类型不允许
	public static final Integer UPLOAD_TYPE_NOT_ALLOW = 0x13;
}
