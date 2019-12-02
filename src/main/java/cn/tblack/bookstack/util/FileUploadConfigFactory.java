package cn.tblack.bookstack.util;

/**
 * <span>生成文件上传相关配置信息的工厂类</span>
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class FileUploadConfigFactory {
	
	private static FileUploadConfig defaultConfig = new FileUploadConfig();
	
	/* @  初始化一个默认配置的文件上传配置类 */
	static {
		UploadPropertiesMap upMap = UploadPropertiesMap.getInstance();
		defaultConfig.setAbsPath(upMap.get("absPath"));
		defaultConfig.setAdminPath(upMap.get("adminPath"));
		defaultConfig.setAllowFileType(upMap.get("allowFileType"));
		defaultConfig.setBuffSize(Integer.parseInt(upMap.get("buffSize")));
		defaultConfig.setCharaset(upMap.get("charset"));
		defaultConfig.setFileSizeMax(Long.parseLong(upMap.get("fileSizeMax")));
		defaultConfig.setSavePath(upMap.get("savePath"));
		defaultConfig.setSizeMax(Long.parseLong(upMap.get("sizeMax")));
		defaultConfig.setSizeThreshold(Integer.parseInt(upMap.get("sizeThreshold")));
		defaultConfig.setTempPath(upMap.get("tempPath"));
		defaultConfig.setRelativePath(upMap.get("relativePath"));
	}
	
	/**
	 * @ 创建一个默认配置的文件配置信息类， 该类从 UploadPropertiesMapper 中获取配置信息
	 * @return
	 */
	public static FileUploadConfig  getDefaultFileUploadConfig() {
		
		return  defaultConfig;
	}
	
}
