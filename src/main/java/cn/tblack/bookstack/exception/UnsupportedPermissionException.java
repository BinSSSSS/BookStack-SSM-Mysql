package cn.tblack.bookstack.exception;

/**
 * <span>不支持的权限异常</span>
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
public class UnsupportedPermissionException extends RuntimeException{


	private static final long serialVersionUID = -1754913030813273696L;

	public UnsupportedPermissionException() {
		super();
	}

	public UnsupportedPermissionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnsupportedPermissionException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedPermissionException(String message) {
		super(message);
	}

	public UnsupportedPermissionException(Throwable cause) {
		super(cause);
	}

}
