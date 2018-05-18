<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${ctx }/js/check.js"></script>
<style type="text/css">
	@charset "utf-8";
	/* track base Css */
.container {
	margin-top:15px;
}
.red {
	color:red;
}
#ehong-code-input {
	width:42px;
	letter-spacing:2px;
	margin:0px 8px 0px 0px;
}
.ehong-idcode-val {
	position:relative;
	padding:1px 4px 1px 4px;
	top:0px;
	*top:-3px;
	letter-spacing:4px;
	display:inline;
	cursor:pointer;
	font-size:16px;
	font-family:"Courier New",Courier,monospace;
	text-decoration:none;
	font-weight:bold;
}
.ehong-idcode-val0 {
	border:solid 1px #A4CDED;
	background-color:#ECFAFB;
}
.ehong-idcode-val1 {
	border:solid 1px #A4CDED;
	background-color:#FCEFCF;
}
.ehong-idcode-val2 {
	border:solid 1px #6C9;
	background-color:#D0F0DF;
}
.ehong-idcode-val3 {
	border:solid 1px #6C9;
	background-color:#DCDDD8;
}
.ehong-idcode-val4 {
	border:solid 1px #6C9;
	background-color:#F1DEFF;
}
.ehong-idcode-val5 {
	border:solid 1px #6C9;
	background-color:#ACE1F1;
}
.ehong-code-val-tip {
	font-size:12px;
	color:#1098EC;
	top:0px;
	*top:-3px;
	position:relative;
	margin:0px 0px 0px 4px;
	cursor:pointer;
}
</style>

</head>


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
                        <li>
                             <a href="${ctx}/uloginForm">登录</a>
                        </li>
                        <li>
                             <a href="#"></a>
                        </li>
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
<div>
<form class="form-horizontal register" action="${ctx }/addU" method="post" enctype="multipart/form-data" name="showform">
    <div class="form-group" >
        <label class="col-lg-2 control-label" for="username">用户名<small>(必填)</small></label>
        <div class="col-lg-4">
            <input class="form-control" id="username" name="uname" type="text"  />
            <span class="help-block">用户以字母、数字、下划线开头，切能以数字开头！</span>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-2 control-label" for="password">密码<small>(必填)</small></label>
        <div class="col-lg-4">
            <input class="form-control" id="password" name="upw" type="password"/>
        </div>
        <div class="col-lg-5">
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-success active">密文</button>
                <button type="button" class="btn btn-default">明文</button>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-2 control-label" for="phone">电话<small>(必填)</small></label>
        <div class="col-lg-4">
            <input class="form-control" id="phone" name="uphone" type="text"/>
            <span class="help-block">电话号码为11位</span>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-2 control-label" for="email">邮箱<small>(必填)</small></label>
        <div class="col-lg-4">
            <input class="form-control" id="email" name="umail" type="text"/>
            <span class="help-block">邮箱格式xxx123456@qq.com</span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-lg-offset-2 col-lg-4">
            <button class="btn btn-primary btn-block" type="button">注册</button>
        </div>
    </div>
</form>
</div>

<div style="height: 40px;"></div>
	
	 <hr>

      <div align="center" class="footer">
        	Copyright © 2017 - 2020 <a href="#">NITLost</a> ·  Authored By <a href="#">Unltra</a>
      </div>

<script type="text/javascript">
/* 明文/密文 */
$('.btn-group .btn:first').click(function() {
    $(this).removeClass('btn-default').addClass('btn-success active');
    $('.btn-group .btn:last').removeClass('btn-success active').addClass('btn-default');
    $('#password')[0].type = 'password';
});

$('.btn-group .btn:last').click(function() {
    $(this).removeClass('btn-default').addClass('btn-success active');
    $('.btn-group .btn:first').removeClass('btn-success active').addClass('btn-default');
    $('#password')[0].type = 'text';
});

/* 注册验证 */
    // 用户名验证
    $('#username').focus(function() {
        $(this).on('input', function() {
            if($.isNumeric($(this).val().substr(0, 1))) {  // 判断第一个字符是不是数字
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if($(this).val().length == 0) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });


    // 密码验证
    $('#password').focus(function() {
        $(this).on('input', function() {
            if($(this).val().length == 0) {
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if($(this).val().length == 0) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });

    // 电话
    $('#phone').focus(function() {
        $(this).on('input', function() {
            if($(this).val().length == 0) {
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if($(this).val().length != 11) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });

    // 邮箱
    $('#email').focus(function() {
        $(this).on('input', function() {
            if($(this).val().length == 0) {
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if(!$(this).val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });
	
    // 提交验证
 $('.btn-primary').click(function() {
    $('.register input:not("[type=file]")').each(function() {
        if($(this).val().length == 0) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });

    if($('.register .has-error').length > 0) {
        console.log($('.has-error'));
        return false;
    } else {
        $(this).parents('form').submit();
    }
});
</script>

</body>
</html>