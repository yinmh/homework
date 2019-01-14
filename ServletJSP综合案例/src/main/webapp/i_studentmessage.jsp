<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019-01-14
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/insert" method="post">
    姓名:<input type="text" name="nickname" >
    <br>
    生日:<input type="date" name="birthday">
    <br>
    <input type="radio" name="sex" value="男" checked>男
    <input type="radio" name="sex" value="女" >女
    <br>
    <input type="submit" value="提交">

</form>
</body>
</html>
