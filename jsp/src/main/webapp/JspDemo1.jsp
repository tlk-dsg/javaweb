<%--
  Created by IntelliJ IDEA.
  User: taoliankuan
  Date: 2021/3/9
  Time: 1:38 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    pageContext.setAttribute("name1" , "tlk1");
    request.setAttribute("name2","tlk2");
    application.setAttribute("name3","tlk3");

%>

<%
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) request.getAttribute("name2");
    String name3 = (String) application.getAttribute("name3");

%>

<h1>KEY:</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
</body>
</html>
