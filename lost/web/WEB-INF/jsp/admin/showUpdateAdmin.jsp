<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>NIT失物招领系统——修改Admin</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	
	$(function(){
    	/** 员工表单提交 */
    
		$("#adminForm").submit(function(){
			var aname = $("#aname");
			var apower = $("#apower");
			var apw = $("#apw");
			var aqq = $("#aqq");
			var atel = $('#atel');
			var amail = $('#amail');
			var aphone = $('#aphone');
			var msg = "";
			if ($.trim(aqq.val()) == ""){
				msg = "QQ号不能为空！";
				aqq.focus();
			}else if ($.trim(apower.val()) == ""){
				msg = "权限值不能为空！";
				apower.focus();
			}else if ($.trim(aname.val()) == ""){
				msg = "登录名不能为空！";
				aname.focus();
			}else if ($.trim(apw.val()) == ""){
				msg = "密码不能为空！";
				apw.focus();
			}else if ($.trim(amail.val()) == ""){
				msg = "邮箱不能为空！";
				amail.focus();
			}else if ($.trim(atel.val()) == ""){
				msg = "座机号不能为空！";
				atel.focus();
			}else if ($.trim(aphone.val()) == ""){
				msg = "手机号不能为空！";
				aphone.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
			$("#adminForm").submit();
		});
    });
		

		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：admin管理  &gt; 修改admin</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${ctx}/admin/updateAdmin" id="adminForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
			<input type="hidden" name="aid" value="${admin.aid }">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">登录名：&nbsp;&nbsp;<input type="text" name="aname" id="aname"  size="20" value="${admin.aname }" /></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">密&nbsp;码：&nbsp;&nbsp;&nbsp;<input type="text" name="apw" id="apw" size="20" value="${admin.apw }" /></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">权&nbsp;限：&nbsp;&nbsp;&nbsp;<input type="text" name="apower" id="apower" size="20" value="${admin.apower }" /></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">座机电话：<input name="atel" id="atel" size="20" value="${admin.atel }" /></td>
		    		</tr>
		    
		    		<tr>	
		    			<td class="font3 fftd">手机号：&nbsp;&nbsp;<input name="aphone" id="aphone" size="20" value="${admin.aphone }" /></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">Q&nbsp;Q：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="aqq" id="aqq" size="20" value="${admin.aqq }" /></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">邮&nbsp;箱：&nbsp;&nbsp;&nbsp;<input name="amail" id="amail" size="20" value="${admin.amail }" /></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="修改 ">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>