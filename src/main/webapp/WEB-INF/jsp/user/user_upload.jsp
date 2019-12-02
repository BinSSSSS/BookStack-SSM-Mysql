<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>用户文件上传</title>
<link rel="icon" href="img/L-log.png">
<link rel="stylesheet" href="css/user-uploadfile.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">

</head>
<body style="">
	<form action="javascript:void(0)" method="post"
		enctype="multipart/form-data">
		<div class="upload">
			<div class="upload-files">
				<header>
					<p>
						<i class="fa fa-cloud-upload" aria-hidden="true"></i> <span
							class="up">up</span> <span class="load">load</span>
					</p>
				</header>
				<div class="body" id="drop">
					<i class="fa fa-file-text-o pointer-none" aria-hidden="true"></i>
					<p class="pointer-none">
						<b>拖放到这里</b> files here <br> or <a href="javascript:void(0)"
							id="triggerFile">浏览</a>开始上传
					</p>
					<input type="file" multiple="multiple" class="file" name="ufile">
				</div>
				<footer>
					<div class="list-files">
						<!--   template   -->
					</div>
					<div class="divider">
						<span><button type="submit" class="buttons">上传</button></span>
						<p class="error-tips"></p>
					</div>
					<button class="importar buttons" type="button">重选上传文件</button>
				</footer>
			</div>
		</div>
	</form>
	<script src="js/jquery.min.js"></script>
	<script src="js/user-uploadfile.js"></script>
	<script src="${pageContext.request.contextPath }/js/status.js"></script>
</body>
</html>