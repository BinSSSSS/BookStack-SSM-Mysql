package cn.tblack.bookstack.sender;

import java.util.ArrayList;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import cn.tblack.bookstack.pojo.VerificationCode;
import cn.tblack.bookstack.util.VerificationCodeGenerator;

/**
 * <span>注册短信发送器： 用于用户在注册时的验证码发送</span>
 * 
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class RegisterMessageSender {
	
	private static  int appId = 1400229382;
	private static String appKey = "988c1df6caa47d4b900173ae38b14475";


	/**
	 * @ 向用户发送注册验证码，需要提供发送手机号码验证码和该验证码的有效期
	 * @param phoneNum
	 * @param code
	 * @param termValidty
	 * @return
	 */
	public static boolean  sendCode(VerificationCode vCode) {
		SmsSingleSender ssender = new SmsSingleSender(appId, appKey);

		try {
			ArrayList<String> params = new ArrayList<>(); // 存放模板内指定参数的集合
			int templateId = 405153; // 短信正文模板的id
			params.add("" + vCode.getCode()); // 第一个参数为验证码
			params.add("" + vCode.getTermValidity() / 60 ); // 第二个参数为有效时间
			SmsSingleSenderResult result = ssender.sendWithParam("86", vCode.getPhoneNumber(), templateId, params, "", "", "");
			System.out.println(result);                                                            
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		sendCode(VerificationCodeGenerator.createFourNumberVerficationCode("18070500090", 60));
	}
}
