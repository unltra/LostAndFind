<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>NITLost ——后台登录</title>
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

<script type="text/javascript">
    /** 文档加载完成后立即执行的方法 */
    // var weeks = new Array();
	
    $(function(){
    	$("#exit").click(function(){
    		/** parent从主界面进行退出,避免局部刷新*/
    		/* var aname = ${sessionScope.admin_session.aname}; */
    		parent.location = "${ctx}/ulogout";
    		
    	})
	})
	
	$(function(){
    	$("#home").click(function(){
    		/** parent从主界面进行退出,避免局部刷新*/
    		/* var aname = ${sessionScope.admin_session.aname}; */
    		parent.location = "${ctx}/showPick";
    		
    	})
	})
	
    
    
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="320" height="80" class="topbg"><img src="${ctx}/images/icon/nitlost.png" width="320" height="80"></td>
	<td class="topbg">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	    <tr>
		  <td height="50" class="toplink" align="right">
		  <img src="${ctx}/images/icon/boy.png" height="30" width="30">
		  Welcome 【<c:out value="${sessionScope.user_session.uname}" default="游客一枚" />】&nbsp;&nbsp;
		  <img src="${ctx}/images/icon/home.png" height="30" width="30">&nbsp;&nbsp;
		  <a href="javascript:void(0);" id="home">home</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <img src="${ctx}/images/icon/exit1.png" height="30" width="30">&nbsp;&nbsp;
		  <a href="javascript:void(0);" id="exit">exit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		
	  </table>
	</td>
  </tr>
</table>
</body>
</html>