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
<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript">
        //全选
        function selectionAll() {
            var selectRole_ids = document.getElementsByName("selectRole_id");
            for (var i=0;i<selectRole_ids.length;i++){
                selectRole_ids[i].checked=true;
            }
        }
        //反选
        function invertSelection() {
            var selectRole_ids = document.getElementsByName("selectRole_id");
            for (var i=0;i<selectRole_ids.length;i++){
                if(selectRole_ids[i].checked){
                    selectRole_ids[i].checked=false;
                }else {
                    selectRole_ids[i].checked=true;
                }
            }
        }
        //更改状态
        function ChangeRoleStatus() {
            var selectRole_ids = document.getElementsByName("selectRole_id");
            var role_ids = "";
            for (var i=0;i<selectRole_ids.length;i++){
                if(selectRole_ids[i].checked){
                    role_ids += selectRole_ids[i].value+",";
                }
            }
            if(role_ids==""){
                alert("请选择至少一个禁用！");
                return false;
            }else {
                role_ids = role_ids.substring(0,role_ids.length-1);
                var isConfirm= window.confirm("确定要禁用吗？");
                if(isConfirm){
                    window.location.href="/ProjectManagementSystem/changeRoleStatus?role_ids="+role_ids;
                }
            }
        }

        //删除
        function delRole(role_id) {
            var isConfirm= window.confirm("确定要删除吗？");
            if(isConfirm){
                window.location.href="/ProjectManagementSystem/delRole?role_id="+role_id;
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
    当前位置:权限管理>>角色管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='/ProjectManagementSystem/addRole?action=role_add';" value='添加角色' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='/ProjectManagementSystem/roleConditionQuery' method='get'>
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
          	<option value='role_name'>角色名称</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='conditionValue' value='${requestScope.conditionValue}' style='width:120px' />
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
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;角色列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">角色编号</td>
	<td width="10%">角色名称</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>
    <c:if test="${empty pageBean.beanList}">
        <tr style="align-content: center">
            <td colspan="7"><h1>没有任何菜单资源信息！</h1></td>
        </tr>
    </c:if>
    <c:if test="${not empty pageBean.beanList}">
    <c:forEach var="role" items="${pageBean.beanList}" >
    <c:set var="i" value="${i+1}"></c:set>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="selectRole_id" type="checkbox" id="id" value="${role.role_id}" class="np"></td>
	<td>${i}</td>
	<td>${role.role_id}</td>
	<td align="center">${role.role_name}</td>
	<td>${role.role_status}</td>
	<td><a href="javascript:delRole('${role.role_id}')">删除</a> |<a href="/ProjectManagementSystem/editRole?role_id=${role.role_id}&action=role_edit&pageNum=${pageBean.pageNum}">编辑</a> | <a href="/ProjectManagementSystem/showRole?role_id=${role.role_id}&action=role_look&pageNum=${pageBean.pageNum}">查看详情</a></td>
</tr>
    </c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:selectionAll()" class="coolbg">全选</a>
	<a href="javascript:invertSelection()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:ChangeRoleStatus()" class="coolbg">&nbsp;禁用&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center">
        <!--翻页代码 -->
        <c:if test="${pageBean.pageNum!=1}">
            <a href="/ProjectManagementSystem/roleConditionQuery?pageNum=1&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">首页</a>
            <a href="/ProjectManagementSystem/roleConditionQuery?pageNum=${pageBean.pageNum-1}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">上一页</a>
        </c:if>
        <c:forEach begin="${pageBean.pageNum-5>0?(pageBean.pageNum-5):1}" end="${pageBean.pageNum+4<=pageBean.totalPageNum?(pageBean.pageNum+4):pageBean.totalPageNum}" step="1" var="i" >
            <c:if test="${pageBean.pageNum==i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum!=i}">
                <a href="/ProjectManagementSystem/roleConditionQuery?pageNum=${i}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">${i}</a>
            </c:if>
        </c:forEach>
        <c:if test="${pageBean.pageNum!=pageBean.totalPageNum}">
            <a href="/ProjectManagementSystem/roleConditionQuery?pageNum=${pageBean.pageNum+1}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">下一页</a>
            <a href="/ProjectManagementSystem/roleConditionQuery?pageNum=${pageBean.totalPageNum}&conditionName=${requestScope.conditionName}&conditionValue=${requestScope.conditionValue}">尾页</a>
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