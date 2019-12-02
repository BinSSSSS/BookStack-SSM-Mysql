package cn.tblack.bookstack.exception;

/**
 * <span>不支持的上传文件类型异常</span>
 * 
 * @author TD唐登
 * @Date:2019年9月9日
 * @Version: 1.0(测试版)
 */
public class UnsupportedFileUploadTypeException extends RuntimeException {

	private static final long serialVersionUID = 7446737636013358829L;

	public UnsupportedFileUploadTypeException() {
	}

	public UnsupportedFileUploadTypeException(String msg) {
		super(msg);
	}

}
