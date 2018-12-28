<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/12/15
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    //编写json格式
                    url:"/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"uname":"老王","age":"15","data":"new data()"}',
                    type:"post",
                    datatype:"json",
                    success:function (data) {
                    alert("ok"+data)
                    }
                })

            });

        });
    </script>
</head>
<body>

    <%--<input type="button" id="btn" value="发送请求">--%>
    <button id="btn">发送ajax</button>



</body>
</html>
