<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>发布帖子</title>
<%@ include file="/WEB-INF/include/header.jsp"%>
<script type="text/javascript" charset="utf-8"
	src="<c:url value="/static/ueditor/ueditor.config.js" />"></script>

<script type="text/javascript" charset="utf-8"
	src="<c:url value="/static/ueditor/ueditor.all.min.js" />"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="<c:url value="/static/ueditor/lang/zh-cn/zh-cn.js" />"></script>

</head>
<body>
	<%@ include file="/WEB-INF/include/nav.jsp"%>
	<div class="container">
		<div class="row">
			
				<form action="<c:url value="/post/publish"/>"  method="post" role="form" id="form">
					<div class="form-group">
						<label for="name">标题</label>
						<input type="text" class="form-control" id="title"  name ="title"
						   placeholder="请输入标题">
					</div>
					
					<script id="container" name="content" type="text/plain"  style="width:100%">
       
   					 </script>
   					 <input type="submit" class="btn"/>
				</form>
			
		</div>
	</div>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container',{
            initialFrameWidth : $("#form").width(),
            initialFrameHeight: 600,
        });
        $('#edui1').attr("style","width:100%; z-index: 999;");
        
        console.log(''+$("#form").width());
        console.log(''+$("window").height());
        $(window).resize(function () {          //当浏览器大小变化时
        	$('#edui1').attr("style","width:100%; z-index: 999;");
 
        });
    </script>
</body>
</html>