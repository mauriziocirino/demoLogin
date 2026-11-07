<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>Create Catalogo</h1> <br>
    <!-- Visualizza il messaggio se presente -->
    <if test="${not empty message}">
        <p>${message}</p>
    </if>

    <form method="POST" name="createCatalogo" action="catalogo?query=insert">
        <label for="nome">Nome Catalogo</label>
        <input name="nome" type="text" id="nome"><br>
        <label for="stagione">Stagione Catalogo</label>
        <select name="stagione" id="stagione">
            <option name="stagione1" value="Estate">Estate</option>
            <option name="stagione2" value="Autunno">Autunno</option>
            <option name="stagione3" value="Inverno">Inverno</option>
            <option name="stagione4" value="Primavera">Primavera</option>
        </select> <br>
        <input type="submit" value="submit">
        <input type="reset" value="reset">
    </form>
    <button name="home" value="home"><a href="crud.jsp">Home</a></button>
</div>
</body>
</html>
