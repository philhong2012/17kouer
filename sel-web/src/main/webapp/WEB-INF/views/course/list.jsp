<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/10 0010
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/course/create">create</a>
<ul>
<c:forEach var="course" items="${list}">
    <li>  ${course.courseName}</li>

</c:forEach>
</ul>

</body>
</html>
