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
<title>菜单资源管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript">
        //全选
        function selectionAll() {
            var selectResource_ids = document.getElementsByName("selectResource_id");
            for (var i=0;i<selectResource_ids.length;i++){
                selectResource_ids[i].checked=true;
            }
        }
        //反选
        function invertSelection() {
            var selectResource_ids = document.getElementsByName("selectResource_id");
            for (var i=0;i<selectResource_ids.length;i++){
                if(selectResource_ids[i].checked){
                    selectResource_ids[i].checked=false;
                }else {
                    selectResource_ids[i].checked=true;
                }
            }
        }
        //更改状态
        function ChangeResourceStatus() {
            var selectResource_ids = document.getElementsByName("selectResource_id");
            var resource_ids = "";
            for (var i=0;i<selectResource_ids.length;i++){
                if(selectResource_ids[i].checked){
                    resource_ids += selectResource_ids[i].value+",";
                }
            }
            if(resource_ids==""){
                alert("请选择至少一个禁用！");
                return false;
            }else {
                resource_ids = resource_ids.substring(0,resource_ids.length-1);
                var isConfirm= window.confirm("确定要禁用吗？");
                if(isConfirm){
                    window.location.href="/ProjectManagementSystem/changeResourceStatus?resource_ids="+resource_ids;
                }
            }
        }

        //删除
        function delResource(resource_id) {
            var isConfirm= window.confirm("确定要删除吗？");
            if(isConfirm){
                window.location.href="/ProjectManagementSystem/delResource?resource_id="+resource_id;
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
            if(value1.trim()==""){
                conditionNames[0].selected=true;
            }else {
                for (var i=1;i<conditionNames.length;i++){
                    if(conditionNames[i].value==value1){
                        conditionNames[i].selected=true;
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
    当前位置:权限管理>>菜单资源管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='/ProjectManagementSystem/addResource?action=add';" value='添加菜单资源' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='/ProjectManagementSystem/resourceConditionQuery' method='get'>
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
          	<option value='resource_name'>菜单资源名称</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='conditionValue' value="${requestScope.conditionValue}" style='width:120px' />
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
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;菜单资源列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">菜单资源编号</td>
	<td width="10%">菜单资源名称</td>
	<td width="10%">父菜单</td>
	<td width="10%">菜单资源路径</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>
    <c:if test="${empty pageBean.beanList}">
        <tr style="align-content: center">
            <td colspan="7"><h1>没有任何菜单资源信息！</h1></td>
        </tr>
    </c:if>
    <c:if test="${not empty pageBean.beanList}">
    <c:forEach var="resource" items="${pageBean.beanList}" >
    <c:set var="i" value="${i+1}"></c:set>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="selectResource_id" type="checkbox" id="id" value="${resource.resource_id}" class="np"></td>
	<td>${i}</td>
	<td>${resource.resource_id}</td>
	<td align="center">${resource.resource_name}</td>
	<td align="center">${resource.resource_parentDirectory}</td>
	<td align="center">${resource.resource_path}</td>
	<td>${resource.resource_status}</td>
	<td><a href="javascript:delResource('${resource.resource_id}')">删除</a> |<a href="/ProjectManagementSystem/editResource?resource_id=${resource.resource_id}&action=edit&pageNum=${pageBean.pageNum}">编辑</a> </td>
</tr>
    </c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:selectionAll()" class="coolbg">全选</a>
	<a href="javascript:invertSelection()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:ChangeResourceStatus()" class="coolbg">&nbsp;禁用&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center">
        <!--翻页代码 -->
        <c:if test="${pageBean.pageNum!=1}">
            <a href="/ProjectManagementSystem/resourceConditionQuery?pageNum=1&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">首页</a>
            <a href="/ProjectManagementSystem/resourceConditionQuery?pageNum=${pageBean.pageNum-1}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">上一页</a>
        </c:if>
        <c:forEach begin="${pageBean.pageNum-5>0?(pageBean.pageNum-5):1}" end="${pageBean.pageNum+4<=pageBean.totalPageNum?(pageBean.pageNum+4):pageBean.totalPageNum}" step="1" var="i" >
            <c:if test="${pageBean.pageNum==i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum!=i}">
                <a href="/ProjectManagementSystem/resourceConditionQuery?pageNum=${i}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">${i}</a>
            </c:if>
        </c:forEach>
        <c:if test="${pageBean.pageNum!=pageBean.totalPageNum}">
            <a href="/ProjectManagementSystem/resourceConditionQuery?pageNum=${pageBean.pageNum+1}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">下一页</a>
            <a href="/ProjectManagementSystem/resourceConditionQuery?pageNum=${pageBean.totalPageNum}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">尾页</a>
        </c:if>
    </td>
</tr>
</table>
    </c:if>
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