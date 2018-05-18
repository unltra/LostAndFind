<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
        <a class="navbar-brand" href="#">NITLost</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
            <li><a href="${ctx}/showPick">拾物</a></li>
          </ul>
          
          
          <ul class="nav navbar-nav">
            <li><a href="${ctx}/showNotice">失物公告</a></li>
          </ul>
          
          <ul class="nav navbar-nav">
            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">管理<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 管理</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 管理</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 管理</a></li>
                </ul>
            </li>
          </ul>
         
          <ul class="nav navbar-nav navbar-right">
                <c:choose>
          				<c:when test="${empty sessionScope.user_session.uname}">
	                        <li>
	                             <a href="${ctx }/register">注册</a>
	                        </li>
	                        <li>
	                             <a href="${ctx }/uloginForm">登录</a>
	                        </li>
                        </c:when>
                        <c:otherwise>
                        	<li>
	                             <a href="#">Welcome,<c:out value="${sessionScope.user_session.uname}" default="游客一枚" /></a>
	                        </li>
                        	<li><a href="${ctx }/umain">个人中心</a>
                        </c:otherwise>
                </c:choose>
                        <li class="dropdown" style="display:none">
                             <a href="#" class="dropdown-toggle" data-toggle="dropdown">用户<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                     <a href="#">登录</a>
                                </li>
                                <li>
                                     <a href="#">注册</a>
                                </li>
                                <li>
                                     <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                     <a href="#">Separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
          
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>
    <br>
    <br>
    <br>
    <br>
    <br>
    
	<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <div class="row clearfix">
                <div class="col-md-8 column">
                    <h2>
                      		  失物公告
                    </h2>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                    </p>
                    <p>
                         <a class="btn" href="#">View details »</a>
                    </p>
                </div>
                <div class="col-md-4 column">
                    <div class="alert alert-success alert-dismissable">
                         <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>
                            注意!
                        </h4><h3><strong>发布失物公告前请先注册并登陆.</strong></h3><br><a href="#" class="alert-link">登陆</a>
                    </div>
                     
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-8 column well">
                  
                        
                            <ul class="media-list ">
                            <c:forEach items="${requestScope.notices}" var="notice"
									varStatus="stat">
                                <li class="media">
                                    <a class="media-left" href="#">
                                        <img class="media-object img-rounded thumbnail" src="${ctx}/upload/${notice.lpic }"
                                             alt="通用的占位符图像" height="120px;" width="160px">
                                    </a>
                                    <div class="media-body" height="100px;">
                                        <h4><strong><a href="#" class="item-title">${notice.lname }</a></strong></h4>   
                                        <p>
                                        <span class="gray">编号(ID)：</span>NI${notice.lid}<br>
                                        <span class="gray">丢失地点：</span>${notice.lplace }<br>
                                        <span class="gray">描&nbsp;&nbsp;述：</span>${notice.ldescri }
                                        </p>
                                        <i class="icon-calendar" title="date"></i> <a href="#">n 天前发布</a>
                                       <i class="icon-briefcase" title="ltime" >丢失时间：</i><f:formatDate value="${notice.ltime}" type="date"
									dateStyle="long" />
                                       
                                    </div>
                      
                                </li>
                                <hr class="sep">
                                </c:forEach>
                            </ul>
                    
                </div>
               
                <div class="col-md-4 column">
                 <div class="container-fluid">
      <div class="row-fluid">
           <div class="span4" id="sidebar-container">
           <div class="well">
            <h4>搜索站内</h4>
            <form name="search_form" action="${ctx}/showNotice" method="post">
            <div class="input-group">
              <input type="text" class="form-control" name="lname" id="lname" height="20px">
              <span class="input-group-btn">
                <button class="btn btn-default" type="submit" height="20px"><span class="glyphicon glyphicon-search" ></span></button>
              </span>
            </div><!-- /input-group -->
            </form>
          </div><!-- /well -->
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">查询并浏览失物公告</li>
              <li><a href="">日期排序 Sort By Date</a></li>
              <li><a href="">名称排序 Sort By Name</a></li>
              

              <li class="nav-header">A. 生活及运动用品</li>
              <li><a href="">水瓶 Bottles</a></li>
              <li><a href="">安全帽 Helmet</a></li>
              <li><a href="">雨衣 Raincoat</a></li>
              <li><a href="">雨伞 Umbrella</a></li>
              <li><a href="">背包 Backpack</a></li>
              <li><a href="">运动用品 Sporting Goods</a></li>
              <li><a href="">其他 Others</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
                    
                </div>
            </div>
        </div>
    </div>
</div>

	
		
		<!-- 分页标签 -->
		<p valign="top">
			<p align="center" class="font3">
			<topunltra:pager
					pageIndex="${requestScope.pageModel.pageIndex}"
					pageSize="${requestScope.pageModel.pageSize}"
					recordCount="${requestScope.pageModel.recordCount}" style="digg"
					submitUrl="${ctx}/showNotice?pageIndex={0}" /></p>
		</p>
	
	<div style="height: 20px;"></div>
	
	 <hr>

      <footer align="center">
        	Copyright © 2017 - 2020 <a href="#">NITLost</a> ·  Authored By <a href="#">Unltra</a>
      </footer>
    <div style="height: 20px;"></div>
</body>
</html>