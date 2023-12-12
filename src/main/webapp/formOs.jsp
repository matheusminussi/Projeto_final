
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Ordem de serviço</title>
</head>
<body>

<%@ include file="WEB-INF/menu.jsp" %>


<div class="conteudo">
    <h1>Cadastrar ordem de serviço</h1>
    <form action="cadastrarOs" method="post">
        <label>Cliente:
            <input type="text" name="cliente" ></label>
        <div class="conteudo"></div>
        <label>Aparelho:
            <input type="text" name="aparelho"></label>
        <div class="conteudo"></div>
        <label>Observação:
            <input type="text" name="obs"></label>

        <div class="conteudo"></div>
        <label>Serviço a ser realizado:

<c:forEach var="servico" items="${requestScope.servicos}">
            <label>${servico.nome}
            <input type="checkbox" name="servicos" value="${servico.id}"></label>
        </c:forEach>
        <!--fazer o getvalor calcaular o valor de cada servico-->
            <div class="conteudo"></div>
        <input type="submit" value="Enviar" id="btEnviar">
    </form>
</div>


</body>
</html>
