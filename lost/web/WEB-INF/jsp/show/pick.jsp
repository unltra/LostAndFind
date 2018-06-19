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
</head>
<body>
	

	<table width="100%" height="90%" border="0" cellpadding="5"
		cellspacing="0" class="main_tabbor">
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