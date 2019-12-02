<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" autoFlush="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CH">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>书栈后台</title>
<link rel="icon" href="img/L-log.png">
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link type="text/css" href="css/theme.css" rel="stylesheet">
<link type="text/css" href="images/icons/css/font-awesome.css"
	rel="stylesheet">
<link type="text/css" href="images/icons/css/iconfont.css"
	rel="stylesheet">
<link type="text/css" href="images/icons/css/demo.css" rel="stylesheet">
<link type="text/css"
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
	rel='stylesheet'>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".navbar-inverse-collapse"> <i
					class="icon-reorder shaded"></i></a><a class="brand" href="index">书栈后台
				</a>
				<div class="nav-collapse collapse navbar-inverse-collapse">
					<ul class="nav nav-icons">
						<li class="active"><a href="#"><i class="icon-envelope"></i></a></li>
						<li><a href="#"><i class="icon-eye-open"></i></a></li>
						<li><a href="#"><i class="icon-bar-chart"></i></a></li>
					</ul>
					<form class="navbar-search pull-left input-append" method="post">
						<input type="text" class="span3">
						<button class="btn" type="button">
							<i class="icon-search"></i>
						</button>
					</form>
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">管理员操作 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="uploadfile">管理员文件上传</a></li>
								<li><a href="#">Don't Click</a></li>
								<li class="divider"></li>
								<li class="nav-header">Example Header</li>
								<li><a href="#">A Separated link</a></li>
							</ul></li>
						<li><a href="#">Support </a></li>
						<li class="nav-user dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="images/user.png" class="nav-avatar" /> <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Your Profile</a></li>
								<li><a href="#">Edit Profile</a></li>
								<li><a href="#">Account Settings</a></li>
								<li class="divider"></li>
								<li><a href="${pageContext.request.contextPath}/bs/logout">Logout</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- /navbar -->
	<div class="wrapper">
		<div class="container">
			<div class="row">
				<div class="span3">
					<div class="sidebar">
						<ul class="widget widget-menu unstyled">
							<li class="active"><a href="index"><i
									class="menu-icon icon-dashboard"></i>Dashboard </a></li>
							<li><a href="activity"><i
									class="menu-icon icon-bullhorn"></i>News Feed </a></li>
							<li><a href="message"><i class="menu-icon icon-inbox"></i>Inbox
									<b class="label green pull-right"> 11</b> </a></li>
							<li><a href="task"><i class="menu-icon icon-tasks"></i>Tasks
									<b class="label orange pull-right"> 19</b> </a></li>
						</ul>
						<!--/.widget-nav-->
						<ul class="widget widget-menu unstyled">
							<li><a href="ui-button-icon"><i
									class="menu-icon icon-bold"></i> Buttons </a></li>
							<li><a href="ui-typography"><i
									class="menu-icon icon-book"></i>Typography </a></li>
							<li><a href="form"><i class="menu-icon icon-paste"></i>Forms
							</a></li>
							<li><a href="table"><i class="menu-icon icon-table"></i>Tables
							</a></li>
							<li><a href="charts"><i class="menu-icon icon-bar-chart"></i>Charts
							</a></li>
						</ul>
						<!--/.widget-nav-->
						<ul class="widget widget-menu unstyled">
							<li><a class="collapsed" data-toggle="collapse"
								href="#togglePages"><i class="menu-icon icon-cog"> </i><i
									class="icon-chevron-down pull-right"></i><i
									class="icon-chevron-up pull-right"> </i>More Pages </a>
								<ul id="togglePages" class="collapse unstyled">
									<li><a href="other-login"><i class="icon-inbox"></i>Login
									</a></li>
									<li><a href="other-user-profile"><i class="icon-inbox"></i>Profile
									</a></li>
									<li><a href="other-user-listing"><i class="icon-inbox"></i>All
											Users </a></li>
								</ul></li>
							<li><a href="${pageContext.request.contextPath}/bs/logout"><i
									class="menu-icon icon-signout"></i>Logout </a></li>
						</ul>
					</div>
					<!--/.sidebar-->
				</div>
				<!--/.span3-->
				<div class="span9">
					<div class="content">
						<div class="module">
							<div class="module-head">
								<h3>All Members</h3>
							</div>
							<div class="module-option clearfix">
								<!-- 提交表单查询数据 -->
								<form action="${pageContext.request.contextPath}/bs/user_query"
									method="post" id="query-form">
									<div class="input-append pull-left">
										<input type="text" class="span3"
											placeholder="Filter by name..." name="username">
										<button type="submit" class="btn" id="btn-search">
											<i class="icon-search"></i>
										</button>
									</div>

								</form>
								<div class="btn-group pull-right" data-toggle="buttons-radio">
									<button type="button" class="btn">All</button>
									<button type="button" class="btn">Male</button>
									<button type="button" class="btn">Female</button>
								</div>
							</div>
							<div class="module-body">

								<!-- 在数据库中查询所有的用户对象- 并以列表的形式显示出来 -->
								<c:if test="${not empty user_list}">
									<c:forEach items="${user_list}" var="user" varStatus="status">

										<c:if test="${status.index % 2 == 0}">
											<div class="row-fluid">
										</c:if>
										<div class="span6">
											<div class="media user">
												<a class="media-avatar pull-left" href="#"> <%
 	//男女用户默认头像不同
 %> <c:choose>
														<c:when test="${user.gender == 'Male' }">
															<img src="images/male.png">
														</c:when>
														<c:when test="${user.gender == 'Female' }">
															<img src="images/female.png">
														</c:when>
														<c:otherwise>
															<img src="images/user.png">
														</c:otherwise>
													</c:choose>
												</a>
												<div class="media-body">
													<h3 class="media-title">
														<c:out value="${user.username}" />
													</h3>
													<p>
														<small class="muted">${user.homeland}</small> <small
															class="muted">${user.gender}</small>
													</p>
													<div class="media-option btn-group shaded-icon">
														<a class="btn btn-small email"
															href="${pageContext.request.contextPath}/bs/send_email?username=${user.username}">
															<i class="icon-envelope"></i>
														</a> <a class="btn btn-small share"
															href="${pageContext.request.contextPath}/bs/user_share?username=${user.username}">
															<i class="icon-share-alt"></i>
														</a>
														<!-- 更新按钮 -->
														<a class="btn btn-small update"
															href="${pageContext.request.contextPath}/bs/user_update?username=${user.username}">
															<i class="iconfont icon-bianji"></i>
														</a>
														<!-- 删除按钮 -->
														<a class="btn btn-small delete"
															onclick="deleteByUsername('${user.username}')"> <i
															class="iconfont icon-shanchu"></i>
														</a>
													</div>
												</div>
											</div>
										</div>
										<c:if test="${status.index % 2 == 1 || status.last}">
							</div>
							</c:if>
							</c:forEach>
							</c:if>

							<!--/.row-fluid-->
							<br />
							<div class="pagination pagination-centered">
								<ul>
									<li><a href="#"><i class="icon-double-angle-left"></i></a></li>
									<c:forEach items="${user_list}" step="6" varStatus="status">
										<li><a href="#">${status.count }</a></li>
									</c:forEach>
									<li><a href="#"><i class="icon-double-angle-right"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!--/.content-->
			</div>
			<!--/.span9-->
		</div>
	</div>
	<!--/.container-->
	<!-- <form action="javascript:void(0)"
		method="post" id="delete-form" onsubmit="return false">
		<input type="hidden" name="_method" value="DELETE"> 
		<input type="text" name="username" value="" class="_username">
	</form> -->
	</div>
	<!--/.wrapper-->
	<div class="footer">
		<div class="container">
			<b class="copyright">&copy; 2019 书栈 </b>版权所有，保留所有权利 - <a
				href="http://www.tblack.cn" title="进入书栈" target="_blank">进入书栈</a>
		</div>
	</div>
	<script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="scripts/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/status.js"></script>
	<script src="js/user_mgr.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>