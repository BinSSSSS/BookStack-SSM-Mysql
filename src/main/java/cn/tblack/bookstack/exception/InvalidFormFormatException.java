package cn.tblack.bookstack.exception;

/**
 * <span>表单格式错误异常</span>
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
public class InvalidFormFormatException extends RuntimeException{

	private static final long serialVersionUID = 1471959026685799896L;

	public InvalidFormFormatException() {
		super();
	}
	
	public InvalidFormFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidFormFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFormFormatException(String message) {
		super(message);
	}

	public InvalidFormFormatException(Throwable cause) {
		super(cause);
	}

}
