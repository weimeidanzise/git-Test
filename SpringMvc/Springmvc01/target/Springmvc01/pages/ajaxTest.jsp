<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/12/15
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="submit" value="提交" id="butt">
</form>
<script>
    $(function () {
        $("#butt").click(function () {
            $.ajax({
                type: 'post',
                url: 'pages/ajaxTest',
                data: "username=老王",
                success: function (data) {
                    alert("ok" + data.length)
                },
                error: function () {
                    alert("error")
                }
            })
        })
    })
</script>
</body>
</html>
