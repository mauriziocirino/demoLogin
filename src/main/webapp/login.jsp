<%@ page import="model.User" %><%
    User userSession = (User) session.getAttribute("userSession");
    String errorLogin = (String) session.getAttribute("errorMessage");
    String successLogin = (String) session.getAttribute("successLogin");
%>

<link rel="stylesheet" href="css/loginPage.css" type="text/css"/>
<link rel="stylesheet" href="css/style.css" type="text/css"/>

<html>
<head>
    <title>Login PAGE FORM</title>
</head>
<body>
<div class="container">
    <form method="POST" action="loginServlet" name="loginForm">
        <h1>Insert your credential here </h1>
        <label for="user">Username</label><br>
        <input type="text" id="user" name="user" required placeholder="mariorossi"><br>
        <label for="pass">Password</label><br>
        <input type="password" id="pass" name="pass" required placeholder="*****">
        <button type="submit">Login</button>
        <button type="reset">Cancel</button>
    </form>
    <div id="message"> </div>
    <%if(userSession == null && successLogin != null){ %>
    <div id="successLogin" class="successLogin"> <%=successLogin%></div>
    <%}%>

    <%if(userSession == null && errorLogin != null){ %>
    <div id="errorMessage" class="errorLogin" style="color: red;"> <%=errorLogin%></div>

    <%}%>

</div>

</body>
</html>
