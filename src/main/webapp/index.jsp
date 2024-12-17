<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Recupera l'utente dalla sessione
    String user = (String) session.getAttribute("user");
%>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div class="container">
<h1>
    <%
        if (user != null) {
            out.println("Hello world, " + user + "!");
        } else {
            out.println("Hello world, guest!");
        }
    %>
</h1>

<%
    if (user == null) {
%>
<a href="<%=request.getContextPath()%>/login.jsp">GO to login</a>
<%
} else {
%>
<a href="<%=request.getContextPath()%>/logoutServlet">Logout</a>
<%
    }
%>
</div>
</body>
</html>
