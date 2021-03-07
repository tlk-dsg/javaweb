<%--
  Created by IntelliJ IDEA.
  User: taoliankuan
  Date: 2021/3/7
  Time: 3:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        Username: <input type="text" name=""username> <br>
        Password: <input type="password" name="password"> <br>
        Hobby:
        <input type="checkbox" name="hobbies" value="girl">girl
        <input type="checkbox" name="hobbies" value="code">code
        <input type="checkbox" name="hobbies" value="singing">singing
        <input type="checkbox" name="hobbies" value="movie">movie
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
