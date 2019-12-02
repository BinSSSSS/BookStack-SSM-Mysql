 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="img/L-log.png">
<meta charset="UTF-8">
<title>出错啦....</title>
</head>
<body>
	<!-- 错误页面 ， 用于显示当前出现的错误信息 -->
	<h1>
		<%= exception.getMessage() %>
	</h1>
</body>
</html>