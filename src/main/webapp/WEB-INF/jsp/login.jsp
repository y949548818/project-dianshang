<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<%@ include file="/include/header.jsp"%>
</head>
<body>
<%@ include file="/include/nav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default ">
					<div class="panel-heading">
						<h3 class="panel-title">
							用户登录
						</h3>
					</div>
					<div class="panel-body">
						
						<form:form action='/project-dianshang/login' role="form" method="post" modelAttribute="user">
							<spring:hasBindErrors name="user">
								<div class="alert alert-danger" role="alert">
									<form:errors path="*" />
								</div>
							</spring:hasBindErrors>
							<div class="form-group">
								<label for="username">用户名：</label>
								<form:input  class="form-control" path="username" placeholder="请输入用户名" />
							</div>
							<div class="form-group">
								<label for="password">密码：</label>
								<form:password  class="form-control"  path="password" placeholder="请输入密码" />
							</div>
							<input type="submit" class="btn btn-primary" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>