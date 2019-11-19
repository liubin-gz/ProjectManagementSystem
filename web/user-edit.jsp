<%--
Created by IntelliJ IDEA.
User: asus
Date: 2019/9/3
Time: 13:25
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑用户信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script src="/ProjectManagementSystem/js/jquery-3.4.1.min.js"></script>
	<script src="/ProjectManagementSystem/js/jquery.form.js"></script>
	<script>
		$(function () {
			//加载显示职业列表
			$.ajax({
				type:"get",
				dataType:"json",
				contentType:"application/x-www-form-urlencoded;charset=utf-8",
				url:"/ProjectManagementSystem/getJobs",
				async:true,
				cache:false,
				success:function (data) {
					var user_job = "${user.user_job}";
					for (var i=0;i<data.length;i++){
						if(user_job==data[i].job_name){
							$("#user_job").append('<option value="'+data[i].job_name+'" selected>'+data[i].job_name+'</option>');
						}
						$("#user_job").append('<option value="'+data[i].job_name+'">'+data[i].job_name+'</option>');
					}
				},
				error:function (xhr, status, error) {
					console.log(xhr);
					console.log(status);
					console.log(error);
				}
			});

		});
	</script>
	<script>
		/*不需要异步*/
		$(function () {
			//性别的
			var objs1 = $("#user_sex option");
			var user_sex = "${user.user_sex}";
			for (var i=0;i<objs1.length;i++){
				if(user_sex==objs1[i].value){
					objs1[i].selected=true;
					break
				}
			}

			//赋角色的
			var objs2 = document.getElementsByName("user_roleId");
			var user_roleId = "${user.user_roleId}".split(",");
			for (var i=0;i<user_roleId.length;i++){
				for (var j=0;j<objs2.length;j++){
					if (user_roleId[i].trim()==objs2[j].value){
						objs2[j].checked=true;
						break;
					}
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
    当前位置:权限管理>>编辑用户
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" method="post" action="/ProjectManagementSystem/editUser">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑用户&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="user_job" id="user_job">

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="user_name" value="${user.user_name}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="user_sex" id="user_sex">
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="user_age" value="${user.user_age}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="user_cellphone" value="${user.user_cellphone}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="user_entryTime" value="${user.user_entryTime}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="user_idCard" value="${user.user_idCard}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<c:forEach var="role" items="${roleList}">
			<input type="checkbox" name="user_roleId" value="${role.role_id}"/>${role.role_name}
		</c:forEach>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="user_remark">${user.user_remark}</textarea>
	</td>
</tr>

	<tr>
		<td>
			<input type="hidden" name="user_id" value="${user.user_id}">
			<input type="hidden" name="pageNum" value="${requestScope.pNum}">
		</td>
	</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<%--<a href="user.jsp" class="coolbg">保存</a>--%><input type="submit" value="保存" class="coolbg">
	<a href="/ProjectManagementSystem/pageListUser?pageNum=${requestScope.pNum}" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>