package cn.tblack.bookstack.util;

/**
 * <span>保存着与文件上传相关的配置信息。</span>
 * 
 * @author TD唐登
 * @Date:2019年8月27日
 * @Version: 1.0(测试版)
 */
public class FileUploadConfig {

	private String tempPath; // 临时保存路径
	private String absPath; // 保存的绝对路径
	private String allowFileType; // 允许上传的文件类型
	private String adminPath; // 管理员文件上传路径
	private String charaset; // 接收的字符编码
	private String savePath; // 保存路径
	private String relativePath;  //上传文件的相对路径
	private int buffSize; // 缓存大小
	private int sizeThreshold; // 最大放入内存的大小
	private long fileSizeMax; // 最大上传文件大小
	private long sizeMax; // 最大可上传的多个文件大小

	
	
	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getAbsPath() {
		return absPath;
	}

	public void setAbsPath(String absPath) {
		this.absPath = absPath;
	}

	public String getAllowFileType() {
		return allowFileType;
	}

	public void setAllowFileType(String allowFileType) {
		this.allowFileType = allowFileType;
	}

	public String getAdminPath() {
		return adminPath;
	}

	public void setAdminPath(String adminPath) {
		this.adminPath = adminPath;
	}

	public String getCharaset() {
		return charaset;
	}

	public void setCharaset(String charaset) {
		this.charaset = charaset;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getBuffSize() {
		return buffSize;
	}

	public void setBuffSize(int l) {
		this.buffSize = l;
	}

	public int getSizeThreshold() {
		return sizeThreshold;
	}

	public void setSizeThreshold(int sizeThreshold) {
		this.sizeThreshold = sizeThreshold;
	}

	public long getFileSizeMax() {
		return fileSizeMax;
	}

	public void setFileSizeMax(long fileSizeMax) {
		this.fileSizeMax = fileSizeMax;
	}

	public long getSizeMax() {
		return sizeMax;
	}

	public void setSizeMax(long sizeMax) {
		this.sizeMax = sizeMax;
	}

	@Override
	public String toString() {
		return "FileUploadConfig [tempPath=" + tempPath + ", absPath=" + absPath + ", allowFileType=" + allowFileType
				+ ", adminPath=" + adminPath + ", charaset=" + charaset + ", savePath=" + savePath + ", buffSize="
				+ buffSize + ", sizeThreshold=" + sizeThreshold + ", fileSizeMax=" + fileSizeMax + ", sizeMax="
				+ sizeMax + "]";
	}

	
}
