package cn.tblack.bookstack.util;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import cn.tblack.bookstack.pojo.VerificationCode;

/**
 * <span>短信验证码验证码生成器，用于产生随机的数字验证码</span>
 * 
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class VerificationCodeGenerator {

	/* @ 使用固定的随机数种子。这样在之后产生随机数的时候就不会产生重复的验证码。 */
//	static Random rand = new Random(998);

	private static Comparator<VerificationCode> comparator = new VerificationCodeComparator();

	/*
	 * @ 另外一种想法是： 使用一个容器来存放已经产生的验证码。 当验证码过了有效期之后，那么则进行验证码的删除。
	 * 
	 * @ 当每次产生新的验证码的时候，则在容器中查看是否存在该验证码，如果存在那么则重新产生验证码。
	 * 
	 * @ 如果要实现这种逻辑的话： 那么则要么将生成器制作成为一个线程的定时器， 要么则将验证码设置为一个类。
	 * 
	 * @ 那么验证码类则保存着生成的时间等- 在重新生成的时候， 检查所有的验证码类， 如果该类的有效期过了。
	 * 
	 * @ 则从容器中删除该验证码。
	 */
	private static Random rand = new Random();

	// 四位验证码容器，使用优先队列，生成时间越早的越放置在前面
	private static  PriorityQueue<VerificationCode> fourNumberCodes = new PriorityQueue<>(comparator);

	// 六位验证码容器，使用优先队列，生成时间越早越放置在前面
	private static PriorityQueue<VerificationCode> sixNumberCodes = new PriorityQueue<>(comparator);

	/**
	 * @ 产生随机的四位验证码
	 * 
	 * @param phoneNumber
	 * @param termValidity
	 * @return
	 */
	public static VerificationCode createFourNumberVerficationCode(String phoneNumber, int termValidity) {

		/*@ 如果该手机号码已经发送过验证码，返回一个空对象*/
		if(isExistFourNumberCode(phoneNumber)) {
			return null;
		}
		// 清除之前过期的验证码
		clearFourNumberCode();

		VerificationCode vCode = new VerificationCode();

		/* @ 产生 1000 - 9999 之间的随机数 */
		int code = (int) Math.abs(rand.nextDouble() * 9000  + 1000);

		vCode.setCode(code);
		vCode.setPhoneNumber(phoneNumber);
		vCode.setTermValidity(termValidity);
		vCode.setGenerationTime(System.currentTimeMillis());

		fourNumberCodes.offer(vCode);
		return vCode;
	}

	/**
	 * @ 产生随机的六位验证码
	 * 
	 * @param phoneNumber
	 * @param termValidity
	 * @return
	 */
	public static VerificationCode createSixNumberVerficationCode(String phoneNumber, int termValidity) {

		/*@ 如果该手机号码已经发送过验证码，返回一个空对象*/
		if(isExistSixNumberCode(phoneNumber)) {
			return null;
		}
		// 每次生成之前清除之前过期的验证码
		clearSixNumberCode();

		VerificationCode vCode = new VerificationCode();

		/* @ 产生 100000 - 999999 之间的六位验证码 */
		int code = (int) Math.abs(rand.nextDouble() * 900000 + 100000);

		vCode.setCode(code);
		vCode.setPhoneNumber(phoneNumber);
		vCode.setTermValidity(termValidity);
		vCode.setGenerationTime(System.currentTimeMillis());

		sixNumberCodes.offer(vCode);
		return vCode;
	}

	/**
	 * @ 验证手机号是否已经发送过四位验证码，并且该验证码未过期
	 * @return 如果存在则返回true， 否则返回false
	 */
	  public static boolean isExistFourNumberCode(String phoneNumber) {

		clearFourNumberCode(); // 首先清除已经过期的四位验证码

		for (VerificationCode vCode : fourNumberCodes) {

			if (vCode.getPhoneNumber() == phoneNumber) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @ 验证手机号是否已经发送过六位验证码，并且该验证码未过期
	 * @return 如果存在则返回true， 否则返回false
	 */
	public static boolean isExistSixNumberCode(String phoneNumber) {

		clearSixNumberCode(); // 首先尝试清除已经过期的验证码

		for (VerificationCode vCode : sixNumberCodes) {
			if (vCode.getPhoneNumber() == phoneNumber) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @ 清除四位验证码中已经过期的验证码
	 */
	public static void clearFourNumberCode() {

		/**
		 * @ 遍历并删除已经过期的元素
		 */
		while (true) {

			// 拿到容器头元素
			VerificationCode vCode = fourNumberCodes.peek();

			// 当存在有效的验证码的时候， 则表示之后的验证都是有效的。
			if (vCode == null || vCode.isValid()) {
				return;
			}

			System.out.println("过期 : " + vCode);
			fourNumberCodes.remove(vCode);
		}

	}

	/**
	 * @ 清除六位验证码中已经过期的验证码
	 */
	public static void clearSixNumberCode() {

		/**
		 * @ 遍历并删除已经过期的元素
		 */
		while (true) {

			// 拿到容器头元素
			VerificationCode vCode = sixNumberCodes.peek();

			// 当存在有效的验证码的时候， 则表示之后的验证都是有效的。
			if (vCode == null || vCode.isValid()) {
				return;
			}

			System.out.println("过期 : " + vCode);
			sixNumberCodes.remove(vCode);
		}

	}

	/*@ 测试代码*/
	public static void main(String[] args) throws InterruptedException {
		VerificationCodeGenerator vcGenerator = new VerificationCodeGenerator();

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10; ++i) {
			vcGenerator.createSixNumberVerficationCode("18070500090", 1);
			// System.out.println(vcGenerator.fourNumberCodes);
		}
		for (VerificationCode vCode : vcGenerator.sixNumberCodes) {
			System.out.println(vCode);
		}
		System.out.println("当前size: " + vcGenerator.sixNumberCodes.size());

		Thread.sleep(1200);

		System.out.println((System.currentTimeMillis() - startTime) + "毫秒");

		vcGenerator.createSixNumberVerficationCode("18070500090", 1);

		System.out.println("----------------------------------------------------");
		for (VerificationCode vCode : vcGenerator.sixNumberCodes) {
			System.out.println(vCode);
		}
	}
}
