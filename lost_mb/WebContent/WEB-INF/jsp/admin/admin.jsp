<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>NIT失物招领系统——Admin管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css" />
<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js"
	type="text/javascript"></script>
<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js"
	type="text/javascript"></script>
<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss"
	type="text/javascript"></script>
<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />


<script type="text/javascript">
	$(
			function() {
				/** 获取上一次选中的部门数据 */
				var boxs = $("input[type='checkbox'][id^='box_']");

				/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
				$("tr[id^='data_']").hover(function() {
					$(this).css("backgroundColor", "#eeccff");
				}, function() {
					$(this).css("backgroundColor", "#ffffff");
				})

				/** 删除员工绑定点击事件 */
				$("#delete")
						.click(
								function() {
									/** 获取到用户选中的复选框  */
									var checkedBoxs = boxs.filter(":checked");
									if (checkedBoxs.length < 1) {
										$.ligerDialog.error("请选择一个需要删除的admin！");
									} else {
										/** 得到用户选中的所有的需要删除的ids */
										var aids = checkedBoxs.map(function() {
											return this.value;
										})

										$.ligerDialog
												.confirm(
														"确认要删除吗?",
														"删除admin",
														function(r) {
															if (r) {
																// alert("删除："+ids.get());
																// 发送请求
																window.location = "${ctx }/admin/removeAdmin?aids="
																		+ aids
																				.get();
															}
														});
									}
								})
			})
</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="15" height="32"><img
				src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img
				src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：admin管理
				&gt; admin查询</td>
			<td width="15" height="32"><img
				src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
		</tr>
	</table>

	<table width="100%" height="90%" border="0" cellpadding="5"
		cellspacing="0" class="main_tabbor">
		<!-- 查询区  -->
		<tr valign="top">
			<td height="30">
				<table width="100%" border="0" cellpadding="0" cellspacing="10"
					class="main_tab">
					<tr>
						<td class="fftd">
							<form name="empform" method="post" id="empform"
								action="${ctx}/admin/selectAdmin">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">admin：<input type="text" name="aname">
											admin权限值：<input type="text" name="apower"> <input
											type="submit" value="搜索" /> <input id="delete" type="button"
											value="删除" />
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<table width="100%" border="1" cellpadding="5" cellspacing="0"
					style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr class="main_trbg_tit" align="center">
						<td><input type="checkbox" name="checkAll" id="checkAll"></td>
						<td>admin</td>
						<td>密码</td>
						<td>权限值</td>
						<td>座机电话</td>
						<td>手机号</td>
						<td>QQ</td>
						<td>邮箱</td>
						<td>创建时间</td>
						<td align="center">操作</td>
					</tr>
					<c:forEach items="${requestScope.admins}" var="admin"
						varStatus="stat">
						<tr id="data_${stat.index}" align="center" class="main_trbg"
							onMouseOver="move(this);" onMouseOut="out(this);">
							<td><input type="checkbox" id="box_${stat.index}"
								value="${admin.aid}"></td>
							<td>${admin.aname }</td>
							<td>${admin.apw }</td>

							<td>${admin.apower }</td>
							<td>${admin.atel }</td>
							<td>${admin.aphone }</td>
							<td>${admin.aqq }</td>
							<td>${admin.amail }</td>
							<td><f:formatDate value="${admin.acreatetime}" type="date"
									dateStyle="long" /></td>
							<td align="center" width="40px;"><a
								href="${ctx}/admin/updateAdmin?flag=1&aid=${admin.aid}"> <img
									title="修改" src="${ctx}/images/update.gif" /></a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<!-- 分页标签 -->
		<tr valign="top">
			<td align="center" class="font3"><topunltra:pager
					pageIndex="${requestScope.pageModel.pageIndex}"
					pageSize="${requestScope.pageModel.pageSize}"
					recordCount="${requestScope.pageModel.recordCount}" style="digg"
					submitUrl="${ctx}/admin/selectAdmin?pageIndex={0}" /></td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
</body>
</html>