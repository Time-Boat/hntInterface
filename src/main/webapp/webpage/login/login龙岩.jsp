<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>试验室管控一体化系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
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
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<FORM name="login" action="loginController.do?commonlogin" method=post onsubmit="return ok()" >
<!-- Save for Web Slices (首页登录.jpg) -->
<table id="__01" width="1003" height="614" border="0" cellpadding="0" cellspacing="0"  align="center">
	<tr>
		<td colspan="7">
			<img src="plug-in/login/images/lysys_01.jpg" width="1003" height="240" alt=""></td>
	</tr>
	<tr>
		<td rowspan="8">
			<img src="plug-in/login/images/lysys_02.jpg" width="673" height="286" alt=""></td>
		<td colspan="5">
			<img src="plug-in/login/images/lysys_03.jpg" width="307" height="24" alt=""></td>
		<td rowspan="8">
			<img src="plug-in/login/images/lysys_04.jpg" width="23" height="286" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="plug-in/login/images/lysys_05.jpg" width="82" height="40" alt=""></td>		
		<td colspan="3" style="background:url(plug-in/login/images/lysys_06.jpg)" width="202" height="40" valign="middle"><input type="text" id="userName" maxLength=20 name="userName" style="width:110px;"></td>
		<td rowspan="6">
			<img src="plug-in/login/images/lysys_07.jpg" width="23" height="152" alt=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="plug-in/login/images/lysys_08.jpg" width="284" height="21" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="plug-in/login/images/lysys_09.jpg" width="82" height="37" alt=""></td>	
			<td  colspan="3" style="background:url(plug-in/login/images/lysys_10.jpg)" width="202" height="37">
			<input type="password" class="textInput" id="password" maxLength=20 name="password" style="width:110px;"></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="3">
			<img src="plug-in/login/images/lysys_11.jpg" width="130" height="54" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys_12.jpg" width="78" height="12" alt=""></td>
		<td rowspan="3">
			<img src="plug-in/login/images/lysys_13.jpg" width="76" height="54" alt=""></td>
	</tr>
	<tr>	
		<td>
			<INPUT id=IbtnEnter style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" type=image src="plug-in/login/images/lysys_14.jpg" name=IbtnEnter width="78" height="34">
			</td>
	</tr>
	<tr>
		<td>
			<img src="plug-in/login/images/lysys_15.jpg" width="78" height="8" alt=""></td>
	</tr>
	<tr>
		<td colspan="5">
			<img src="plug-in/login/images/lysys_16.jpg" width="307" height="110" alt=""></td>
	</tr>
	<tr>
		<td colspan="7">
			<img src="plug-in/login/images/lysys_17.jpg" width="1003" height="87" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="673" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="82" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="48" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="78" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="76" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="23" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/lysys.gif" width="23" height="1" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</FORM>
</body>
</html>