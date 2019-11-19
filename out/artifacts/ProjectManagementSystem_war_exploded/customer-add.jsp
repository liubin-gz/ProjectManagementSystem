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
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
	<tr>
		<td height="26" background="skin/images/newlinebg3.gif">
			<table width="58%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td >
						当前位置:客户信息管理>>添加客户信息
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<form name="form2" id="form2" method="post" action="/ProjectManagementSystem/addCustomer" onsubmit="return check()">

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加客户&nbsp;</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="customer_companyName" id="customer_companyName"></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="customer_name" id="customer_name"></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input input type="text" name="customer_companyAddress" size="60"/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="customer_cellphone" id="customer_cellphone"></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="customer_companyTel"></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130 name="customer_companyIntro"></textarea></td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=10 cols=130 name="customer_remark"></textarea>
			</td>
		</tr>

		<%--<tr>
			<td>
				<input type="hidden" name="pageNum" value="${pageNum}">
			</td>
		</tr>--%>


		<tr bgcolor="#FAFAF1">
			<td height="28" colspan=4 align=center>
				<%--<a href="customer.jsp" class="coolbg">保存</a>--%><input type="submit" value="保存" class="coolbg">
				<a href="/ProjectManagementSystem/pageListCustomer?pageNum=1" class="coolbg">返回</a>
			</td>
		</tr>
	</table>

</form>

</body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加客户信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript">
		function check() {
		    alert("aaa");
			var customer_companyName = document.getElementById("customer_companyName").value;
			var customer_name = document.getElementById("customer_name").value;
			var customer_cellphone = document.getElementById("customer_cellphone").value;
			console.log(customer_companyName);
			console.log(customer_name);
			console.log(customer_cellphone);
			//非空认证
			if(customer_companyName.trim().length==0||customer_companyName==""){
				alert("公司名不能为空");
				return false;
			}
			if(customer_name.trim().length==0||customer_name==""){
				alert("公司联系人不能为空");
				return false;
			}
			if(customer_cellphone.trim().length==0||customer_cellphone=="") {
				alert("公司联系人电话不能为空");
				return false;
			}
		}

	</script>
</head>

</html>