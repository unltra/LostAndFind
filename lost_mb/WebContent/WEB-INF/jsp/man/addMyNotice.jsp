<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>NIT失物招领系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />

<script language="javascript" type="text/javascript"
	src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
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
	
</script>
</head>
<body>
	<div style="height: 30px;"></div>
	<div class="container ">
		<div class="row col-md-6">
			<form action="${ctx}/addMyN" id="noticeForm" method="post"
				enctype="multipart/form-data" role="form">
				<!-- 隐藏表单，flag表示添加标记 -->
				<input type="hidden" name="flag" value="2">
				<div class="form-group">
					<label for="name">失物名称</label> <input type="text"
						class="form-control " name="lname" id="lname" size="10">
				</div>
				<div class="form-group">
    				<label class="sr-only" for="inputfile">上传图片</label>
    				<input type="file" id="inputfile" name="file">
  				</div>
				<div class="form-group">
				    <label for="name">选择列表</label>
				    <select name="kid"
							style="width: 143px;" class="form-control">
								<option value="0">--请选择类别--</option>
							<c:forEach items="${requestScope.kinds }" var="kind">
									<option value="${kind.kid }">${kind.kname }</option>
							</c:forEach>
						</select> 
				</div>
				<div class="form-group">
					<label for="name">丢失地点</label> <input type="text"
						class="form-control" name="lplace" id="lplace" size="20">
				</div>
				<div class="form-group">
					<label for="name">描述</label> <input type="text"
						class="form-control" name="ldescri" id="ldescri" size="20">
				</div>
				<div class="form-group">
					<label for="name">丢失时间</label> <input class="Wdate form-control"
						onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd '});"
						name="ltime" id="ltime" size="20" value="2017-11-11" />
				</div>

				<button type="submit" value="确认" id="submit" class="btn btn-default">确认</button>
				&nbsp;| &nbsp;
				<button type="reset" value="取消 " class="btn btn-default">取消</button>
			</form>
		</div>
	</div>
	<div style="height: 10px;"></div>

</body>
</html>