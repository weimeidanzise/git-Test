<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>Hello World!</h2>
<!-- 第一种访问方式 -->
<a href="${pageContext.request.contextPath}/hello">
    查询账户
</a>
<br/>
<!-- 第二种访问方式 -->
<a href="/findAll">UserController</a><br/>
<a href="/hello">HelloController</a>
<br/>
<a href="/hello?id=10">chaxun</a>
<br/>
<a href="/findUser">findUser</a><br/>
<a href="/findsucc">findsucc</a><br/>

<a href="/forwardAndRedirect">forwardAndRedirect</a><br/>

</body>
</html>
