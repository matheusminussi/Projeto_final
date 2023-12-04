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
        <td><button value="deletar">Deletar</button> </td>
        <td><button value="editar">Editar</button> </td>

    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
</body>
</html>
