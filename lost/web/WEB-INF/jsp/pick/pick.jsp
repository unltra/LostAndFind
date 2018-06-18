<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>NIT失物招领系统——pick管理</title>
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
	$(function() {
		/** 获取上一次选中的分类数据 */
		var boxs = $("input[type='checkbox'][id^='box_']");

		/** 给全选按钮绑定点击事件  */
		$("#checkAll").click(function() {
			// this是checkAll  this.checked是true
			// 所有数据行的选中状态与全选的状态一致
			boxs.attr("checked", this.checked);
		})

		/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
		$("tr[id^='data_']").hover(function() {
			$(this).css("backgroundColor", "#eeccff");
		}, function() {
			$(this).css("backgroundColor", "#ffffff");
		})

		/** 删除用户绑定点击事件 */
		$("#delete")
				.click(
						function() {
							/** 获取到用户选中的复选框  */
							var checkedBoxs = boxs.filter(":checked");
							if (checkedBoxs.length < 1) {
								$.ligerDialog.error("请选择一个需要删除的物品！");
							} else {
								/** 得到用户选中的所有的需要删除的ids */
								var pids = checkedBoxs.map(function() {
									return this.value;
								})

								$.ligerDialog
										.confirm(
												"确认要删除吗?",
												"删除pick",
												function(r) {
													if (r) {
														// alert("删除："+pids.get());
														// 发送请求
														window.location = "${ctx }/pick/removePick?pids="
																+ pids.get();
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
				src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：pick管理
				&gt; pick查询</td>
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
							<form name="pickform" method="post" id="pickform"
								action="${ctx}/pick/selectPick">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">类别： <select name="kid"
											style="width: 143px;">
												<option value="0">--请选择类别--</option>
												<c:forEach items="${requestScope.kinds }" var="kind">
													<option value="${kind.kid }">${kind.kname }</option>
												</c:forEach>
										</select> 
										</td>
									</tr>
									<tr>
										<td class="font3">拾获时间：<input type="text" name="ptime">
											admin：<select name="aid" style="width: 100px;">
												<option value="0">--admin选择--</option>
												<c:forEach items="${requestScope.admins }" var="admin">
													<option value="${admin.aid }">${admin.aname }</option>
												</c:forEach>
										</select>&nbsp; <input type="submit" value="搜索" /> <input id="delete"
											type="button" value="删除" />
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
						<td>拾物图片</td>
						<td>拾物名称</td>
						<td>拾获地点</td>
						<td>拾获时间</td>
						<td>类别</td>
						<td>详细描述</td>
						<td>拾获者信息</td>
						<td>创建管理员</td>
						<td>现位地址</td>
						<td>发布状态</td>
						<td>认领状态</td>
						<td>创建时间</td>
						<td align="center">操作</td>
					</tr>
					<c:forEach items="${requestScope.picks}" var="pick"
						varStatus="stat">
						<tr id="data_${stat.index}" class="main_trbg" align="center">
							<td><input type="checkbox" id="box_${stat.index}"
								value="${pick.pid}"></td>
							<td>${pick.ppic }</td>
							<td>${pick.pname }</td>
							<td>${pick.pplace }</td>
							<td><f:formatDate value="${pick.ptime}" type="date"
									dateStyle="long" /></td>
							<td>${pick.kind.kname }</td>
							<td>${pick.pdescri }</td>
							<td>${pick.ppersoninf }</td>
							<td>${pick.admin.aname }</td>
							<td>${pick.pnowplace }</td>
							<td><c:choose>
									<c:when test="${pick.poutstatus == 1 }">已发布</c:when>
									<c:otherwise>未发布</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${pick.pownstatus == 0 }">未认领</c:when>
									<c:otherwise>已认领</c:otherwise>
								</c:choose></td>
							<td><f:formatDate value="${pick.pcreatetime}" type="date"
									dateStyle="long" /></td>
							<td align="center" width="40px;"><a
								href="${ctx}/pick/updatePick?flag=1&pid=${pick.pid}"> <img
									title="修改" src="${ctx}/images/update.gif" /></a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<!-- 分页标签 -->
		<tr valign="top">
			<td align="center" class="font3">
			<topunltra:pager
					pageIndex="${requestScope.pageModel.pageIndex}"
					pageSize="${requestScope.pageModel.pageSize}"
					recordCount="${requestScope.pageModel.recordCount}" style="digg"
					submitUrl="${ctx}/pick/selectPick?pageIndex={0}" /></td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
</body>
</html>