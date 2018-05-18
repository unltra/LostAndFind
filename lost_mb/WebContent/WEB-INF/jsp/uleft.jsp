<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
		<script src="${ctx }/layui/layui.js"></script>
		
	</head>
<body>
	<div class="layui-side">
		
			<div class="layui-side-scroll">
			<br>
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item "><a class=""
						href="javascript:;">管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="${ctx}/addNotice" target="umain">发布失物公告</a>
							</dd>
							<dd>
								<a href="${ctx}/MyNotice" target="umain">我的失物公告</a>
							</dd>
							<dd>
								<a href="picks" target="umain">所有拾物</a>
							</dd>
							<dd>
								<a href="javascript:;">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">解决方案</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="${ctx}/addNotice" target="umain">发布失物公告</a>
							</dd>
							<dd>
								<a href="${ctx}/MyNotice" target="umain">我的失物公告</a>
							</dd>
							<dd>
								<a href="picks" target="umain">所有拾物</a>
							</dd>
							<dd>
								<a href="javascript:;">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="${ctx}/UserInfo" target="umain"">个人信息</a></li>
					<li class="layui-nav-item"><a href="${ctx}/addNotice" target="umain">发布失物公告</a></li>
				</ul>
			</div>
		</div>
	<script>
		//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
	</script>
</body>
</html>