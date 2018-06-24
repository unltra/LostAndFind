<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户登录</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx }/css/login.css" media="all" />
	<script type="text/javascript">
	$(function() {
		/** 按了回车键 */
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				$("#login-submit").trigger("click");
			}
		})

		/** 给登录按钮绑定点击事件  */
		$("#login-submit").on("click", function() {
			/** 校验登录参数 ctrl+K */
			var loginname = $("#uname").val();
			var password = $("#upw").val();

			var msg = "";

			if (!/^\w{4,20}$/.test(loginname)) {
				msg = "登录名长度必须是6~20之间";
			} else if (!/^\w{4,20}$/.test(password)) {
				msg = "密码长度必须是6~20之间";
			}
			if (msg != "") {
				$.ligerDialog.error(msg);
				return;
			}
			/** 提交表单 */
			$("#uloginForm").submit();

		})

	})
	</script>
</head>
<body>
	<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920">
	    <source src="${ctx }/images/login.mp4" type="video/mp4">
	   
	</video>
	<div class="video_mask"></div>
	<div class="login">
	    <h1>用户登录</h1>
	    <form class="layui-form" action="ulogin.do" method="post" id="uloginForm">
	    	<div class="layui-form-item">
				<input class="layui-input" value="${uname }" id="uname" name="uname"  placeholder="账户" lay-verify="required" type="text" autocomplete="off">
		    </div>
		    <div class="layui-form-item">
				<input class="layui-input" value="${upw }" id="upw" name="upw" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		    </div>
		    
			<button class="layui-btn login_btn" lay-submit="" id="login-submit" lay-filter="login">登录</button>
			<div style="height: 40px;"></div>
			<div align="right"><a href="${ctx }/register"><i style="color:white; fontsize:5">没有账户</i></a></div>
		</form>
	</div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/login.js"></script>
</body>
</html>