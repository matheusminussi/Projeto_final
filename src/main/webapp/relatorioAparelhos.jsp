<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Aparelhos</title>
</head>
<body>
<%@ include file="WEB-INF/menu.jsp" %>
<div class="conteudo">
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
        <td><button value="deletar">Deletar</button> </td>
        <td><button value="editar">Editar</button> </td>

    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
</body>
</html>
