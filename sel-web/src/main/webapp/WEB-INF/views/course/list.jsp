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
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<a href="/course/create">create</a>
<ul>
<c:forEach var="course" items="${list}">
    <li>  ${course.courseName}</li>

</c:forEach>
</ul>
<input type="button" value="获取课程列表" onclick="getCourseList();">
</body>
<script type="text/javascript">
    function getCourseList() {

        $.ajax({
                    method: "POST",
                    url: "/course/list2",
                    data:null,
                    dataType:'json',
                    contentType: "application/json; charset=utf-8"
                })
                .done(function( msg ) {
                    if(msg.code === '001') {
                        //console.log("login completed");
                    } else {
                        //console.log("login failed");
                    }
                }).fail(function (msg) {
            console.log("login name or password error");
        });
    }

</script>
</html>
