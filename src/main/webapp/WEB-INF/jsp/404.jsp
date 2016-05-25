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
		
	<div class="row">
		<div class="col-md-9 col-sm-9">
			<div class="panel panel-default">
				<div class="body">找不到指定内容</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    个人信息
                </div>
                <div class="panel-body">
                    
                </div>
            </div>
            <div class="panel panel-default">
                
                <div class="panel-body">
                    <a href="/post/create" type="button" class="btn btn-primary">
                        发布帖子
                    </a>
                </div>
            </div>
        </div>
	</div>
	
</div>
</body>
</html>