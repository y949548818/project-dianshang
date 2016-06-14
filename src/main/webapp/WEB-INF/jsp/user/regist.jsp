<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/include/nav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default ">
					<div class="panel-heading">
						<h3 class="panel-title">用户注册</h3>
					</div>

					<div class="panel-body">

						<form id="user" action='<c:url value="/user/regist"/>' role="form"
							method="post">
							<c:if test="${!empty error}">
								<p>${error}</p>
							</c:if>
							<spring:hasBindErrors name="user">
								<div class="alert alert-danger" role="alert">
									<c:forEach items="${errors.allErrors }" var="error">
										${error.defaultMessage}
										<br/>
									</c:forEach>
								</div>
							</spring:hasBindErrors>
							<div class="form-group">
								<label for="username">用户名：</label>
								<input type ="text" class="form-control" name="username"
									placeholder="请输入用户名" />
							</div>
							<div class="form-group">
								<label for="password">密码：</label>
								<input type ="password" class="form-control" name="password"
									placeholder="请输入密码" />
							</div>
							<input type="submit" class="btn btn-primary" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>