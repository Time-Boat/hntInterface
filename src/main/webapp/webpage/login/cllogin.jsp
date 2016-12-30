<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" /> 
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" />
<title>试验室信息管理系统</title>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
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

</HEAD>
<body id=userlogin_body>
<FORM name="login" action="loginController.do?commonlogin" method=post onsubmit="return ok()" >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_01.gif" width="129" height="137" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_02.gif" width="167" height="137" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_03.gif" width="173" height="137" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_04.gif" width="180" height="137" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_05.gif" width="203" height="137" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_06.gif" width="151" height="137" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_07.gif" width="129" height="74" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_08.gif" width="167" height="74" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_09.gif" width="173" height="74" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_10.gif" width="180" height="74" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_11.gif" width="203" height="74" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_12.gif" width="151" height="74" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_13.gif" width="129" height="105" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_14.gif" width="167" height="105" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_15.gif" width="173" height="105" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_16.gif" width="180" height="105" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_17.gif" width="203" height="105" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_18.gif" width="151" height="105" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_19.gif" width="129" height="95" /></td>
        <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="plug-in/login/images/cltljkjm/cltljkjm_20.gif" width="119" height="29" /></td>
                <td><img src="plug-in/login/images/cltljkjm/cltljkjm_21.gif" width="42" height="29" /></td>
                <td background="plug-in/login/images/cltljkjm/cltljkjm_22.gif" width="204" height="29"><INPUT id=userName
      maxLength=20 name=userName style="background:transparent; BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; WIDTH: 100%; BORDER-BOTTOM: 0px"></td>
              </tr>
            </table></td>
          </tr>
          <tr>
		  <%if (null != request.getAttribute("error") && ((String)request.getAttribute("error")).equalsIgnoreCase("true")) {%>
		    <td background="plug-in/login/images/cltljkjm/cltljkjm_27.gif" width="365" height="19" align="right"><font color="red" size="2">用户名或密码错误</font></td>
		    <%} else {%>
		    <td><img src="plug-in/login/images/cltljkjm/cltljkjm_27.gif" width="365" height="19" /></td>
		    <%}%>            
          </tr>
          <tr>
            <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><img src="plug-in/login/images/cltljkjm/cltljkjm_26.gif" width="119" height="29" /></td>
                <td><img src="plug-in/login/images/cltljkjm/cltljkjm_27-28.gif" width="42" height="29" /></td>
                <td background="plug-in/login/images/cltljkjm/cltljkjm_27-29.gif" width="204" height="29"><INPUT id=password 
      type=password name=password style="background:transparent; BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; WIDTH: 100%; BORDER-BOTTOM: 0px"></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><img src="plug-in/login/images/cltljkjm/cltljkjm_30.gif" width="365" height="18" /></td>
          </tr>
        </table></td>
        <td><INPUT id=IbtnEnter 
    style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" 
    type=image src="plug-in/login/images/cltljkjm/cltljkjm_25.gif" name=IbtnEnter  width="155" height="95"></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_20-24.gif" width="203" height="95" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_20-25.gif" width="151" height="95" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_31.gif" width="129" height="159" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_32.gif" width="167" height="159" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_33.gif" width="198" height="159" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_34.gif" width="155" height="159" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_35.gif" width="203" height="159" /></td>
        <td><img src="plug-in/login/images/cltljkjm/cltljkjm_36.gif" width="151" height="159" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</FORM>
</body>
</html>

