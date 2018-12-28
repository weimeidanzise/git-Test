<%--
  Created by IntelliJ IDEA.
  User: z_sir
  Date: 2018/12/15
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="file/upload" method="post" enctype="multipart/form-data">
        username:<input type="text" name="username"/><br/>
        password:<input type="password" name="pwd"/><br/>
        address:<input type="text" name="address"/><br/>
        email:<input type="text" name="email"/><br/>
        imgs:<input type="file" name="fileImg"/><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
