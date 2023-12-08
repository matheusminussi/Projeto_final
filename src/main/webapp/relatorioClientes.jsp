<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Clientes</title>
</head>
<body>
<%@ include file="WEB-INF/menu.jsp" %>
<div class="conteudo">
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>telefone</th>
            <th>endereço</th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="cliente" items="${requestScope.clientes}">
    <tr>
        <td><c:out value="${cliente.id}" /></td>
        <td><c:out value="${cliente.nome}" /></td>
        <td><c:out value="${cliente.telefone}" /></td>
        <td><c:out value="${cliente.endereco}" /></td>
        <td>
            <form action="deletar" method="post">
                <input type="hidden" name="id" value="${cliente.id}">
                <input type="hidden" name="tipo" value="cliente">
                <input type="submit" value="Deletar">
            </form>
        </td>
        <td>
            <form action="buscar" method="post">
                <input type="hidden" name="id" value="${cliente.id}">
                <input type="hidden" name="nome" value="${cliente.nome}">
                <input type="hidden" name="tipo" value="cliente">
                <input type="submit" value="Editar">
            </form>
        </td>

    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
</body>
</html>
