<%--
  Created by IntelliJ IDEA.
  User: hgs
  Date: 2020-04-14
  Time: 오후 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Srping Rest Demo</title>
</head>
<body>

    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>

    <br><br>

    <a href="${pageContext.request.contextPath}/api/students">Get All Students</a>


</body>
</html>
