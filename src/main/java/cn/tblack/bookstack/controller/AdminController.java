package cn.tblack.bookstack.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.tblack.bookstack.config.ResponseStatus;
import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.pojo.UploadFile;
import cn.tblack.bookstack.service.BookAdminService;
import cn.tblack.bookstack.service.BookUserService;
import cn.tblack.bookstack.service.UploadFileService;
import cn.tblack.bookstack.util.BookStackNavUrl;
import cn.tblack.bookstack.util.CookieUtils;
import cn.tblack.bookstack.util.MD5Utils;

/**
 * <span>管理员用户控制管理器</span>
 * 
 * @author TD唐登
 * @Date:2019年8月22日
 * @Version: 1.0(测试版)
 */
@Controller
@RequestMapping(value = "/bs")
public class AdminController {

	@Autowired
	BookAdminService adminService;

	@Autowired
	BookUserService userService;

	@Autowired
	UploadFileService uFileService;

	/**
	 * @ 返回后台主页
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "bs/index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	/**
	 * @ 后台首页，如果之前存在管理员登录，那么则跳转到后台页面， 否则跳转到登录页面
	 * @param admin
	 * @param assid
	 * @return
	 */
	public String home() {

		return "bs/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)

	/**
	 * @ 请求首页
	 * 
	 * @param req
	 * @return
	 */
	public String index() {
		return "bs/index";
	}

	@RequestMapping(value = "/bs_login", method = RequestMethod.GET)
	/**
	 * @ 返回登录页面
	 * 
	 * @return
	 */
	public String loginFace() {

		return "bs/bs_login";
	}

	@RequestMapping(value = "/table", method = RequestMethod.GET)
	/**
	 * @ 返回图表类
	 * 
	 * @return
	 */
	public String table(HttpServletRequest req) {

		uploadFileQuery(req);

		return "bs/table";
	}

	@RequestMapping(value = "/charts", method = RequestMethod.GET)
	public String charts() {

		return "bs/charts";
	}

	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public String activity() {
		return "bs/activity";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {

		return "bs/form";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message() {
		return "bs/message";
	}

	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public String task() {
		return "bs/task";
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
	public String uploadfile() {
		return "bs/uploadfile";
	}

	@RequestMapping(value = "/other-login", method = RequestMethod.GET)
	public String other_login() {
		return "bs/other-login";
	}

	@RequestMapping(value = "/other-user-listing", method = RequestMethod.GET)
	public String other_user_listing(HttpServletRequest req) {

		System.out.println("/other_user_listing");

		/* @每次请求该页面的时候自动去获取当前的所有用户列表 */
		userQuery(req);

		return "bs/other-user-listing";
	}

	@RequestMapping(value = "/other-user-profile", method = RequestMethod.GET)
	public String other_user_profile() {

		return "bs/other-user-profile";
	}

	@RequestMapping(value = "/ui-button-icon", method = RequestMethod.GET)
	public String ui_button_icon() {
		return "bs/ui-button-icon";
	}

	@RequestMapping(value = "/ui-typography", method = RequestMethod.GET)
	public String ui_typography() {

		return "bs/ui-button-icon";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	/**
	 * @ 后台用户登录功能。
	 * 
	 * @param adminName
	 * @param password
	 * @param req
	 * @param resp
	 * @return
	 */
	public Integer login(String adminName, String password, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println(adminName + " " + password);

		/* @ 登录失败 */
		if (adminName == null || password == null || adminService.verify(adminName, password) < 1) {
			return ResponseStatus.PASSWORD_INCORRECT;
		}

		/* @验证成功- 设置 Cookie */
		CookieUtils.addCookie("admin", adminName, req, resp, UserController.DEFAULT_COOKIE_AGE);
		CookieUtils.addCookie("assid", MD5Utils.encrypt(adminName), req, resp, UserController.DEFAULT_COOKIE_AGE);

		/* @ 响应验证成功 */
		return ResponseStatus.LOGIN_APPROVE;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	/**
	 * @ 管理员注销
	 * 
	 * @return
	 */
	public String logout(HttpServletRequest req, HttpServletResponse resp) {

		/* @ 清空Cookie对象 */
		CookieUtils.delCookies(CookieUtils.getFindCookiesArray(req.getCookies(), "admin", "assid"), resp);

		/* @重定向到登录页面 */
		return "redirect:/" + BookStackNavUrl.AdminLoginUrl();
	}

	@RequestMapping(value = "/user_query", method = RequestMethod.POST)
	/**
	 * @ 对所有的用户进行查询
	 * 
	 * @param req
	 * @return
	 */
	public String userQuery(HttpServletRequest req) {

		/* @ 通过请求对象内的user name来进行模糊查询 */

		String username = req.getParameter("username");

		/* @ 只通过用户名来进行模糊查询 */
		List<BookUser> uList = userService.fuzzySelectByUsername(username);

		if (uList != null) {
			req.setAttribute("user_list", uList);
		}

		return "bs/other-user-listing";
	}

	@RequestMapping(value = "/user_delete", method = RequestMethod.DELETE)
	@ResponseBody
	/**
	 * @ 删除用户的操作
	 * 
	 * @param username
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public Integer userDelete(String username, @CookieValue("admin") String admin) {

		System.out.println("username:" + username);

		if (admin.equals(username)) {
			return ResponseStatus.CAN_NOT_DEL_CURRENT_USER;
		} else {
			/* @ 表示删除成功 */
			if (userService.deleteByUsername(username) > 0) {
				return ResponseStatus.SUCCESS;
			} else {
				return ResponseStatus.USERNAME_NOT_EXIST; // 写入用户不存在或其他原因删除失败
			}
		}
	}

	@RequestMapping(value = "/upload_file_query", method = RequestMethod.POST)
	/**
	 * @ 已经上传文件的查询
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public String uploadFileQuery(HttpServletRequest req) {

		/* @在上传文件的数据库中拿到所有的数据并返回到request对象中 */
		List<UploadFile> upFiles = uFileService.selectAll();

		req.setAttribute("uploadfiles", upFiles);

		if (upFiles == null || upFiles.isEmpty()) {
			req.setAttribute("hasFiles", false);
		} else {
			req.setAttribute("hasFiles", true);
		}

		return "bs/table";
	}

	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	@ResponseBody
	/**
	 * @ 文件上传相关功能
	 */
	public Integer fileUpload(@CookieValue("admin") String adminName, HttpServletRequest request) {

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

		BookUser user = userService.selectByUsername(adminName);

		/* @ 进行文件上传操作--将列表中的包含的多个文件进行上传 */
		for (MultipartFile multipartFile : uploadList) {

			// 当上传文件的过程中发生错误， 那么之后的文件不进行上传- 暂时性处理。
			if (!uFileService.saveMultipartFileByAdmin(multipartFile, user)) {
				return ResponseStatus.FAILED;
			}
		}

		return ResponseStatus.SUCCESS;
	}

	@RequestMapping(value = "/upload_file_delete", method = RequestMethod.DELETE)
	@ResponseBody
	/**
	 * @ 在数据库和文件中删除上传文件。
	 * 
	 * @param fileId
	 * @param req
	 * @param resp
	 */
	public Integer uploadFileDelete(Integer fileId) {

		UploadFile upFile = uFileService.selectByFileId(fileId);

		/* @ 如果该文件已经被删除了。 */
		if (upFile == null) {

			return ResponseStatus.FILE_NOT_EXIST;
		}
		/// 在本地中对文件进行删除
		File file = new File(upFile.getSavePath() + "/" + upFile.getRealName());

		/* @ 只有在本地文件进行删除成功的时候，那么才进行数据库的删除 */
		if (!file.exists() || file.delete()) {
			if (uFileService.deleteByFileId(fileId) > 0) {
				return ResponseStatus.SUCCESS;
			}
		}
		return ResponseStatus.FAILED;
	}

	/**
	 * @ 文件的下载操作
	 * 
	 * @param fileId
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/upload_file_download", method = RequestMethod.GET)
	@ResponseBody
	public String uploadFileDownload(Integer fileId, HttpServletRequest req) {

		UploadFile upFile = uFileService.selectByFileId(fileId);

		String dwUrl = req.getContextPath() + upFile.getRelativePath() + upFile.getRealName();

		System.out.println(dwUrl);

		return dwUrl;
	}
}
