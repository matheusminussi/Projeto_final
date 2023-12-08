
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editar</title>
</head>
<body>

<%@ include file="WEB-INF/menu.jsp" %>

<div class="conteudo">

    <c:if test="${not empty requestScope.cliente}">
    <form action="editar" method="post">
        <input type="hidden" name="id" value="${requestScope.cliente.id}">
        <label>Nome:
        <input type="text" name="nome" value="${requestScope.cliente.nome}"></label>
        <label>Telefone:
        <input type="text" name="telefone" value="${requestScope.cliente.telefone}"></label>
        <label>Endereco:
        <input type="text" name="endereco" value="${requestScope.cliente.endereco}"></label>
        <input type="hidden" name="tipo" value="cliente">
        <input type="submit" value="Editar">
    </form>
    </c:if>

    <c:if test="${not empty requestScope.aparelho}">
        <form action="editar" method="post">
            <input type="hidden" name="id" value="${requestScope.aparelho.id}">
            <label>Nome:
                <input type="text" name="nome" value="${requestScope.aparelho.nome}"></label>
            <label>Modelo:
                <input type="text" name="modelo" value="${requestScope.aparelho.modelo}"></label>
            <label>Marca:
                <input type="text" name="marca" value="${requestScope.aparelho.marca}"></label>
            <label>Numero de serie:
                <input type="text" name="numeroSerie" value="${requestScope.aparelho.numero_serie}"></label>
            <input type="hidden" name="tipo" value="aparelho">
            <input type="submit" value="Editar">
        </form>
    </c:if>

    <c:if test="${not empty requestScope.servico}">
        <form action="editar" method="post">
            <input type="hidden" name="id" value="${requestScope.servico.id}">
            <label>Nome:
                <input type="text" name="nome" value="${requestScope.servico.nome}"></label>
            <label>Descrição:
                <input type="text" name="descricao" value="${requestScope.servico.descricao}"></label>
            <label>Valor:
                <input type="text" name="valor" value="${requestScope.servico.valor}"></label>
            <input type="hidden" name="tipo" value="servico">
            <input type="submit" value="Editar">
        </form>
    </c:if>
</div>

</body>
</html>
