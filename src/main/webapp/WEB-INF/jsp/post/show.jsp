<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/include/header.jsp"%>
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/include/nav.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-9 col-sm-9">
                <div class="panel panel-default">
                	<div class="panel-heading">
                		<div class="row">
                			<span class="label-green">测试</span>
                		
                				${post.title }
                			
                		</div>
                		<div class="row">
                			
                		</div>
                	</div>
					<div class="panel-body">
						${post.content }
					</div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3">

            </div>

        </div>
    </div>
</body>
</html>