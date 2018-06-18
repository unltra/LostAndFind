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

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(function() {
		/** 员工表单提交 */

		$("#userForm").submit(function() {
			var uname = $("#uname");
			var stuid = $("#stuid");
			var upw = $("#upw");
			var uqq = $("#uqq");
			var uaddress = $('#uaddress');
			var umail = $('#umail');
			var uphone = $('#uphone');
			var msg = "";
			if ($.trim(uname.val()) == "") {
				msg = "登录名不能为空！";
				aname.focus();
			} else if ($.trim(upw.val()) == "") {
				msg = "密码不能为空！";
				upw.focus();
			} else if ($.trim(stuid.val()) == "") {
				msg = "学号不能为空！";
				apower.focus();
			} else if ($.trim(uphone.val()) == "") {
				msg = "手机号不能为空！";
				aphone.focus();
			} else if ($.trim(uqq.val()) == "") {
				msg = "QQ号不能为空！";
				aqq.focus();
			} else if ($.trim(umail.val()) == "") {
				msg = "邮箱不能为空！";
				amail.focus();
			} else if ($.trim(uaddress.val()) == "") {
				msg = "地址不能为空！";
				uaddress.focus();
			}
			if (msg != "") {
				$.ligerDialog.error(msg);
				return false;
			} else {
				return true;
			}
			$("#userForm").submit();
		});
	});
</script>
</head>
<body>
	<div style="height: 30px;"></div>
	<div class="container ">
		<div class="row col-md-6">
			<form action="${ctx}/changeUser" id="userForm" method="post"
				role="form">
				<!-- 隐藏表单，flag表示添加标记 -->
				<input type="hidden" name="flag" value="2"> <input
					type="hidden" name="uid" value="${user.uid }">
				<div class="form-group">
					<label for="name">登录名</label> <input type="text"
						class="form-control " name="uname" id="uname" size="10"
						value="${user.uname }">
				</div>
				<div class="form-group">
					<label for="name">密码</label> <input type="text"
						class="form-control" name="upw" id="upw" size="20"
						value="${user.upw }">
				</div>
				<div class="form-group">
					<label for="name">学号</label> <input type="text"
						class="form-control" name="stuid" id="stuid" size="20"
						value="${user.stuid }">
				</div>
				<div class="form-group">
					<label for="name">手机</label> <input type="text"
						class="form-control" name="uphone" id="uphone" size="20"
						value="${user.uphone }">
				</div>
				<div class="form-group">
					<label for="name">QQ</label> <input type="text"
						class="form-control" name="uqq" id="uqq" size="20"
						value="${user.uqq }">
				</div>
				<div class="form-group">
					<label for="name">邮箱</label> <input type="text"
						class="form-control" name="umail" id="umail" size="20"
						value="${user.umail }">
				</div>
				<div class="form-group">
					<label for="name">地址</label> <input type="text"
						class="form-control" name="uaddress" id="uaddress" size="20"
						value="${user.uaddress }">
				</div>

				<button type="submit" value="修改 " id="submit"
					class="btn btn-default">修改</button>
				&nbsp;| &nbsp;<button type="reset" value="取消 " class="btn btn-default">取消</button>
			</form>
		</div>
	</div>
	<div style="height: 10px;"></div>
</body>
</html>