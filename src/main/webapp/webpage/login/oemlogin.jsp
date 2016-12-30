<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<link rel="icon" href="/favicon.ico" type="image/x-icon" /> 
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<title>试验室信息管理系统</title>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
<script type="text/javascript" src="../js/DD_belatedPNG.js"></script>	
<SCRIPT language=javascript>
  function ok(){	 
  var obj = document.getElementById("userName");  
    if (obj.value == "") {
      alert("帐号不能为空，请输入！");
      obj.focus();
      return false;
    }else{
      return true;
    }
  } 
 
</SCRIPT>
<style>
/* cssRest */
body,div,dl,dt,dd,ul,li,h1,h2,h3,h4,form,input,p,button{margin:0;padding:0;}
img{display:block;border:0;}
em{font-style:normal;font-weight:400;}
ul{list-style:none;}
h3,h4{font-size:12px;font-weight:400;}
a{color:#fff;text-decoration:none;}
a:hover{text-decoration:underline;color:#BC0007;}

.posr{position:relative;}
.posa{position:absolute;}

.zi0{z-index:0;}
.zi1{z-index:1;}
.zi10{z-index:10;}
.zi99{z-index:99;}


/* clearfix  */
.clear:after{content:"\20";display:block;height:0;clear:both;visibility:hidden;}
.clear{*zoom:1;}

/* float class  */
.fl{float:left;}
.fr{float:right;}
.cl{clear:left;}
.cr{clear:right;}
.cb{clear:both;}

/* width class */
.wa	  {width:auto;}
.w1200 { width:1200px;}
/* margin class */
.ma{margin:0 auto;}
.mt6{margin-top:6px;}
.mt8{margin-top:8px;}
.mt10{margin-top:10px;}
.mt20{margin-top:20px;}

/* height class */
.ha{height:auto !important;overflow:visible;}
.h50{height:50px;}
.h100{height:100px;}
.h150{height:150px;}
.h200{height:200px;}
.h250{height:250px;}
.h300{height:300px;}
.h350{height:350px;}
.h400{height:400px;}
.h450{height:450px;}
.h500{height:500px;}
.h550{height:550px;}
.h600{height:600px;}

.min-h113{
			min-height:100px;			/*高度最小值设置为：100px*/ 
			height:auto !important;		/*兼容FF,IE7也支持 !important标签*/
		    height:113px;				/*兼容ie6*/
		    overflow:visible;
		}
.min-h350{
			min-height:350px;			/*高度最小值设置为：200px*/ 
			height:auto !important;		/*兼容FF,IE7也支持 !important标签*/
		    height:350px;				/*兼容ie6*/
		    overflow:visible;
		}
.min-h260{
			min-height:260px;			/*高度最小值设置为：294px*/ 
			height:auto !important;		/*兼容FF,IE7也支持 !important标签*/
		    height:260px;				/*兼容ie6*/
		    overflow:visible;
		}
.min-h739{
			min-height:739px;			/*高度最小值设置为：739px*/ 
			height:auto !important;		/*兼容FF,IE7也支持 !important标签*/
		    height:739px;				/*兼容ie6*/
		    overflow:visible;
		}



/*****************************************************       fr style        ***********************************************************************/
body{background:url(plug-in/login/images/zcbody_background.jpg) no-repeat top center;color:#333;font:12px/1.5 Tahoma;height:600px;margin-top:1px;}
.cbody{margin:1px auto;height:598px;border:#000 1px solid;padding:1px}
.header{width:100%;}
.logo{text-align:left;padding-left:100px;padding-top:40px;}
#content{margin:0px auto 0px auto;}


</style>
</HEAD>
<body id=userlogin_body>
<FORM name="login" action="loginController.do?commonlogin" method=post onsubmit="return ok()" >
	<div class="clear">
	   <div class="w1200 ma cbody">
		
		<div class="header min-h113">
			<div class="logo"><img class="img_logo" src="plug-in/login/images/zclogo.png"/></div>
		</div>

		<div id="content" class="min-h350">
			<div class="left" style="float:left;background:none;width:600px;height:377px;">
			
			</div>
			<div class="right" style="float:left;background:url(plug-in/login/images/zclogin_background.png) no-repeat top left;margin-left:120px;width:328px;height:377px;">
				<table style="width:260px;margin:80px auto 0px auto;">
					<tr>
						<td style="width:230px"><br/>
							<span style="color:#1b5a87;font-size:15px">用户名：</span><br/>
							<input type="text" style="background:url(plug-in/login/images/zcipt_back_03.png) no-repeat top left;border:none;font-size:16px;color:#8c8d8b;width:244px;height:43px;line-height:40px;text-indent:5px" onBlur="if(value=='') {value=' **********'; this.style.color = '#999999';}" value="" id="userName" name="userName"/>
							<div style="margin-top:10px;">
							<span style="color:#1b5a87;font-size:15px">密&nbsp;&nbsp;&nbsp;码：</span><br/>
							<input type="password" style="background:url(plug-in/login/images/zcipt_back_06.png) no-repeat top left;border:none;font-size:16px;color:#8c8d8b;width:244px;height:42px;line-height:40px;text-indent:5px" onBlur="if(value=='') {value=' **********'; this.style.color = '#999999';}" id="password" name="password"/>
							</div>
						</td>						
					</tr>
					<tr>	<% String error=(String)request.getAttribute("error");   
       if (null!=error && error.equalsIgnoreCase("true")) {
    %>
    <td align="center"><FONT color=#ff0000 size="2" >用户名或密码错误！</FONT></td>
    <% } else {%>
            <td>&nbsp;</td>
			<%}%></tr>
					<tr>
						<td align="center">
							<div style="margin-top:57px">
							<input type="submit" style="cursor:pointer;border:none;background:url(plug-in/login/images/zcipt_back_09.png) no-repeat top left;width:89px;height:33px" value=""/>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!-- foot	 -->
		<div class="clear w1200" style="margin:53px auto 0px auto;height:0px;background:url(plug-in/login/images/zcfooter.png) no-repeat top center;">
			<p style="text-align:center;font-size:12px;color:#055d91;line-height:53px">
				版权所有 <b>·</b> 上海同望软件有限公司  &nbsp;电话：027-87614140 &nbsp;  传真021-61538292&nbsp; &nbsp; &nbsp;  
			</p>
		</div>		
	  </div>
	</div>

	<script type="text/javascript">
		DD_belatedPNG.fix('.img_logo');
		DD_belatedPNG.fix('.img_cname'); 
	</script>
</FORM>
</body>
</html>

