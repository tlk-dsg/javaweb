<%--
  Created by IntelliJ IDEA.
  User: taoliankuan
  Date: 2021/3/9
  Time: 1:41 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="JspDemo3.jsp">
    <jsp:param name="name" value="tlk"></jsp:param>
    <jsp:param name="age" value="22"></jsp:param>

</jsp:forward>
</body>
</html>
