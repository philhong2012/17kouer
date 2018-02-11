<%--
  Created by phil hong
  User: Administrator
  Date: 2018/2/11 0011
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../js/md5.min.js"></script>
</head>
<body>
用户名：<input type="text" name="loginName" /> <br/>
密码：<input type="password" name="password" /> <br/>
<input type="button" value="登录" onclick="login()" />

<script type="text/javascript">
    function login() {
        var user = {};
        $("input[type='text'],input[type='password']").each(function (i, e) {
            user[e.name] = e.value;
        });
        user.createdBy = "phil";
        user.password = md5(user.password);

        $.ajax({
            method: "POST",
            url: "/user/validate",
            data: JSON.stringify(user),
            dataType:'json',
            contentType: "application/json; charset=utf-8"
        })
            .done(function( msg ) {
                if(msg.code === '001') {
                    console.log("login completed");
                } else {
                    console.log("login failed");
                }
            }).fail(function (msg) {
                console.log("login name or password error");
        });
    }

</script>
</body>
</html>
