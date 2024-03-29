package cn.tblack.bookstack.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <span>用于对传入的字符进行MD5加密</span>
 * 
 * @author TD唐登
 * @Date:2019年6月13日
 * @Version: 1.0(测试版)
 */
public class MD5Utils {

	private static String KEY = "TD@998.cn.tblack"; // 加密需要使用到的密钥
	private static int OFFSET = 4; // 加密的偏移量
	private static char[] DIRCTIONAY = "0123456789abcdef".toCharArray(); // 加密字典，保存着16进制的数字
	private static int CIPHER_LEN = 32;

	public static String encrypt(String data) {

		data += KEY;
		byte[] bytes = data.getBytes();
		try {

			/* @ 使用MD5加密的方法对消息进行加密 */
			MessageDigest digest = MessageDigest.getInstance("MD5");

			/* @ 使用Java内的MD5不可逆加密算法对字符进行加密 */
			digest.update(bytes);
			bytes = digest.digest();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/* @ 当如果出现了异常导致MD5加密算法不可用的话， 此时加密的密钥则会变为可逆状态 */
		return encryptByOffset(data, data.getBytes());
	}

	/**
	 * @ 自定义的加密算法， 通过使用和密钥结合和偏移来生成一个密钥。 该加密可逆， 主要是为了防止其他的加密方法失败之后再进行设置
	 * 
	 * @param data
	 * @return
	 */
	private static String encryptByOffset(String data, byte[] bytes) {

		data += KEY;

		char[] cipherText = new char[bytes.length * 2];
		int cnt = 0;

		for (int i = 0; i < bytes.length; ++i) {
			cipherText[cnt++] = DIRCTIONAY[(bytes[i] >> OFFSET & 0xf)];
			cipherText[cnt++] = DIRCTIONAY[(bytes[i] & 0xf)];
		}

		return new String(cipherText, 0, CIPHER_LEN);
	}

	public static void main(String[] args) {

//		String name = "David-TD";
//
//		System.out.println(encrypt(name) + " \n" + encrypt(name).length());
//
//		String name2 = "David_TD";
//		System.out.println(encrypt(name2) + " \n" + encrypt(name2).length());
		
//		System.out.println(password("123456789abcdasdas"));
	}
}
