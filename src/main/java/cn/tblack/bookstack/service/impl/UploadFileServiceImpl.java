package cn.tblack.bookstack.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.tblack.bookstack.exception.InvalidFormFormatException;
import cn.tblack.bookstack.exception.UnsupportedFileUploadTypeException;
import cn.tblack.bookstack.exception.UnsupportedPermissionException;
import cn.tblack.bookstack.mapper.BookAdminMapper;
import cn.tblack.bookstack.mapper.BookUserMapper;
import cn.tblack.bookstack.mapper.UploadFileMapper;
import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.pojo.UploadFile;
import cn.tblack.bookstack.pojo.UploadFileExample;
import cn.tblack.bookstack.service.UploadFileService;
import cn.tblack.bookstack.util.FileConfigGenerator;
import cn.tblack.bookstack.util.FileUploadConfig;
import cn.tblack.bookstack.util.FileUploadConfigFactory;
import cn.tblack.bookstack.util.FileWriter;
import cn.tblack.bookstack.util.NumberFormat;
import cn.tblack.bookstack.util.ServletFileUploadGenerator;

/**
 * <span>服务层实现类： 用户实现父类接口定义的方法</span>
 * 
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

	@Autowired
	UploadFileMapper uFileMapper;

	@Autowired
	BookUserMapper userMapper;

	@Autowired
	BookAdminMapper adminMapper;

	// 拿到上传文件默认配置信息类
	FileUploadConfig fUploadConfig = FileUploadConfigFactory.getDefaultFileUploadConfig();

	@Override
	public long countByExample(UploadFileExample example) {
		return uFileMapper.countByExample(example);
	}

	@Override
	public long count() {
		return uFileMapper.count();
	}

	@Override
	public long countByFileId(Integer fileId) {
		return uFileMapper.countByFileId(fileId);
	}

	@Override
	public long countBySavePath(String savePath) {
		return uFileMapper.countBySavePath(savePath);
	}

	@Override
	public long countByOldName(String oldName) {
		return uFileMapper.countByOldName(oldName);
	}

	@Override
	public long countByRealName(String realName) {
		return uFileMapper.countByRealName(realName);
	}

	@Override
	public int deleteByExample(UploadFileExample example) {
		return uFileMapper.deleteByExample(example);
	}

	@Override
	public int deleteByFileId(Integer fileId) {
		return uFileMapper.deleteByFileId(fileId);
	}

	@Override
	public int deleteBySavePath(String savePath) {
		return uFileMapper.deleteBySavePath(savePath);
	}

	@Override
	public int deleteByOldName(String oldName) {
		return uFileMapper.deleteByOldName(oldName);
	}

	@Override
	public int deleteByRealName(String realName) {
		return uFileMapper.deleteByRealName(realName);
	}

	@Override
	public int insert(UploadFile record) {
		return uFileMapper.insert(record);
	}

	@Override
	public int insertSelective(UploadFile record) {
		return uFileMapper.insertSelective(record);
	}

	@Override
	public List<UploadFile> selectByExample(UploadFileExample example) {
		return uFileMapper.selectByExample(example);
	}

	@Override
	public List<UploadFile> selectAll() {
		return uFileMapper.selectAll();
	}

	@Override
	public List<UploadFile> selectBySavePath(String savePath) {
		return uFileMapper.selectBySavePath(savePath);
	}

	@Override
	public List<UploadFile> selectByOldName(String oldName) {
		return uFileMapper.selectByOldName(oldName);
	}

	@Override
	public List<UploadFile> selectByRealName(String realName) {
		return uFileMapper.selectByRealName(realName);
	}

	@Override
	public UploadFile selectByFileId(Integer fileId) {
		return uFileMapper.selectByFileId(fileId);
	}

	@Override
	public int updateByExampleSelective(UploadFile record, UploadFileExample example) {
		return uFileMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UploadFile record, UploadFileExample example) {
		return uFileMapper.updateByExample(record, example);
	}

	@Override
	public int updateByFileIdSelective(UploadFile record) {
		return uFileMapper.updateByFileIdSelective(record);
	}

	@Override
	public int updateByFileId(UploadFile record) {
		return uFileMapper.updateByFileId(record);
	}

	/**
	 * @ 工具函数，根据上传的原始文件名来进行生成新的本地保存文件名
	 * @return
	 */
	private String getRealName(String oldName) {

		String realName = null;

		// 首先我可能需要对上传的文件类型进行控制
		int suffixIndex = oldName.lastIndexOf(".");

		if (suffixIndex == -1) {
			throw new UnsupportedFileUploadTypeException("不允许上传的文件类型!");
		}

		/* @拿到文件后缀(也可以作为是文件类型) */
		String fileSuffix = oldName.substring(suffixIndex + 1);
		fileSuffix = fileSuffix.toLowerCase(); // 转为小写进行比较

		/* @拿到允许上传文件类型的列表，从配置文件中读取 */
		List<String> allowFileTypes = Arrays.asList(fUploadConfig.getAllowFileType().split(","));
		if (allowFileTypes.indexOf(fileSuffix) == -1)
			throw new UnsupportedFileUploadTypeException("不允许上传的文件类型!\n" + "允许上传的文件类型为: " + allowFileTypes);

		// 证明是可上传的文件类型， 那么我们则需要进行html文件名字的生成
		if (fileSuffix.equals("html") || fileSuffix.equals("htm") || fileSuffix.equals("jsp")) {
			realName = FileConfigGenerator.createHtmlName() + "." + fileSuffix;
		}
		/* @ 其他类型文件保留原有的名字 */
		else {
			realName = getFileName(oldName);
		}
		return realName;
	}

	/**
	 * @ 通过路径来获取文件名字
	 * 
	 * @param path
	 * @return
	 */
	private String getFileName(String path) {

		return path.substring(path.lastIndexOf("\\") + 1);
	}

	/**
	 * @ 工具类， 用于获取传递的文件路径中的文件夹名称
	 * 
	 * @return
	 */
	/*
	 * private String getFolderName(String path) {
	 * 
	 * int sepaIndex = path.lastIndexOf("\\"); // 拿到最后一个分隔符'/' sepaIndex = sepaIndex
	 * == -1 ? 0 : sepaIndex; // 结束位置,如果上传的是单个文件的话，那么就截取字符串为空
	 * 
	 * String folderName = path.substring(0, sepaIndex);
	 * 
	 * return folderName; }
	 */

	@Override
	public boolean saveUploadFileByUser(HttpServletRequest request, BookUser user) {
		return saveUploadFile(request, user, false);
	}

	@Override
	public boolean saveUploadFileByAdmin(HttpServletRequest request, BookUser user) {
		return saveUploadFile(request, user, true);
	}

	private boolean saveUploadFile(HttpServletRequest request, BookUser user, boolean isAdmin) {

		/* @ 非正确的上传格式,任何步骤都无需要做，直接抛出异常 */
		if (!ServletFileUpload.isMultipartContent(request))
			throw new InvalidFormFormatException("错误表单的提交数据格式");

		/* @ 用户未登录进行操作 */
		if (user == null)
			throw new UnsupportedPermissionException("当前用户无权进行操作!");

		System.out.println("正在进行上传文件的操作");

		// 拿到文件上传解析器。
		ServletFileUpload sfUpload = ServletFileUploadGenerator.getServletFileUpload();

		/* @2.1 设置上传状态监听 */
		sfUpload.setProgressListener(new ProgressListener() {

			String size; // 上传文件的总大小，只初始化一次

			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {

				if (size == null)
					size = NumberFormat.getExactByteUnit(pContentLength);
				String readLen = NumberFormat.getExactByteUnit(pBytesRead);

				System.out.printf("上传总量为: %s\n当前已上传:%s\n\n", size, readLen);
			}
		});

		/* @ 3.解析数据 */
		try {

			System.out.println("解析数据");
			List<FileItem> items = sfUpload.parseRequest(request);

			System.out.println(items.size());

			List<String> uploadFiles = new ArrayList<>(); // 保存上传到服务器的所有文件名(是用户上传的文件生成的html等类型的文件名)

			for (FileItem item : items) {
				System.out.println("判断数据");
				/* @ 4.判断是普通表单域还是文件域 */
				if (item.isFormField()) {

					/* @ 5.普通表单域 */

				} else {
					/* @ 6.文件域 */

					/* @ 创建文件信息对象 */
					UploadFile upFile = new UploadFile();

					String oldName = item.getName(); // 上传文件的初始文件名

					String absPath = fUploadConfig.getAbsPath(); // 项目的绝对路径

					String relativePath = fUploadConfig.getRelativePath(); // 文件的相对路径

					/* @ 解决兼容性问题， 如果是IE传入的文件路径是绝对路径，此时只保存文件名 */
					oldName = oldName.substring(oldName.lastIndexOf("\\") + 1);

					String realName = null;
					File dir = null;

					/*
					 * @ 当然还可以有其他选项， 如果我的管理员希望更新当前指定的页面的话，那么我肯定希望使用的是上传的文件名
					 * 
					 * @ 并且我还希望保存的路径是在根目录下,这样在上传完成之后我才能够进行访问上传的数据
					 */
					if (isAdmin) {
						// 用于管理员文件上传所需要做的步骤
						// 如果上传的是文件夹的话， 那么则需要保留上传文件的路径
						// 我们假设前端已经帮我们完成上传文件是相对路径的处理
						relativePath = "/"; // 如果是管理员操作，那么相对路径就是根目录

						absPath = fUploadConfig.getAdminPath(); // 设置为管理员保存路径
						dir = new File(absPath); // 管理员直接上传到根目录下
						realName = oldName; // 实际保存的名字不改变
						System.out.println("管理员操作");
					}

					/* @ 当如果是单个用户进行文件上传的时候，那我则需要进行控制 */
					else {

						realName = getRealName(oldName); // 通过上传时使用的名字来生成一个可以在本地使用的文件名
						uploadFiles.add(realName); // 添加到新生成文件名的列表中

						relativePath = relativePath + "/user/" + user.getUsername() + "/"; // 生成新的相对路径

						// 并且该文件保存在用户上传目录下的用户名字下
						dir = new File(absPath + relativePath); // user是上传文件的用户

					}
					/* @ 该文件夹不存在的时候则创建 */
					if (!dir.exists()) {
						dir.mkdirs();
					}
					System.out.println("当前的相对路径为:" + relativePath);
					String savePath = dir.getAbsolutePath();
					/* @ 初始化信息 */
					upFile.setOldName(oldName);
					upFile.setRealName(realName);
					upFile.setFileSize(item.getSize());
					upFile.setFileType(item.getContentType());
					upFile.setRelativePath(relativePath);
					upFile.setSavePath(savePath);
					upFile.setUploadUser(user.getUsername());
					upFile.setUploadDate(new Timestamp(System.currentTimeMillis()));

					/* @ 插入到数据库中 */
					if (uFileMapper.insertSelective(upFile) > 0) {
						System.out.println("插入完成");

						/* @ 只有当插入数据库完成的时候才进行保存文件 */
						FileWriter.writeToFile(item.getInputStream(), (int) item.getSize(), fUploadConfig.getBuffSize(),
								dir.getAbsolutePath() + "/" + realName);

						System.out.println("文件写入完成!");

					} else {
						System.out.println("插入失败!");
						return false;
					}
				}
			}
			// 将设置了新名字的文件的文件名转交给前台进行处理
			request.setAttribute("fileList", uploadFiles);
		} catch (SizeLimitExceededException e1) {
			throw new RuntimeException("上传的总文件大小超过了限定大小: " + fUploadConfig.getSizeMax() / (1024 * 1024) + " MB");
		} catch (FileSizeLimitExceededException e2) {
			throw new RuntimeException("上传的单个文件大小超过了限定大小: " + fUploadConfig.getFileSizeMax() / (1024 * 1024) + " MB");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean saveMultipartFileByAdmin(MultipartFile multipartFile, BookUser user) {
		return saveMultipartFile(multipartFile, user, true);
	}

	@Override
	public boolean saveMultipartFileByUser(MultipartFile multipartFile, BookUser user) {
		return saveMultipartFile(multipartFile, user, false);
	}

	/**
	 * @ 用于上传相关的操作
	 * 
	 * @param multipartFile
	 * @param user
	 * @param isAdmin
	 * @return
	 */
	private boolean saveMultipartFile(MultipartFile multipartFile, BookUser user, boolean isAdmin) {
		/* @ 创建文件信息对象 */
		UploadFile upFile = new UploadFile();

		String oldName = multipartFile.getOriginalFilename(); // 上传文件的初始文件名

		String absPath = fUploadConfig.getAbsPath(); // 项目的绝对路径

		String relativePath = fUploadConfig.getRelativePath(); // 文件的相对路径

		/* @ 解决兼容性问题， 如果是IE传入的文件路径是绝对路径，此时只保存文件名 */
		oldName = oldName.substring(oldName.lastIndexOf("\\") + 1);

		String realName = null; // 最终保存的名字
		File dir = null; // 保存文件的文件夹位置

		/*
		 * @ 用于管理员文件上传所需要做的步骤 如果上传的是文件夹的话， 那么则需要保留上传文件的路径
		 * 
		 * @ 我们假设前端已经帮我们完成上传文件是相对路径的处理
		 */
		if (isAdmin) {
			relativePath = "/"; // 如果是管理员操作，那么相对路径就是根目录

			absPath = fUploadConfig.getAdminPath(); // 设置为管理员保存路径
			dir = new File(absPath); // 管理员直接上传到根目录下
			realName = oldName; // 实际保存的名字不改变
			System.out.println("管理员操作");
		}
		// 普通用户操作
		else {
			realName = getRealName(oldName); // 通过上传时使用的名字来生成一个可以在本地使用的文件名
			relativePath = relativePath + "/user/" + user.getUsername() + "/"; // 生成新的相对路径
			// 并且该文件保存在用户上传目录下的用户名字下
			dir = new File(absPath + relativePath); // user是上传文件的用户
		}

		/* @ 该文件夹不存在的时候则创建 */
		if (!dir.exists()) {
			dir.mkdirs();
		}

		System.out.println("当前的相对路径为:" + relativePath);
		String savePath = dir.getAbsolutePath();

		/* @ 初始化信息 */
		upFile.setOldName(oldName);
		upFile.setRealName(realName);
		upFile.setFileSize(multipartFile.getSize());
		upFile.setFileType(multipartFile.getContentType());
		upFile.setRelativePath(relativePath);
		upFile.setSavePath(savePath);
		upFile.setUploadUser(user.getUsername());
		upFile.setUploadDate(new Timestamp(System.currentTimeMillis()));

		/* @ 插入到数据库中 */
		if (uFileMapper.insertSelective(upFile) > 0) {
			System.out.println("插入完成");

			/* @ 只有当插入数据库完成的时候才进行保存文件 */
			try {
				FileWriter.writeToFile(multipartFile.getInputStream(), (int) multipartFile.getSize(),
						fUploadConfig.getBuffSize(), dir.getAbsolutePath() + "/" + realName);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("文件写入完成!");

		} else {
			System.out.println("插入失败!");
			return false;
		}
		return true;
	}
}
