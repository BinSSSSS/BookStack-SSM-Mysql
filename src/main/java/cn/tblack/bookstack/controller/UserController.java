package cn.tblack.bookstack.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.tblack.bookstack.config.ResponseStatus;
import cn.tblack.bookstack.exception.UnsupportedFileUploadTypeException;
import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.service.BookUserService;
import cn.tblack.bookstack.service.UploadFileService;
import cn.tblack.bookstack.util.BookStackNavUrl;

/**
 * <span>用户管理控制器</span>
 * 
 * @author TD唐登
 * @Date:2019年8月22日
 * @Version: 1.0(测试版)
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	BookUserService userService;

	@Autowired
	UploadFileService uFileService;

	public static final int DEFAULT_COOKIE_AGE = 24 * 60 * 60; // 默认Cookie的失效时间

	@RequestMapping(method = RequestMethod.GET)
	public String home() {

		return BookStackNavUrl.homePageUrl();
	}

	@RequestMapping(value = "user_upload", method = RequestMethod.GET)
	/**
	 * @ 返回文件上传功能
	 * 
	 * @return
	 */
	public String userUpload() {

		return "user/user_upload";
	}

	@ResponseBody
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	/**
	 * @ 对用户上传文件进行处理
	 * 
	 * @param req
	 * @param resp
	 */
	public Integer fileUpload(@CookieValue("username") String username, HttpServletRequest request) {

		// 拿到请求对象，并转换为 Multipart请求对象， 之后从该对象中获取到 需要上传的文件信息
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Iterator<String> fileNames = multipartRequest.getFileNames();

		List<MultipartFile> uploadList = new ArrayList<MultipartFile>();

		while (fileNames.hasNext()) {
			uploadList.add(multipartRequest.getFile(fileNames.next()));
		}

		// 文件上传出现问题，文件上传格式错误
		if (uploadList.isEmpty()) {
			return ResponseStatus.INCORRECT_UPLOAD_FORMAT;
		}

		BookUser user = userService.selectByUsername(username);
		
		try {
			/* @ 进行文件上传操作--将列表中的包含的多个文件进行上传 */
			for (MultipartFile multipartFile : uploadList) {

				// 当上传文件的过程中发生错误， 那么之后的文件不进行上传- 暂时性处理。
				if (!uFileService.saveMultipartFileByUser(multipartFile, user)) {
					return ResponseStatus.FAILED;
				}
			}
			
		}catch(UnsupportedFileUploadTypeException e) {
			return ResponseStatus.UPLOAD_TYPE_NOT_ALLOW;
		}
		return ResponseStatus.SUCCESS;
	}

}
