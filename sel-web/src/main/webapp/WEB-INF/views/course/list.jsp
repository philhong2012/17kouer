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
<c:forEach var="i" begin="1" end="5">
    Item <c:out value="${i}"/><p>

</p></c:forEach>


</body>
</html>
