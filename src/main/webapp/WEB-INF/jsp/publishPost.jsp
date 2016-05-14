<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>发布帖子</title>
<%@ include file="/WEB-INF/include/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/include/nav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<form action="" role="form">
					<div class="form-group">
						<label for="title">名称</label>
						<input type="text" class="form-control" id="title" placeholder="请输入标题" name="title" />
					</div>
					<div class="form-group">
						<label for="content">内容</label>
						<textarea name="content" id="content" cols="30" rows="10" class="form-control" row="3"></textarea>
					</div>
					<input type="submit" class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>

</body>
</html>