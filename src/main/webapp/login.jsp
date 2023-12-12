
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="estilo.css" >
</head>
<body id="pageLogin">
<div id="divLogin">
    <form method="post" action="logar">
        <h1>Login</h1>
        <h3>Informe os dados para login</h3>
        <label>Usuario
            <input class="inputLogin" type="text" placeholder="Usuario" name="login"></label>
        <label>Senha
            <input class="inputLogin" type="password" placeholder="Senha" name="senha"></label>
        <input id="btLogar" type="submit" value="Logar">
    </form>
</div>

</body>
</html>
