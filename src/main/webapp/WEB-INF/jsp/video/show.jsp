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
			//弹幕的宽度
			var _bulletWidth;
			var _finished=config.finished||function(){console.log('默认的finished函数')};
			//弹幕的模式
			var _mode=1;
			//弹幕的内容
			var _content;
			//弹幕的颜色
			var _color;
			
			this.self=_bullet;
			
			this.html=function(h){
				_bullet.html(h);
			}
			//表示是否正在使用
			var _isUsing=false;
			this.setUsing=function(state){
				_isUsing=state;
			}
			this.isUsing=function(){
				return _isUsing;
			}
			//TODO初始化
			this.init=function(config){
				config=config||{};
				_bulletWidth=_bullet.width();
				_mode=config.mode;
				_content=config.content;
				_color=config.color;
				_bullet.html(_content);
			}
			//开始移动
			this.start=function(){
				_bulletWidth=_bullet.width();
				
				switch(_mode){
				//从右到左
				case 1:
					//console.log('_bulletWidth is '+_bullet.width()+" and html()is "+_bullet.html());
					//TODO这里先把top设为0，以后会设置成随机
					_bullet.css({"top":"0px","right":-_bulletWidth,"display":"inline","left":"","color":"#"+_color.toString(16)});
					_bullet.animate({"right":videoWrap.width()/2},5000,"linear",function(){
						_bullet.css({"left":videoWrap.width()/2-_bulletWidth,"display":"inline",right:""});
						_bullet.animate({"left":-_bulletWidth},5000,"linear",function(){
							
							console.log("一个动画完成");
							_bullet.css({"display":"none",
								"left":"",
								"right":"",
								"opacity":"",
								"top":"",
								"bottom":""});
							_isUsing=false;
							//回调函数表示使用完毕
							_finished();
						});
					});
					break;
				//top
				case 2:
					console.log('mode is 2 正在')
					//console.log('_bulletWidth is '+_bullet.width()+" and html()is "+_bullet.html());
					_bullet.css({"top":"0px","right":videoWrap.width()/2,"display":"inline","left":"","color":"#"+_color.toString(16),"opacity":"1"});
					_bullet.animate({"opacity":"1"},5000,"linear",function(){
						console.log("一个动画完成");
						_bullet.css({"display":"none",
							"left":"",
							"right":"",
							"opacity":"",
							"color":"",
							"top":"",
							"bottom":""});
						_isUsing=false;
						//回调函数表示使用完毕
						_finished();
					});
					break;
				//bottom
				case 3:
					console.log('mode is 2 正在')
					//console.log('_bulletWidth is '+_bullet.width()+" and html()is "+_bullet.html());
					_bullet.css({"bottom":"0px","right":videoWrap.width()/2,"display":"inline","left":"","color":"#"+_color.toString(16),"opacity":"1"});
					_bullet.animate({"opacity":"1"},5000,"linear",function(){
						console.log("一个动画完成");
						_bullet.css({"display":"none",
							"left":"",
							"right":"",
							"opacity":"",
							"color":"",
							"top":"",
							"bottom":""});
						_isUsing=false;
						//回调函数表示使用完毕
						_finished();
					});
					break;
				}
				
			}
		}
		//弹幕池的类
		function BulletPool(config){
			var _pool=[];
			//当前的下标
			//var _index=0;

			config=config||{};
			var poolSize=config.poolSize||100;
			var _useCount=0;
			for(var i=0;i<poolSize;i++){
				_pool.push(new Bullet({finished:function(){
					_useCount--;
				}}));
			}
			
			this.getBullet=function(){
				//池
				console.log("usingAmount is "+_useCount);
				
				if(_useCount>=poolSize){
					console.log("用完了  "+_useCount);		
					var b=new Bullet({finished:function(){
						_useCount--;
					}});
					_useCount++;
					_pool.push(b);
					b.setUsing(true);
					return b;
				}
				
				for(var i=0;i<_pool.length;i++){
					if(!_pool[i].isUsing()){
						_pool[i].setUsing(true)
						_useCount++;
						return _pool[i];
					}
				}
				
			}
			this.getBulletByIndex=function(i){
				return _pool[i];
			}
			//所有弹幕都停止
			this.pause=function(){
				console.log('正在暂停');
				for(var i=0;i<_pool.length;i++){
					_pool[i].self.stop(true,true);
				}
				for(var i=0;i<_pool.length;i++){
					_pool[i].self.stop(true,true);
				}
				
			}
			//所有的弹幕都开始
			this.play=function(){
				console.log('正在开始');

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
			bulletPool.pause();
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

			console.log("this bullet's mode  is 1");
			var newBullet=bulletPool.getBullet();
			//newBullet.html(bullet.content);
			
			videoWrap.append(newBullet.self);
			newBullet.init(bullet);
			newBullet.start();
			//console.log(newBullet.self)

		}
	}
	</script>
	
</body>
</html>