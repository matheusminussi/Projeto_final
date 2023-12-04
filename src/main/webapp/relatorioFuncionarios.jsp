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
            <th>Login</th>
            <th>Senha</th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="funcionario" items="${requestScope.funcionarios}">
    <tr>
        <td><c:out value="${funcionario.id}" /></td>
        <td><c:out value="${funcionario.nome}" /></td>
        <td><c:out value="${funcionario.login}" /></td>
        <td><c:out value="${funcionario.senha}" /></td>
        <td>
            <form action="deletar" method="post">
                <input type="hidden" name="id" value="${funcionario.id}">
                <input type="hidden" name="tipo" value="funcionario">
                <input type="submit" value="Deletar">
            </form>
        </td>
        <td><button value="editar">Editar</button> </td>

    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
</body>
</html>
