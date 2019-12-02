<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					class="icon-reorder shaded"></i>
				</a> <a class="brand" href="index"> 书栈后台 </a>

				<div class="nav-collapse collapse navbar-inverse-collapse">
					<ul class="nav nav-icons">
						<li class="active"><a href="#"> <i class="icon-envelope"></i>
						</a></li>
						<li><a href="#"> <i class="icon-eye-open"></i>
						</a></li>
						<li><a href="#"> <i class="icon-bar-chart"></i>
						</a></li>
					</ul>

					<form class="navbar-search pull-left input-append" action="#">
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

						<li><a href="#"> Support </a></li>
						<li class="nav-user dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="images/user.png" class="nav-avatar" /> <b class="caret"></b>
						</a>
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
		<div class="container" style="min-width: 1380px;">
			<div class="row">
				<div class="span3">
					<div class="sidebar">

						<ul class="widget widget-menu unstyled">
							<li class="active"><a href="index"> <i
									class="menu-icon icon-dashboard"></i> Dashboard
							</a></li>
							<li><a href="activity"> <i
									class="menu-icon icon-bullhorn"></i> News Feed
							</a></li>
							<li><a href="message"> <i class="menu-icon icon-inbox"></i>
									Inbox <b class="label green pull-right">11</b>
							</a></li>

							<li><a href="task"> <i class="menu-icon icon-tasks"></i>
									Tasks <b class="label orange pull-right">19</b>
							</a></li>
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
								href="#togglePages"> <i class="menu-icon icon-cog"></i> <i
									class="icon-chevron-down pull-right"></i><i
									class="icon-chevron-up pull-right"></i> More Pages
							</a>
								<ul id="togglePages" class="collapse unstyled">
									<li><a href="other-login"> <i class="icon-inbox"></i>
											Login
									</a></li>
									<li><a href="other-user-profile"> <i
											class="icon-inbox"></i> Profile
									</a></li>
									<li><a href="other-user-listing"> <i
											class="icon-inbox"></i> All Users
									</a></li>
								</ul></li>

							<li><a href="${pageContext.request.contextPath}/bs/logout">
									<i class="menu-icon icon-signout"></i> Logout
							</a></li>
						</ul>

					</div>
					<!--/.sidebar-->
				</div>
				<!--/.span3-->


				<div class="span9" style="min-width: 1050px;">
					<div class="content">

						<div class="module">
							<div class="module-head">
								<h3>Tables</h3>
							</div>
							<div class="module-body">
								<p>
									<strong>Default</strong> - <small>table class="table"</small>
								</p>
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Jacob</td>
											<td>Thornton</td>
											<td>@fat</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Larry</td>
											<td>the Bird</td>
											<td>@twitter</td>
										</tr>
									</tbody>
								</table>

								<br />
								<!-- <hr /> -->
								<br />

								<p>
									<strong>Striped</strong> - <small>table class="table
										table-striped"</small>
								</p>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Jacob</td>
											<td>Thornton</td>
											<td>@fat</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Larry</td>
											<td>the Bird</td>
											<td>@twitter</td>
										</tr>
									</tbody>
								</table>

								<br />
								<!-- <hr /> -->
								<br />

								<p>
									<strong>Bordered</strong> - <small>table class="table
										table-bordered"</small>
								</p>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Jacob</td>
											<td>Thornton</td>
											<td>@fat</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Larry</td>
											<td>the Bird</td>
											<td>@twitter</td>
										</tr>
									</tbody>
								</table>

								<br />
								<!-- <hr /> -->
								<br />

								<p>
									<strong>Condensed</strong> - <small>table class="table
										table-condensed"</small>
								</p>
								<table class="table table-condensed">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Jacob</td>
											<td>Thornton</td>
											<td>@fat</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Larry</td>
											<td>the Bird</td>
											<td>@twitter</td>
										</tr>
									</tbody>
								</table>

								<br>

								<p>
									<strong>Combined</strong> - <small>table class="table
										table-striped table-bordered table-condensed"</small>
								</p>
								<table
									class="table table-striped table-bordered table-condensed">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Jacob</td>
											<td>Thornton</td>
											<td>@fat</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Larry</td>
											<td>the Bird</td>
											<td>@twitter</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

						<div class="module">
							<div class="module-head">
								<h3>DataTables</h3>
							</div>
							<form
								action="${pageContext.request.contextPath}/bs/upload_file_query"
								method="post" id="upload">

								<div class="module-body table">
									<table cellpadding="0" cellspacing="0" border="0"
										class="datatable-1 table table-bordered table-striped	 display"
										width="100%">
										<thead>
											<tr>
												<th>原始文件名</th>
												<th>保存文件名</th>
												<th>相对路径</th>
												<th>上传用户</th>
												<th>上传时间</th>
												<th>文件大小(字节)</th>
												<th>文件操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${uploadfiles}" var="upfile"
												varStatus="status">
												<c:if test="${status.count % 2 == 1}">
													<tr class="odd gradeX">
												</c:if>
												<c:if test="${status.count % 2 == 0 }">
													<tr class="even gradeC">
												</c:if>
												<td>${upfile.oldName }</td>
												<td>${upfile.realName }</td>
												<td>${upfile.relativePath }</td>
												<td class="center">${upfile.uploadUser}</td>
												<td>${upfile.uploadDate}</td>
												<td class="center">${upfile.fileSize }</td>
												<td class="center"><a href="javascript:void(0)"
													onclick="deleteByFileId(${upfile.fileId})" class="delete">删除</a>
													<a href="javascript:void(0)"
													onclick="downloadByFileId(${upfile.fileId})"
													class="download">下载</a></td>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Old name</th>
												<th>Real name</th>
												<th>Relative path</th>
												<th>Upload user</th>
												<th>Upload time</th>
												<th>File size</th>
												<th>File Options</th>
											</tr>
										</tfoot>
									</table>
								</div>
							</form>
						</div>
						<!--/.module-->

						<br />

					</div>
					<!--/.content-->
				</div>
				<!--/.span9-->
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.wrapper-->

	<div class="footer">
		<div class="container">


			<b class="copyright">&copy; 2019 书栈 - www.tblack.cn </b> 保留所有权利
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/js/status.js"></script>
	<script src="scripts/jquery-1.9.1.min.js"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="scripts/datatables/jquery.dataTables.js"></script>
	<script src="js/table_option.js"></script>
	<script>
		$(document).ready(
				function() {
					$('.datatable-1').dataTable();
					$('.dataTables_paginate').addClass(
							"btn-group datatable-pagination");
					$('.dataTables_paginate > a').wrapInner('<span />');
					$('.dataTables_paginate > a:first-child').append(
							'<i class="icon-chevron-left shaded"></i>');
					$('.dataTables_paginate > a:last-child').append(
							'<i class="icon-chevron-right shaded"></i>');
				});
	</script>
</body>
</html>