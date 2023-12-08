<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <th>Id da Os</th>
            <th>Cliente</th>
            <th>Aparelho</th>
            <th>Observação</th>
            <th>data de entrada</th>
            <th>Data de saida</th>
            <th> Serviços </th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>

    <c:forEach var="os" items="${requestScope.os}">
    <tr>
        <td><c:out value="${os.id}" /></td>
        <td><c:out value="${os.cliente.nome}" /></td>
        <td><c:out value="${os.aparelho.nome}" /></td>
        <td><c:out value="${os.observacao}" /></td>
        <td><c:out value="${os.dataEntrada}" /></td>

        <td>
            <!--Fazer a view dos servicos da os-->

        </td>

        <td>
            <form action="deletar" method="post">
                <input type="hidden" name="id" value="${os.id}">
                <input type="hidden" name="tipo" value="os">
                <input type="submit" value="Deletar">
            </form>
        </td>
        <td>

        </td>

    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
</body>
</html>
