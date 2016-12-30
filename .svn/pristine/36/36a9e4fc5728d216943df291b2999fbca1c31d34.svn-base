<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="height:100%;width:100%;padding:0px;margin:0px;">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<title>混凝土生产全过程监控管理系统</TITLE>
	<style type="text/css">
		body {
			margin: 0px auto;
			padding: 0px;
			font-family: "宋体", "Arial Black", Gadget, sans-serif;
			font-size: 13px;
			background: url(plug-in/login/images/zgjj/background.png);
		}
		#dl {
			width: 100%;
			height: auto;
			overflow: hidden;
		}
		#dl_mid {
			width: 100%;
			height: auto;
			background: #FFF;
			margin-top: 150px;
			padding-top: 20px;
		}
		#dl_mid_kuang {
			width: 960px;
			height: auto;
			margin: 0px auto;
			overflow: hidden;
		}
		#dl_mid_right {
			width: 450px;
			height: auto;
			margin-top: 20px;
			float: left;
			background: #FFF;
			margin-left: 18px;
		}
		
		.dl_mid_right_top {
			width: 405px;
			height: 23px;
			font-size: 22px;
			font-weight: bold;
			text-align: center;
		}
		
		.dl_mid_right_mid {
			width: 400px;
			height: auto;
			margin-top: 30px;
			overflow: hidden;
			padding-top: 10px;
		}
		
		.dl_mid_right_mid .dl_mid_right_mid_table {
			width: 100%;
			border: 0px;
			cellpadding: 0px;
			cellspacing: 0px;
		}
		
		#dl_down {
			width: 590px;
			height: 107px;
			background: url(plug-in/login/images/zgjj/down.png) no-repeat;
			float: right;
		}
		
		.dl_mid_input {
			width: 178px;
			height: 21px;
			border: 1px solid #BBBBBB;
			color: #999;
			text-indent: 5px;
		}
		#note {
			text-align: center;
		}
		#note span{
			color : #f00;
		}
		.login-msg {
			color: #f00;
		}
	</style>
	<link href="plug-in/login/images/zgjj/icon.ico" rel="icon" type="image/x-icon" />
    <link href="plug-in/login/images/zgjj/icon.ico" rel="shortcut icon" type="image/x-icon" />
	<link href="plug-in/login/css/buttons.css" rel="stylesheet" type="text/css" />
	<!--[if lt IE 9]>
   		<script src="plug-in/login/js/html5.js"></script>
  	<![endif]-->
	<!--[if lt IE 7]>
	  	<script src="plug-in/login/js/iepng.js" type="text/javascript"></script>
	  	<script type="text/javascript">
			EvPNG.fix('div, ul, img, li, input'); //EvPNG.fix('包含透明PNG图片的标签'); 多个标签之间用英文逗号隔开。
		</script>
	<![endif]-->
	<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
	<script type="text/javascript" src="plug-in/login/js/jquery-jrumble.js"></script>
	<script type="text/javascript" src="plug-in/login/js/jquery.tipsy.js"></script>
	<script type="text/javascript" src="plug-in/login/js/iphone.check.js"></script>
	<script type="text/javascript" src="plug-in/login/js/login.js"></script>
	<script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
	<script type="text/javascript" src="plug-in/login/js/modernizr.custom.63321.js"></script>
	<SCRIPT language=javascript>
  	function ok(){	
	   var obj = document.getElementById("userName");  
    	if (obj.value == "") {
      		alert("帐号不能为空，请输入！");
      		obj.focus();
      		return false;
    	}else{
    		setCookie();  
	    	var actionurl=$('form').attr('action');//提交路径  
	    	var checkurl=$('form').attr('check');//验证路径  
	     	var formData = new Object();  
	    	var data=$(":input").each(function() {  
	        	formData[this.name] =$("#"+this.name ).val();  
	    	});  
	    	$.ajax({  
	       		async : false,  
	       		cache : false,  
	       		type : 'POST',  
	       		url : checkurl,// 请求的action路径  
	       		data : formData,  
	       		error : function() {// 请求失败处理函数  
	       		},  
	       		success : function(data) {  
	           		var d = $.parseJSON(data);  
	           		if (d.success) {  
	              		loginsuccess();  
	              		setTimeout("window.location.href='"+actionurl+"'", 1000);  
	           		} else {  
	               		if(d.msg == "a"){  
	                  		$.dialog.confirm("数据库无数据,是否初始化数据?", function(){  
	                     			window.location = "init.jsp";  
	                  			}, function(){  
	                     //  
	                  		});  
	              		} else{ 
	                  		showError(d.msg);  
	              		}
	           		}  
	       		}  
	    	});  
      		return true;
    	}  
  	} 
</SCRIPT>
</head>
<body >
	<div id="dl">
		<div id="dl_mid">
			<div id="dl_mid_kuang">		
				<div id="dl_mid_left" style="background-image:url(plug-in/login/images/zgjj/left_1.png);width:350px;height:130px;float:left;"></div>
				<div id="dl_mid_right">
					<div class="dl_mid_right_top">混凝土生产全过程管理信息系统</div>
					<div class="dl_mid_right_mid">
						<form action="loginController.do?login" check="loginController.do?checkuser" onsubmit="return ok()"  method="post">
							<table class="dl_mid_right_mid_table">
								<tr>
									<td width="100" height="30" align="right">用户名：</td>
									<td width="300"><input class="userName" id="userName" name="userName" type="text" value="" iscookie="true" nullmsg="" /></td>
								</tr>
								<tr>
									<td height="30" align="right">密码：</td>
									<td><input class="password" name="password" id="password" type="password" value="" title="" nullmsg=""/></td>
								</tr>
								<tr>
									<td height="30">&nbsp;</td>
									<td><input type="submit" class="uibutton normal" value="登录">&nbsp;&nbsp;<input class="uibutton normal" type="reset" value="清空"></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td class="login-msg"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div id="note">
				为保证使用效果，建议：显示器分辨率设置为<span>1024*768</span>及以上；浏览器采用<span>谷歌、火狐、360、傲游、IE9以上（非兼容模式）</span>等
			</div>
		</div>
		<div id="dl_down"></div>
		</div>
		<div align="center" style="padding-top: 50px;;"><span style="font-family: arial; width: 100%; color: #ffffff;">Copyright &copy; 2014 中国交通信息中心</span></div>
		   
	</body>
</html>
