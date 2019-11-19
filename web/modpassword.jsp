<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: asus
Date: 2019/9/3
Time: 13:25
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<%--<script src="/ProjectManagementSystem/js/jquery-3.4.1.min.js"></script>--%>
	<script type="text/javascript">
		function check() {
			var oldPassword = document.getElementById("oldPassword").value;
			var newPassword = document.getElementById("newPassword").value;
			var surePassword = document.getElementById("surePassword").value;
			console.log(oldPassword);
			console.log(newPassword);
			console.log(surePassword);
			//非空认证
			if(oldPassword.trim().length==0||oldPassword==""){
				alert("原密码不能为空");
				return false;
			}
			if(newPassword.trim().length==0||newPassword==""){
				alert("新密码不能为空");
				return false;
			}
			if(surePassword.trim().length==0||surePassword==""){
				alert("请确认新密码");
				return false;
			}

			if (surePassword!=newPassword){
				alert("重复密码不一致");
				return false;
			}
		}

		<c:if test="${fail==0}">
		alert("原密码错误！");
		</c:if>
	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:我的信息>>修改密码
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" onsubmit="return check()" method="post" action="/ProjectManagementSystem/updatePassword">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;修改密码&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">原密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="oldPassword" id="oldPassword"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">新密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="newPassword" id="newPassword"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">重复密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="surePassword"/></td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<%--<a href="modpassword.jsp" class="coolbg">保存</a>--%><input type="submit" value="保存" class="coolbg">
</td>
</tr>
</table>

</form>
  

</body>

</html>