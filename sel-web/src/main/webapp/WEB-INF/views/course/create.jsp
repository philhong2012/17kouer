<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%--<meta http-equiv="content-type" content="charset=utf-8">--%>
    <title>create course</title>
</head>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<body>
  <input type="text" name="courseName" >

  <input type="button" value="保存" onclick="onSave()"><a href="/course/list">list</a>
</body>

<script type="text/javascript">
    function onSave() {
        var course = {};
        $("input[type='text']").each(function (i, e) {
            course[e.name] = e.value;
        });
        course.createdBy = "phil";


        $.ajax({
            method: "POST",
            url: "/course/save",
            data: JSON.stringify(course),
            dataType:'json',
            contentType: "application/json; charset=utf-8"

        })
            .done(function( msg ) {
                //alert( "Data Saved: " + msg );
                if(msg.code === '001') {
                    console.log("save completed")
                }
            });
    }

</script>
</html>