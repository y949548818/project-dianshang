<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/header.jsp"%>
<style type="text/css" media="screen">
	.bullet{
		position: absolute;
		right: 0px;
		top: 0px;
		display:none;
	}	
	#video-wrap{
		box-sizing: border-box;
    	position: relative;
    	width: 80%;
    	margin: 0px auto;
    	overflow: hidden;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/include/nav.jsp"%>
	<div class="container" />
		<div id="video-wrap">
			<video id ="video" src="<c:url value="/static/video/1.mp4"/>"  controls="controls" width="100%">
			您的浏览器不支持 video 标签。

			</video>
			<!-- <div class="bullet">
				
			</div> -->
		</div>
	</div>	

	<script type="text/javascript">
		window.onload=function(){
		var bullets;
		//当前的弹幕的位置
		var bulletsIndex;
		
		var videoWrap=$('#video-wrap');
		//弹幕池对象
		var bulletPool=new BulletPool({poolSize:1});
		//弹幕的类
		function Bullet(config){
			config=config||{};
			var _bullet=$('<p class="bullet"></p>');
			var _bulletWidth;
			var _finished=config.finished||function(){console.log('默认的finished函数')};
			this.self=_bullet;
			this.html=function(h){
				_bullet.html(h);
			}
			//表示是否正在使用
			var _isUsing=false;
			this.isUsing=function(){
				return _isUsing;
			}
			//初始化
			this.init=function(config){
				config=config||{};
				_isUsing=true;
				 _bulletWidth=_bullet.width();
				
				console.log('_bulletWidth is '+_bullet.width()+" and html()is "+_bullet.html());
				_bullet.css({"right":-_bulletWidth,"display":"inline","left":""});
			}
			//开始移动
			this.start=function(){
				_bullet.animate({"right":videoWrap.width()/2},5000,"linear",function(){
					_bullet.css({"left":videoWrap.width()/2-_bulletWidth,"display":"inline",right:""});
					_bullet.animate({"left":-_bulletWidth},5000,"linear",function(){
						
						_bullet.css({"display":"none"});
						_isUsing=false;
						//回调函数表示使用完毕
						_finished();
					})
				});
			}
		}
		//弹幕池的类
		function BulletPool(config){
			var _pool=[];
			//当前的下标
			var _index=0;

			config=config||{};
			var poolSize=config.poolSize||100;
			var _using=0;
			for(var i=0;i<poolSize;i++){
				_pool.push(new Bullet({finished:function(){
					_using--;
				}}));
			}
			
			this.getBullet=function(){
				
				if(_using>=poolSize){
					console.log('弹幕池容量不足。新增一个');
					_pool.push(new Bullet({finished:function(){
						_using--;
					}}));
					poolSize++;
					_using++;
					return _pool[poolSize-1];
				}
				_using++;
				while(true){
					if(!_pool[_index].isUsing()){
						return _pool[_index];
					}
					else{
						_index++;
					}
					
				}
				
			}
			this.getBulletByIndex=function(i){
				return _pool[i];
			}
		}
		var video=document.getElementById("video");
		$.get("<c:url value="/video/getbullet" />",{videoId:5,startTime:0,amount:100} ,function(data){
			  bullets=eval(data);
			  //console.log(bullets);
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
			//console.log("currentTime is "+currentTime);
			for(var i=bulletsIndex;i<bullets.length;i++ ){
				if(currentTime>=bullets[i].videoTime-0.5){
					bulletsIndex++
					//TODO 按照mode来展示弹幕
					launchBullet(bullets[i]);
					console.log("lanunch bullet "+bullets[i].content)
				}
				else{
					break;
				}
			}
			
		}
		//发射弹幕 
		function launchBullet(bullet){
			//从右往左
			if(bullet.mode==1){
				console.log("this bullet's mode  is 1");
				var newBullet=bulletPool.getBullet();
				newBullet.html(bullet.content);
				
				videoWrap.append(newBullet.self);
				newBullet.init();
				newBullet.start();
				//console.log(newBullet.self)
			}
			//出现在上方
			else if(bullet.mode==2){
				
			}
			//出现在下方
			else if(bullet.mode==3){
				
			}
		}
		}
	</script>
	
</body>
</html>