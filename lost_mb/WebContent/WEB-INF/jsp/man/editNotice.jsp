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

<script language="javascript" type="text/javascript" src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
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
			<form action="${ctx}/changeNotice" id="noticeForm" method="post"
				role="form">
				<!-- 隐藏表单，flag表示添加标记 -->
				<input type="hidden" name="flag" value="2"> <input
					type="hidden" name="lid" value="${notice.lid }">
				<div class="form-group">
					<label for="name">登录名</label> <input type="text"
						class="form-control " name="lname" id="lname" size="10"
						value="${notice.lname }">
				</div>
				<div class="form-group">
					<label for="name">图片</label> <input type="text"
						class="form-control " name="lpic" id="lpic" size="10"
						value="${notice.lpic }">
				</div>
				<div class="form-group">
					<label for="name"></label> <img src="${ctx }/upload/${notice.lpic }" height="140" width="140" class="img-thumbnail"/>
				</div>
				
				<div class="form-group">
					<label for="name">丢失地点</label> 
					<input type="text"
						class="form-control" name="uphone" id="uphone" size="20"
						value="${notice.lplace }">
				</div>
				<div class="form-group">
					<label for="name">描述</label> <input type="text"
						class="form-control" name="ldescri" id="ldescri" size="20"
						value="${notice.ldescri }">
				</div>
				<div class="form-group">
					<label for="name">丢失时间</label> <input class="Wdate form-control" 
					onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
								name="ltime" id="ltime" size="20"/>
				</div>


				
				
				<button type="submit" value="修改 " id="submit"
					class="btn btn-default">修改</button>
				&nbsp;| &nbsp;<button type="reset" value="取消 " class="btn btn-default">取消</button>
			</form>
		</div>
	</div>
	<div style="height: 10px;"></div>
	<script>
		function todate(inputstr, showsplit) {
					     //Wed Mar 22 13:38:37 CST 2017
					        inputstr = inputstr + ""; //末尾加一个空格
					        var date = "";
					        var month = new Array();
					        var week = new Array();
					        
					        month["Jan"] = 1; month["Feb"] = 2; month["Mar"] = 3; month["Apr"] = 4; month["May"] = 5; month["Jan"] = 6; 
					        month["Jul"] = 7; month["Aug"] = 8; month["Sep"] = 9; month["Oct"] = 10; month["Nov"] = 11; month["Dec"] = 12;
					        
					        
					        str = inputstr.split(" ");
					        
					        date = str[5];
					        date += showsplit + month[str[1]] + showsplit + str[2];
					        
					                
					        return date;
					    }
					
					
					    var a="${notice.ltime }";
					    var d=todate(a, "-");
					    document.getElementById("ltime").value=d;
   					</script>
</body>
</html>