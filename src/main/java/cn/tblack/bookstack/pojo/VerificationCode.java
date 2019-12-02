package cn.tblack.bookstack.pojo;

/**
 * <span>验证码类： 用于保存着验证码的各项信息</span>
 * 
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class VerificationCode {

	private int code; // 验证码
	private String phoneNumber;	  //该验证码发送的手机号码
	private int termValidity; // 验证码有效期- 以秒为单位
	private long generationTime; // 生成时间- 通过从1970年到现在的毫秒数表示

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTermValidity() {
		return termValidity;
	}

	public void setTermValidity(int termValidity) {
		this.termValidity = termValidity;
	}

	public long getGenerationTime() {
		return generationTime;
	}

	public void setGenerationTime(long generationTime) {
		this.generationTime = generationTime;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @ 当前验证码是否有效
	 * @return 通过将当前时间来转换为毫秒并减去生成的时间来测试是否超过了有效的期限。有效返回true。否则返回false
	 */
	public boolean isValid() {
		return (System.currentTimeMillis() - generationTime)  < termValidity * 1000;
	}

	@Override
	public String toString() {
		return "VerificationCode [code=" + code + ", phoneNumber=" + phoneNumber + ", termValidity=" + termValidity
				+ ", generationTime=" + generationTime + "]";
	}
	
	
}
