package cn.tblack.bookstack.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.pojo.UploadFile;
import cn.tblack.bookstack.pojo.UploadFileExample;

/**
 * <span>服务层： 对于文件上传的数据表进行方法的封装</span>
 * 
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
public interface UploadFileService {
	long countByExample(UploadFileExample example);

	/**
	 * @ 拿到数据表的所有数据条数
	 * 
	 * @return
	 */
	long count();

	/**
	 * @ 拿到数据表指定文件id的数据条数
	 * 
	 * @param fileId
	 * @return
	 */
	long countByFileId(Integer fileId);

	/**
	 * @ 拿到数据表内指定保存路径的数据条数
	 * 
	 * @param savePath
	 * @return
	 */
	long countBySavePath(String savePath);

	/**
	 * @ 拿到数据表内指定上传文件时名字的数据条数
	 * 
	 * @param oldName
	 * @return
	 */
	long countByOldName(String oldName);

	/**
	 * @ 拿到数据表内指定保存名字的数据条数
	 * 
	 * @param realName
	 * @return
	 */
	long countByRealName(String realName);

	int deleteByExample(UploadFileExample example);

	/**
	 * @ 通过上传文件的id来进行删除数据
	 * 
	 * @param fileId
	 * @return
	 */
	int deleteByFileId(Integer fileId);

	/**
	 * @ 通过保存文件的路径来删除数据
	 * 
	 * @param savePath
	 * @return
	 */
	int deleteBySavePath(String savePath);

	/**
	 * @ 通过上传文件时的文件名来删除数据
	 * 
	 * @param oldName
	 * @return
	 */
	int deleteByOldName(String oldName);

	/**
	 * @ 通过保存文件的名字来删除数据
	 * 
	 * @param realName
	 * @return
	 */
	int deleteByRealName(String realName);

	/**
	 * @ 插入一条新的上传文件记录
	 * 
	 * @param record
	 * @return
	 */
	int insert(UploadFile record);

	/**
	 * @ 插入一条新的上传文件记录， 空字段不进行插入
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(UploadFile record);

	List<UploadFile> selectByExample(UploadFileExample example);

	/**
	 * @ 拿到数据表内的所有数据
	 * 
	 * @return
	 */
	List<UploadFile> selectAll();

	/**
	 * @ 根据保存路径来获取数据
	 * 
	 * @param savePath
	 * @return
	 */
	List<UploadFile> selectBySavePath(String savePath);

	/**
	 * @ 根据上传文件时的名字来查询数据
	 * 
	 * @param oldName
	 * @return
	 */
	List<UploadFile> selectByOldName(String oldName);

	/**
	 * @ 根据保存文件名来查询数据
	 * 
	 * @param realName
	 * @return
	 */
	List<UploadFile> selectByRealName(String realName);

	/**
	 * @ 根据上传文件的id来查询数据
	 * 
	 * @param fileId
	 * @return
	 */
	UploadFile selectByFileId(Integer fileId);

	int updateByExampleSelective(@Param("record") UploadFile record, @Param("example") UploadFileExample example);

	int updateByExample(@Param("record") UploadFile record, @Param("example") UploadFileExample example);

	/**
	 * @ 通过上传文件的id来更新数据， 空字段不更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByFileIdSelective(UploadFile record);

	/**
	 * @ 通过上传文件的id来更新数据。
	 * 
	 * @param record
	 * @return
	 */
	int updateByFileId(UploadFile record);
	
	
	boolean saveUploadFileByUser(HttpServletRequest request, BookUser user);

	boolean saveUploadFileByAdmin(HttpServletRequest request, BookUser user);
	
	/**
	 * @ 保存上传文件- 按照管理员路径进行保存
	 * @param file
	 * @return
	 */
	boolean saveMultipartFileByAdmin(final MultipartFile multipartFile,BookUser user);
	

	boolean saveMultipartFileByUser(final MultipartFile multipartFile,BookUser user);
}
