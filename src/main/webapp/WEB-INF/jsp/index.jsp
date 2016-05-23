<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/header.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/include/nav.jsp" %>

<div class="container">
	<div class="row">
		<div class="jumbotron">
			<h1>welcome to my web</h1>
			<p>这是一个网站</p>

			
			<p>
				<a class="btn btn-primary" href='<c:url value="/user/login" />'>登录</a>
				<a class="btn btn-lg" href='<c:url value="/user/regist" />'>注册</a>
			</p>
		</div>
	</div>
	<div class="row">
		<tags:pager page="${page}"></tags:pager>
	</div>
	
</div>
</body>
</html>