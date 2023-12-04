<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Serviços</title>
</head>
<body>
<%@ include file="WEB-INF/menu.jsp" %>
<div class="conteudo">
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="servico" items="${requestScope.servicos}">
    <tr>
        <td><c:out value="${servico.id}" /></td>
        <td><c:out value="${servico.nome}" /></td>
        <td><c:out value="${servico.descricao}" /></td>
        <td><c:out value="${servico.valor}" /></td>
        <td><button value="deletar">Deletar</button> </td>
        <td><button value="editar">Editar</button> </td>

    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
</body>
</html>