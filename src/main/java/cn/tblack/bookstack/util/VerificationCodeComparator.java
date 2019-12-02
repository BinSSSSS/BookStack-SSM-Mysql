package cn.tblack.bookstack.util;

import java.util.Comparator;

import cn.tblack.bookstack.pojo.VerificationCode;

/**
 * <span>验证码比较器， 将验证码来进行比较，注册时间越早的优先级越高</span>
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class VerificationCodeComparator implements Comparator<VerificationCode>{

	@Override
	/* @ 按照注册的时间来进行比较 */
	public int compare(VerificationCode lhs, VerificationCode rhs) {
		return (int) (lhs.getGenerationTime() -  rhs.getGenerationTime());
	}
}
