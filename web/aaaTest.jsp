<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/9/5
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="resource" items="${pageBean.beanList}" >
    ${resource.resource_id}---${resource.resource_name}---${num}<br>

</c:forEach>

</body>
<script>
    if(${conditionName eq "0"}){
        conditionNames[0].checked=true;
    }else {
        var value="${conditionName}";
        for (var i=1;i<conditionNames.length;i++){
            //console.log(conditionNames[i].value);
            if(conditionNames[i].value==value){
                conditionNames[i].checked=true;
                break;
            }
        }
    }

    if("${orderby}".trim()==""){
        orderbys[0].checked=true;
    }else {
        var value = "${orderby}";
        for (var i=1;i<orderbys.length;i++){
            //console.log(conditionNames[i].value);
            if(orderbys[i].value==value){
                orderbys[i].checked=true;
                break;
            }
        }
    }
</script>
</html>
