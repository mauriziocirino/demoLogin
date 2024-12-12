<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user")==null)
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%
    if (session.getAttribute("user")==null){
%>
    <a href="login.jsp">GO to login</a>
<%
    }
%>
</body>
</html>