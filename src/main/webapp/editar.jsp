
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editar</title>
</head>
<body>

<c:set var="funcionario" value="${requestScope.funcionario}"/>


<c:if test="${not empty funcionario}">

    <c:set var="nome" value="${funcionario.nome}"/>
    <input type="text" name="nome" value="${nome}">

</c:if>


</body>
</html>
