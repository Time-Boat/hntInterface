<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>盾构机</title>
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
<table id="__01" width="1165" height="753" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td colspan="7">
			<img src="plug-in/login/images/dgj_01.png" width="1165" height="213" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="5">
			<img src="plug-in/login/images/dgj_02.png" width="705" height="199" alt=""></td>
		<td colspan="5">
			<img src="plug-in/login/images/dgj_03.png" width="460" height="1" alt=""></td>
	</tr>
	<tr>
			<td colspan="5">
			<INPUT id=IbtnEnter style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" type=image src="plug-in/login/images/dgj_04.png" name=IbtnEnter width="460" height="128">
			</td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="plug-in/login/images/dgj_05.png" width="100" height="47" alt=""></td>
		<td colspan="3">
			<img src="plug-in/login/images/dgj_06.png" width="306" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/dgj_07.png" width="54" height="1" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" style="background:url(plug-in/login/images/dgj_08.png)" width="303" height="46" valign="middle"><input type="text" style="background-color:#E9E9E9;vertical-align:middle;line-height:40px;BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px;margin-left:1px;width:220px;height:40px;margin-top:-3px;" id="userName" maxLength=30 name="userName"></td>
		<td colspan="2" rowspan="5">
			<img src="plug-in/login/images/dgj_09.png" width="57" height="235" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="plug-in/login/images/dgj_10.png" width="403" height="23" alt=""></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="plug-in/login/images/dgj_11.png" width="703" height="166" alt=""></td>
		<td colspan="3">
			<img src="plug-in/login/images/dgj_12.png" width="107" height="48" alt=""></td>		
			<td style="background:url(plug-in/login/images/dgj_13.png)" width="298" height="48">
			<input type="password" style="background-color:#E9E9E9;vertical-align:middle;line-height:40px;margin-top:-3px;border:none;width:220px;height:40px;margin-left:1px;" class="textInput" id="password" maxLength=30 name="password"></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="plug-in/login/images/dgj_14.png" width="2" height="118" alt=""></td>
		<td colspan="3">
			<img src="plug-in/login/images/dgj_15.png" width="403" height="117" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="plug-in/login/images/dgj_16.png" width="403" height="1" alt=""></td>
	</tr>
	<tr>
		<td colspan="7">
			<img src="plug-in/login/images/dgj_17.png" width="1165" height="174" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="703" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="2" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="100" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="5" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="298" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="3" height="1" alt=""></td>
		<td>
			<img src="plug-in/login/images/fgf.gif" width="54" height="1" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</FORM>
</body>
</html>