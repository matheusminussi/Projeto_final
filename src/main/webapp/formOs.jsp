
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordem de serviço</title>
</head>
<body>
<div>
    <form action="cadastrarOs" method="post">
        <label>Cliente:
            <input type="text" name="cliente" ></label>
        <label>Aparelho:
            <input type="text" name="aparelho"></label>
        <label>Observação:
            <input type="text" name="obs"></label>
        <label>Serviço a ser realizado:
            <input type="text" name="servico"></label>

        <!-- fazer o insert data de entrada-->

        <!--fazer o getvalor calcaular o valor de cada servico-->

        <input type="submit" value="Enviar" id="btEnviar">
    </form>
</div>


</body>
</html>
