<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="estilo.css" >
<div class="menu-lateral">
    <!--<img src="logo.png" alt="logo">-->

    <a href="home.jsp" class="menu-item">Home</a>
    <a href="cadastro.jsp" class="menu-item">Cadastar</a>

    <div class="menu-item">
        Relatorios
        <div class="submenu">
            <a href="buscarClientes">Clientes</a>
            <a href="buscarAparelhos">Aparelhos</a>
            <a href="buscarServicos">Serviços</a>
            <a href="buscar">Funcionarios</a>

        </div>
    </div>
    <a href="buscarFormOs" class="menu-item">Ordem de serviço</a>

    <div class="menu-item">
        Relatorios OS
        <div class="submenu">
            <a href="buscarOs">OS abertas</a>
            <a href="buscarOsFinalizadas">OS finalizadas</a>
            <a href="relatorioOsCliente.jsp">OS cliente</a> <!--FAZER-->
            <a href="buscarOsAparelho">OS aparelho</a> <!--FAZER-->
        </div>
    </div>

    <a href="sair" class="menu-item">Sair</a>
</div>

<div class="conteudo">
    <!-- O conteúdo da página vai aqui -->
</div>