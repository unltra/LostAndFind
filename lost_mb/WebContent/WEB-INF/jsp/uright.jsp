<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>		
	</head>
	<body>
		<table align="center">
			 
			 <tr>
			    
				<td class="main_locbg font2"><img src="${ctx}/images/icon/wuko.png">
				<br>
				<font  size="4">user：${sessionScope.user_session.uname}</font>
				<br>
				创建时间：<font color="red" size="2">
							<f:formatDate value="${sessionScope.user_session.ucreatetime}" 
								type="date" dateStyle="long"/>
								</font>
				</td>
			 
			
			</tr>
		</table>
		
		<div style="height:10px;"></div>
	</body>
</html>