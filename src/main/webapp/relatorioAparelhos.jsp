<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Aparelhos</title>
</head>
<body>
<%@ include file="WEB-INF/menu.jsp" %>
<div class="conteudo">
    <h1>Aparelhos</h1>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Modelo</th>
            <th>Marca</th>
            <th>numero-serie</th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="aparelho" items="${requestScope.aparelhos}">
    <tr>
        <td><c:out value="${aparelho.id}" /></td>
        <td><c:out value="${aparelho.nome}" /></td>
        <td><c:out value="${aparelho.modelo}" /></td>
        <td><c:out value="${aparelho.marca}" /></td>
        <td><c:out value="${aparelho.numero_serie}" /></td>
        <td>
            <form action="deletar" method="post">
                <input type="hidden" name="id" value="${aparelho.id}">
                <input type="hidden" name="tipo" value="aparelho">
                <input type="submit" value="Deletar">
            </form>
        </td>
        <td>
            <form action="buscar" method="post">
                <input type="hidden" name="id" value="${aparelho.id}">
                <input type="hidden" name="nome" value="${aparelho.nome}">
                <input type="hidden" name="tipo" value="aparelho">
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
