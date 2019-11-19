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
<title>编辑角色信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script src="/ProjectManagementSystem/js/jquery-3.4.1.min.js"></script>
	<script>
		/*不需要异步*/
		$(function () {
			//赋权限的
			var objs1 = document.getElementsByName("role_authority");
			var role_authority = "${role.role_authority}".split(",");
			for (var i=0;i<role_authority.length;i++){
				for (var j=0;j<objs1.length;j++){
					if (role_authority[i].trim()==objs1[j].value){
						objs1[j].checked=true;
						break;
					}
				}
			}

			//状态的
			var objs2 = $("#role_status option");
			var role_status = "${role.role_status}";
			for(var i=0;i<objs2.length;i++){
				if (role_status==objs2[i].value){
					objs2[i].selected=true;
					break;
				}
			}
		});
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
    当前位置:权限管理>>编辑角色
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" action="/ProjectManagementSystem/editRole" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑角色&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${role.role_id}</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="role_name" value="${role.role_name}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="role_status" id="role_status">
			<option value="启用">启用</option>
			<option value="禁用">禁用</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

		<c:forEach var="resource" items="${resourceList}">
			<c:if test="${empty resource.resource_parentDirectory}">
				<input type="checkbox" name="role_authority" value="${resource.resource_id}" id="father">${resource.resource_name}<br/>
				<c:forEach var="child" items="${resourceList}">
					<c:if test="${resource.resource_name eq child.resource_parentDirectory}">
						&nbsp;&nbsp;&nbsp;<input type="checkbox" name="role_authority" value="${child.resource_id}">${child.resource_name}<br/>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
	
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="role_remark">${role.role_remark}</textarea>
	</td>
</tr>

	<tr>
		<td>
			<input type="hidden" name="role_id" value="${role.role_id}">
			<input type="hidden" name="pageNum" value="${requestScope.pNum}">
		</td>
	</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<%--<a href="role.jsp" class="coolbg">保存</a>--%><input type="submit" value="保存" class="coolbg">
	<a href="/ProjectManagementSystem/pageListRole?pageNum=${requestScope.pNum}" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>