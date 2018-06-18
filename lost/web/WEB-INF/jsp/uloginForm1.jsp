<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>NITlost</title>
<link href="${ctx}/log/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="App Loction Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements" />
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
<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
	<h1>NITLost ManageMent Sys</h1>
	<div class="app-location">
		<h2>Welcome to Lost</h2>
		<div class="line">
			<span></span>
		</div>
		<div class="location">
			<img src="${ctx}/log/images/location.png" class="img-responsive" alt="" />
		</div>
		<form action="ulogin.do" method="post" id="uloginForm">
			<input type="text" class="text" value="${uname }" id="uname" name="uname" placeholder="账号"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'admin account';}">
			<input type="password" value="${upw }" id="upw" name="upw" placeholder="密码"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Password';}">
			<div class="submit">
				<input type="submit" id="login-submit" value="Sign in">
			</div>
			<div class="clear"></div>
			<div class="new">
				<h3>
					<a href="#">Forgot password ?</a>
				</h3>
				<h4>
					<a href="#">New here ? Sign Up</a>
				</h4>
				<div class="clear"></div>
			</div>
		</form>
	</div>
	<!--start-copyright-->
	<div class="copy-right">
		<p>
			Copyright &copy; 2017 All rights Reserved | Template by &nbsp;<a
				href="http://www.unltra.top">unltrs.top.</a>
		</p>
	</div>
	<!--//end-copyright-->
</body>
</html>


