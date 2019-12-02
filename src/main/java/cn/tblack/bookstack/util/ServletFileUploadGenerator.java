package cn.tblack.bookstack.util;

import java.io.File;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * <span>创建 BookStack 文件上传解析器 </span>
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class ServletFileUploadGenerator {

	
	public static ServletFileUpload getServletFileUpload() {
		
		/* @ 1. 创建工厂类 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		/*@ 创建一个文件上传配置信息类*/
		FileUploadConfig fUploadConfig = FileUploadConfigFactory.getDefaultFileUploadConfig();
		
		/* @ 初始化工厂类的参数 */
		factory.setSizeThreshold(fUploadConfig.getSizeThreshold());
		factory.setRepository(new File(fUploadConfig.getAbsPath() + fUploadConfig.getTempPath()));

		/* @ 2.创建解析器 */
		ServletFileUpload sfUpload = new ServletFileUpload(factory);

		/* @ 初始化解析器的可接收文件大小 */
		sfUpload.setFileSizeMax(fUploadConfig.getFileSizeMax());
		sfUpload.setSizeMax(fUploadConfig.getSizeMax());
		
		
		return sfUpload;
	}
	
}
