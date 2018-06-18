<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	<script language="javascript" type="text/javascript" src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
  
	$(function(){
		// 控制文档加载完成以后 选中
		$("#kid").val("${pick.kind.kid}");
		$("#aid").val("${pick.admin.aid}");

		
    	/** 表单提交 */
		$("#pickForm").submit(function(){
			alert(1);
			var pname = $("#pname");
			var ppic = $("#ppic");
			var pdescri = $("#pdescri");
			var pplace = $("#pplace");
			var ptime = $("#ptime");
			var ppersoninf = $("#ppersoninf");
			var pnowplace = $("#pnowplace");
			var poutstatus = $("#poutstatus");
			var pownstatus = $("#pownstatus");
			
			var msg = "";
			if ($.trim(pname.val()) == ""){
				msg = "名称不能为空！";
				pname.focus();
			}else if ($.trim(pdescri.val()) == ""){
				msg = "拾物描述不能为空！";
				pdescri.focus();
			}else if ($.trim(pplace.val()) == ""){
				msg = "拾获地址不能为空！";
				pplace.focus();
			}else if ($.trim(ptime.val()) == ""){
				msg = "拾获日期不能为空！";
				ptime.focus();
			}else if (!ptime.val()){
//					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
				msg = "拾获日期格式不正确！";
				ptime.focus();
			}else if ($.trim(ppersoninf.val()) == ""){
				msg = "拾获者信息不能为空！";
				ppersoninf.focus();
			}else if ($.trim(pplace.val()) == ""){
				msg = "现位地址不能为空！";
				pplace.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
			$("pickForm").submit();
		});
    });
		
	
	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：拾物管理  &gt; 修改拾物信息</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${ctx}/pick/updatePick" id="pickForm" method="post">
			<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
			<input type="hidden" name="pid" value="${pick.pid }">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		   			<tr>
		    			<td class="font3 fftd">拾物名称：<input type="text" name="pname" id="pname" value="${pick.pname }" size="20"/></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">图&nbsp;片：&nbsp;&nbsp;&nbsp;<input type="text" name="ppic" id="ppic" value="${pick.ppic }"size="20" /></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">描&nbsp;述：&nbsp;&nbsp;&nbsp;<input type="text" name="pdescri" id="pdescri" value="${pick.pdescri }"size="20"/></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">拾获地点：<input name="pplace" id="pplace" value="${pick.pplace }" size="20" /></td>
		    		</tr>
		    
		    		<tr>
						<td class="font3 fftd">
						拾获日期：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
								name="ptime" id="ptime" size="20"/>
						</td>
					</tr>
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
					
					
					    var a="${pick.ptime }";
					    var d=todate(a, "-");
					    document.getElementById("ptime").value=d;
   					</script>
					
		    		<tr>	
		    			<td class="font3 fftd">拾获者信息：<input name="ppersoninf" id="ppersoninf" value="${pick.ppersoninf }"size="20" /></td>
		    		</tr>
		    		<tr>	
		    			<td class="font3 fftd">现位地址：<input name="pnowplace" id="pnowplace" value="${pick.pnowplace }"size="20" /></td>
		    		</tr>
			<tr>
				<td class="font3 fftd">
					分类：
					<select  name="kid" style="width:100px;">
						   <option value="0">--分类选择--</option>
						   <c:forEach items="${requestScope.kinds }" var="kind">
						   		<c:choose>
			    					<c:when test="${pick.kind.kid == kind.kid }">
			    						<option value="${kind.kid }" selected="selected">${kind.kname }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${kind.kid }">${kind.kname }</option>
			    					</c:otherwise>
			    				</c:choose>
			    			</c:forEach>
					</select>
				</td>
			</tr>
				<tr>
				<td class="font3 fftd">发布状态：
								<select name="poutstatus" style="width:143px;">
					    			<option value="1">--默认发布--</option>
					    			<option value="0">不发布</option>
					    		</select>
				</td>
				</tr>
				<tr>
					<td class="font3 fftd">认领状态：
									<select name="pownstatus" style="width:143px;">
						    			<option value="0">--默认未认领--</option>
						    			<option value="1">已认领</option>
						    		</select>
					</td>
				</tr>
				<tr>
				<td class="font3 fftd">
					admin：
					<select  name="aid" style="width:100px;">
						   <option value="0">--admin选择--</option>
						   <c:forEach items="${requestScope.admins }" var="admin">
						   		<c:choose>
			    					<c:when test="${pick.admin.aid == admin.aid }">
			    						<option value="${admin.aid }" selected="selected">${admin.aname }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${admin.aid }">${admin.aname }</option>
			    					</c:otherwise>
			    				</c:choose>
			    			</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="修改">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>