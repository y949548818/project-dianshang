<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" 
         data-target="#example-navbar-collapse">
         <span class="sr-only">切换导航</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">MyWeb</a>
   </div>
   <div class="collapse navbar-collapse" id="example-navbar-collapse">
      <ul class="nav navbar-nav navbar-right ">
         <c:choose>
         
			<c:when test="${ not empty sessionScope.user }">
	            <li class="active"><a href="/">首页</a></li>
	            <li><a href="<c:url value="/message" />">未读消息</a></li>
	            <li><a href="<c:url value="/start" />">新手入门</a></li>
	            <li><a href="<c:url value="/API" />">API</a></li>
	            <li><a href="<c:url value="/about" />">关于</a></li>
	            <li><a href="<c:url value="/user/setting" />">设置</a></li>
	            <li><a href="<c:url value="/user/logout" />">退出</a></li>
         	</c:when>
         	<c:otherwise>
	            <li class="active"><a href="/">首页</a></li>
	            <li><a href="<c:url value="/start" />">新手入门</a></li>
	            <li><a href="<c:url value="/API" />">API</a></li>
	            <li><a href="<c:url value="/user/register" />">注册</a></li>
	            <li><a href="<c:url value="/user/login" />">登录</a></li>
            </c:otherwise>
		</c:choose>
      </ul>
   </div>
</nav>