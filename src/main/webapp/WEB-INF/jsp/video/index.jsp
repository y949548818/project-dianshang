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
	<div class="container" />
		<div class="text-center">
		<video id ="video" src="<c:url value="/static/video/1.mp4"/>" controls="controls">
			您的浏览器不支持 video 标签。
		</video>
		</div>
	</div>	
	<script type="text/javascript">
		
		var bullets;
		//当前的弹幕的位置
		var bulletsIndex;
		var video=document.getElementById("video");
		$.get("<c:url value="/video/getbullet" />",{videoId:5,startTime:0,amount:100} ,function(data){
			  bullets=eval(data);
			  console.log(bullets);
		});
		video.onplay=function(){
			console.log("play from "+video.currentTime);
			var currentTime=video.currentTime;
			//TODO 从bullets中读取时间大于当前时间的
			for(var i=0;i<bullets.length;i++ ){
				if(bullets[i].videoTime>=currentTime)
				{
					bulletsIndex=i;
					console.log("bulletsIndex is "+bulletsIndex)
					break;
				}
			}
		}
		video.onpause=function(){
			console.log("pause to "+video.currentTime);
		}
		video.ontimeupdate=function(a){
			var currentTime=video.currentTime;
			console.log("currentTime is "+currentTime);
			for(var i=bulletsIndex;i<bullets.length;i++ ){
				if(currentTime>=bullets[i].videoTime-0.5){
					bulletsIndex++
					//TODO 按照mode来展示弹幕
					console.log(bullets[i].content)
				}
				else{
					break;
				}
			}
			
		}
	</script>
	
</body>
</html>