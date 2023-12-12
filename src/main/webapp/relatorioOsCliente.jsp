<%--
  Created by IntelliJ IDEA.
  User: Matheus
  Date: 11/12/2023
  Time: 02:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="WEB-INF/menu.jsp" %>
   <div class="conteudo">
       <h1>Buscar por ordem de serviço do cliente</h1>
    <form action="buscarOsCliente" method="post">
        <label>Nome do cliente:
        <input type="text" name="nomeCliente"></label>
        <input type="submit" value="Buscar">
    </form>

       <div>
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
                       <td><c:out value="${os.id}"/></td>
                       <td><c:out value="${os.cliente.nome}" /></td>
                       <td><c:out value="${os.aparelho.nome}" /></td>
                       <td><c:out value="${os.observacao}" /></td>
                       <td><c:out value="${os.dataEntradaFormatada}" /></td>

                       <td>

                           <c:choose>
                               <c:when test="${empty os.dataSaida}">
                                   <form action="finalizaOs" method="post">
                                       <input type="hidden" name="id" value="${os.id}">
                                       <input type="submit" value="Finalizar O.S">
                                   </form>
                               </c:when>
                               <c:otherwise>
                                   ${os.dataSaidaFormatada}
                               </c:otherwise>
                           </c:choose>

                       </td>
                       <td>
                               ${os.valorTotal}
                       </td>

                       <td>
                           <form action="deletar" method="post">
                               <input type="hidden" name="id" value="${os.id}">
                               <input type="hidden" name="tipo" value="os">
                               <input type="submit" value="Deletar">
                           </form>
                       </td>
                       <td>
                           <form action="buscar" method="post">
                               <input type="hidden" name="id" value="${os.id}">
                               <input type="hidden" name="tipo" value="os">
                               <input type="submit" value="Editar">
                           </form>
                       </td>

                   </tr>
               </c:forEach>


               </tbody>
           </table>
       </div>
   </div>
</body>
</html>
