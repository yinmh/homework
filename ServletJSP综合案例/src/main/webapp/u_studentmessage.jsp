<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019-01-14
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update" method="post">
姓名:<input type="text" name="nickname" value="${student.sname}">
<br>
生日:<input type="date" name="birthday" value="${student.birthday}">
<br>
<input type="radio" name="sex" value="男" id="nan" <c:if test="${student.sex =='男'}">checked</c:if>>男
<input type="radio" name="sex" value="女" id="nv" <c:if test="${student.sex =='女'}">checked</c:if>>女
<br>
<input type="submit" value="提交">

</form>
</body>
</html>
