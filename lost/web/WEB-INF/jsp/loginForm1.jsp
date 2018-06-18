<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>登录-后台管理系统</title>
<meta name="keywords"  content="设置关键词..." />
<meta name="description" content="设置描述..." />
<meta name="author" content="DeathGhost" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name='apple-touch-fullscreen' content='yes'>
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="address=no">
<link rel="icon" href="images/icon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${ctx}/new/css/style.css" />
<script src="${ctx}/new/javascript/jquery.js"></script>
<script src="${ctx}/new/javascript/public.js"></script>
<script src="${ctx}/new/javascript/plug-ins/customScrollbar.min.js"></script>
<script src="${ctx}/new/javascript/pages/login.js"></script>
<script type="text/javascript">
   
   $(function(){
	    /** 按了回车键 */
	   $(document).keydown(function(event){
		   if(event.keyCode == 13){
			   $("#login-submit").trigger("click");
		   }
	   })

	   /** 给登录按钮绑定点击事件  */
	   $("#login-submit").on("click",function(){
		   /** 校验登录参数 ctrl+K */
		   var loginname = $("#aname").val();
		   var password = $("#apw").val();
		   
		   var msg = "";
		   
		   if(!/^\w{4,20}$/.test(loginname)){
			     msg = "登录名长度必须是6~20之间";
		   }else if(!/^\w{4,20}$/.test(password)){
			     msg = "密码长度必须是6~20之间";
		   }
		   if(msg !=""){
			   $.ligerDialog.error(msg);
			   return;
		   }
		   /** 提交表单 */
		   $("#loginForm").submit();
		   
	   })
	   
   })
 
</script>
</head>
<body class="login-page">
	<section class="login-contain">
		<header>
			<h1>失物招领后台管理系统</h1>
			<p>management system</p>
		</header>
		<form action="login" method="post" id="loginForm">
		<div class="form-content">
			<ul>
				<li>
					<div class="form-group">
						<label class="control-label">管理员账号：</label>
						<input type="text" placeholder="管理员账号" class="form-control form-underlined" id="aname" name="aname" value="${aname}"/>
					</div>
				</li>
				<li>
					<div class="form-group">
						<label class="control-label">管理员密码：</label>
						<input type="password" placeholder="管理员密码" class="form-control form-underlined" id="apw" name="apw" value="${apw}"/>
					</div>
				</li>
				
				<li>
					<button class="btn btn-lg btn-block" id="login-submit">立即登录</button>
				</li>
				<li>
					<p class="btm-info">©Copyright 2017-2018 <a href="http://www.unltra.top" target="_blank" title="unltra.top">unltra.top</a></p>
					<address class="btm-info"></address>
				</li>
			</ul>
		</div>
	</form>
	</section>
<div class="mask"></div>
<div class="dialog">
	<div class="dialog-hd">
		<strong class="lt-title">标题</strong>
		<a class="rt-operate icon-remove JclosePanel" title="关闭"></a>
	</div>
	<div class="dialog-bd">
		<!--start::-->
		<p>这里是基础弹窗,可以定义文本信息，HTML信息这里是基础弹窗,可以定义文本信息，HTML信息。</p>
		<!--end::-->
	</div>
	<div class="dialog-ft">
		<button class="btn btn-info JyesBtn">确认</button>
		<button class="btn btn-secondary JnoBtn">关闭</button>
	</div>
</div>
</body>
</html>
