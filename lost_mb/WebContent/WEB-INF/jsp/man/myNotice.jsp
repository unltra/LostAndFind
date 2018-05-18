<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<title>App</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!--第一步：引入Javascript / CSS （CDN）-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>

<script type="text/javascript">
<!--第三步：初始化Datatables-->
$(document).ready( function () {
    $('#table_id_example').DataTable();
} );
</script>
</head>




<!--第二步：添加如下 HTML 代码-->
<table id="table_id_example" class="display">
	<thead>
		<tr>
			<th><input type="checkbox" name="checkAll" id="checkAll"></th>
			<th>失物图片</th>
			<th>失物名称</th>
			<th>失物地点</th>
			<th>丢失时间</th>
			<th>类别</th>
			<th>详细描述</th>
			<th>发布状态</th>
			<th>创建时间</th>
			<th>编辑</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.notices}" var="notice" varStatus="stat">
			<tr id="data_${stat.index}" class="main_trbg" align="center">
				
				<td><input type="checkbox" id="box_${stat.index}"
					value="${notice.lid}"></td>
				<td>${notice.lpic }</td>
				<td>${notice.lname }</td>
				<td>${notice.lplace }</td>
				<td><f:formatDate value="${notice.ltime}" type="date"
						dateStyle="long" /></td>
				<td>${notice.kind.kname }</td>
				<td>${notice.ldescri }</td>
				
				<td><c:choose>
						<c:when test="${notice.loutstatus == 1 }">已发布</c:when>
						<c:otherwise>未发布</c:otherwise>
					</c:choose></td>
				<td><f:formatDate value="${notice.lcreatetime}" type="date"
						dateStyle="long" /></td>
				<td><a href="${ctx }/editNotice?lid=${notice.lid}">编辑</a> | 
				<a href="${ctx }/delNotice?lid=${notice.lid}">删除</a></td>
			</tr>
		</c:forEach>

	</tbody>
</table>


</html>





