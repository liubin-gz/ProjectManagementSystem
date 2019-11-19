<%--
Created by IntelliJ IDEA.
User: asus
Date: 2019/9/3
Time: 13:25
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>欢迎登陆项目平台管理系统</TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2800.1611" name=GENERATOR>
<LINK href="images/css1.css" type=text/css rel=stylesheet><LINK
href="images/newhead.css" type=text/css rel=stylesheet></HEAD>
<BODY bgColor=#eef8e0 leftMargin=0 topMargin=0 MARGINWIDTH="0" MARGINHEIGHT="0">

<FORM name=adminlogin action=/ProjectManagementSystem/login method=post onsubmit="return checkFrom()">
<TABLE cellSpacing=0 cellPadding=0 width=1004 border=0 align="center">
  <TBODY>
  <TR>
    <TD colSpan=6><IMG height=92 alt="" src="images/crm_1.gif"
    width=345></TD>
    <TD colSpan=4><IMG height=92 alt="" src="images/crm_2.gif"
    width=452></TD>
    <TD><IMG height=92 alt="" src="images/crm_3.gif" width=207></TD></TR>
  <TR>
    <TD colSpan=6><IMG height=98 alt="" src="images/crm_4.gif"
    width=345></TD>
    <TD colSpan=4><IMG height=98 alt="" src="images/crm_5.gif"
    width=452></TD>
    <TD><IMG height=98 alt="" src="images/crm_6.gif" width=207></TD></TR>
  <TR>
    <TD rowSpan=5><IMG height=370 alt="" src="images/crm_7.gif"
    width=59></TD>
    <TD colSpan=5><IMG height=80 alt="" src="images/crm_8.gif"
    width=286></TD>
    <TD colSpan=4><IMG height=80 alt="" src="images/crm_9.gif"
    width=452></TD>
    <TD><IMG height=80 alt="" src="images/crm_10.gif" width=207></TD></TR>
  <TR >
    <TD><IMG height=110 alt="" src="images/crm_11.gif" width=127></TD>
    <TD background=images/crm_12.gif colSpan=6>
      <TABLE id=table1 cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
          <TD>
            <TABLE id=table2 cellSpacing=1 cellPadding=0 width="100%" 
              border=0><TBODY>
              <TR>
                <TD align=middle width=81><FONT color=#ffffff>用户名：</FONT></TD>
                <TD><INPUT class=regtxt title=请填写用户名 maxLength=16 size=16 
                   name=user_name id="user_name"></TD></TR>
              <TR>
                <TD align=middle width=81><FONT color=#ffffff>密&nbsp; 
                码：</FONT></TD>
                <TD><INPUT class=regtxt title=请填写密码 type=password maxLength=16 
                  size=16 name=user_password id="user_password"></TD></TR>
              <TR>
                <TD align=middle width=81><FONT color=#ffffff>验证码：</FONT></TD>
                <TD><INPUT class=regtxt title=请填写验证码 maxLength=50 size=16 
                   name=verificationCode id="code"></TD> <%--<INPUT type=hidden value=check
                  name=login>--%>&nbsp;&nbsp;<TD><img src="/ProjectManagementSystem/verificationCode" id="verificationCode" onclick="changeVerificationCode()" style="cursor: pointer"></TD>
                </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
    <TD colSpan=2 rowSpan=2><IMG height=158 alt="" 
      src="images/crm_13.gif" width=295></TD>
    <TD rowSpan=2><IMG height=158 alt="" src="images/crm_14.gif"
      width=207></TD></TR>
  <TR>
    <TD rowSpan=3><IMG height=180 alt="" src="images/crm_15.gif"
      width=127></TD>
    <TD rowSpan=3><IMG height=180 alt="" src="images/crm_16.gif"
    width=24></TD>
    <TD><INPUT title=登录项目平台管理系统 type=image height=48 alt="" width=86 
      src="images/crm_17.gif" name=image></TD>
    <TD><IMG height=48 alt="" src="images/crm_18.gif" width=21></TD>
    <TD colSpan=2><A ><IMG 
      title=关闭页面 height=48 alt="" src="images/crm_19.gif" width=84
      border=0></A></TD>
    <TD><IMG height=48 alt="" src="images/crm_20.gif" width=101></TD></TR>
  <TR>
    <TD colSpan=5 rowSpan=2><IMG height=132 alt="" 
      src="images/crm_21.gif" width=292></TD>
    <TD rowSpan=2><IMG height=132 alt="" src="images/crm_22.gif"
      width=170></TD>
    <TD colSpan=2><IMG height=75 alt="" src="images/crm_23.gif"
    width=332></TD></TR>
  <TR>
    <TD colSpan=2><IMG height=57 alt="" src="images/crm_24.gif"
    width=332></TD></TR>
  <TR>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=59></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=127></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=24></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=86></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=21></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=28></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=56></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=101></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=170></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=125></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif"
  width=207></TD></TR></TBODY></TABLE></FORM></BODY>
<script type="text/javascript">
    function changeVerificationCode(){
        document.getElementById("verificationCode").src="/ProjectManagementSystem/verificationCode?"+new Date().getTime();
    }

    function checkFrom() {
        var code = document.getElementById("code").value;
        if(code.trim().length==0||code==""){
            alert("验证码不能为空！");
            return false;
        }
        var user_name=document.getElementById("user_name").value;
        if(user_name.trim().length==0||user_name==""){
            alert("用户名不能为空！");
            return false;
        }
        var user_password=document.getElementById("user_password").value;
        if(user_password.trim().length==0||user_password==""){
            alert("密码不能为空！");
            return false;
        }
    }

    <c:if test="${msg==1}">
    alert("验证码输入错误!!");
    </c:if>
    <c:if test="${msg==2}">
    alert("用户名或密码输入错误!!");
    </c:if>
</script>
</HTML>
