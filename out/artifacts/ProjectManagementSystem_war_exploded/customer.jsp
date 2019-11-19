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
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script type="text/javascript">
    /*全选反选栏的script*/
    //全选
    function selectionAll() {
        var selectCustomer_ids = document.getElementsByName("selectCustomer_id");
        for (var i=0;i<selectCustomer_ids.length;i++){
            selectCustomer_ids[i].checked=true;
        }
    }
    //反选
    function invertSelection() {
        var selectCustomer_ids = document.getElementsByName("selectCustomer_id");
        for (var i=0;i<selectCustomer_ids.length;i++){
            if(selectCustomer_ids[i].checked){
                selectCustomer_ids[i].checked=false;
            }else {
                selectCustomer_ids[i].checked=true;
            }
        }
    }
    //删除
    function delCustomer() {
        var selectCustomer_ids = document.getElementsByName("selectCustomer_id");
        var customer_ids = "";
        for (var i=0;i<selectCustomer_ids.length;i++){
            if(selectCustomer_ids[i].checked){
                customer_ids += selectCustomer_ids[i].value+",";
            }
        }
        if(customer_ids==""){
            alert("请选择至少一个删除！");
            return false;
        }else {
            customer_ids = customer_ids.substring(0,customer_ids.length-1);
            var isConfirm= window.confirm("确定要删除吗？");
            if(isConfirm){
                window.location.href="/ProjectManagementSystem/delCustomer?customer_ids="+customer_ids;
            }
        }
    }
</script>
    <script src="/ProjectManagementSystem/js/jquery-3.4.1.min.js"></script>
    <script>
    /*搜索后停留在条件上*/
        //conditionName
        $(function () {
           var conditionNames = $("#conditionName option");
            var value1="${conditionName}";
            //console.log(value1)
            if(value1.trim()==""){
                conditionNames[0].selected=true;
                //console.log("--"+value1+"--"+空的)
            }else {
                for (var i=1;i<conditionNames.length;i++){
                    //console.log(conditionNames[i].value);
                    if(conditionNames[i].value==value1){
                        conditionNames[i].selected=true;
                        //console.log(conditionNames[i].value+"--"+value1);
                        break;
                    }
                }
            }
        });

        //orderby
    $(function () {
        var orderbys = $("#orderby option");
        var value2 = "${orderby}";
        //console.log(value2);
        if(value2.trim()==""){
            orderbys[0].selected=true;
            console.log("--"+value2+"--"+空的)
        }else {
            for (var i=1;i<orderbys.length;i++){
                //console.log(conditionNames[i].value);
                if(orderbys[i].value==value2){
                    orderbys[i].selected=true;
                    //console.log(orderbys[i].value+"--"+value2);
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
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location.href='customer-add.jsp';" value='添加客户信息' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='/ProjectManagementSystem/CustomerConditionQuery' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='conditionName' id="conditionName" style='width:150'>
            <option value=''>选择类型...</option>
          	<option value='customer_companyName'>客户所在公司名称</option>
          	<option value='customer_name'>联系人姓名</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' value="${conditionValue}" name='conditionValue' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' id="orderby" style='width:120px'>
            <option value=''>排序...</option>
            <option value='customer_insertDate'>添加时间</option>
            <option value='customer_recentChangeDate'>修改时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
    <input type="hidden" name="pageNum" value="1">
</form>
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>
    <c:if test="${empty pageBean.customers}">
        <tr style="align-content: center">
            <td colspan="7"><h1>没有任何客户信息！</h1></td>
        </tr>
    </c:if>
    <c:if test="${not empty pageBean.customers}">
    <c:forEach var="customer" items="${pageBean.customers}" >
        <c:set var="i" value="${i+1}"></c:set>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
            <td><input name="selectCustomer_id" type="checkbox" id="id" value="${customer.customer_id}" class="np"></td>
            <td>${i}</td>
            <td>${customer.customer_name}</td>
            <td>${customer.customer_companyName}</td>
            <td>${customer.customer_insertDate}</td>
            <td>${customer.customer_cellphone}</td>
            <td><a href="/ProjectManagementSystem/showCustomer?customer_id=${customer.customer_id}&action=edit&pageNum=${pageBean.pageNum}">编辑</a> | <a href="/ProjectManagementSystem/showCustomer?customer_id=${customer.customer_id}&action=look&pageNum=${pageBean.pageNum}">查看详情</a></td>
        </tr>
    </c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:selectionAll()" class="coolbg">全选</a>
	<a href="javascript:invertSelection()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:delCustomer()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center">
        <!--翻页代码 -->
        <c:if test="${pageBean.pageNum!=1}">
            <a href="/ProjectManagementSystem/CustomerConditionQuery?pageNum=1&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}&orderby=${requestScope.orderby}">首页</a>
            <a href="/ProjectManagementSystem/CustomerConditionQuery?pageNum=${pageBean.pageNum-1}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}&orderby=${requestScope.orderby}">上一页</a>
        </c:if>
        <c:forEach begin="${pageBean.pageNum-5>0?(pageBean.pageNum-5):1}" end="${pageBean.pageNum+4<=pageBean.totalPageNum?(pageBean.pageNum+4):pageBean.totalPageNum}" step="1" var="i" >
            <c:if test="${pageBean.pageNum==i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum!=i}">
                <a href="/ProjectManagementSystem/CustomerConditionQuery?pageNum=${i}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}&orderby=${requestScope.orderby}">${i}</a>
            </c:if>
        </c:forEach>
        <c:if test="${pageBean.pageNum!=pageBean.totalPageNum}">
            <a href="/ProjectManagementSystem/CustomerConditionQuery?pageNum=${pageBean.pageNum+1}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}&orderby=${requestScope.orderby}">下一页</a>
            <a href="/ProjectManagementSystem/CustomerConditionQuery?pageNum=${pageBean.totalPageNum}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}&orderby=${requestScope.orderby}">尾页</a>
        </c:if>
    </td>
</tr>
    </c:if>
</table>

</form>
  

</body>
<%--完美一点--%>
<c:if test="${!(empty requestScope.num)}">
    <c:if test="${requestScope.num>0}">
        <script>
            window.onload = function () {
                alert("修改成功！！");
            }
        </script>
    </c:if>
    <c:if test="${requestScope.num<=0}">
        <script>
            window.onload = function () {
                alert("修改失败！！");
            }
        </script>
    </c:if>
</c:if>

</html>