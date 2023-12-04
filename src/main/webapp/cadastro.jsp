
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar</title>

</head>
<body>

<%@ include file="WEB-INF/menu.jsp" %>
<div class="conteudo" >
    <input type="radio" name="opcao" value="div1" onclick="mostrarDiv('div1')"> Clientes
    <input type="radio" name="opcao" value="div2" onclick="mostrarDiv('div2')"> Aparelhos
    <input type="radio" name="opcao" value="div3" onclick="mostrarDiv('div3')"> Serviços
    <input type="radio" name="opcao" value="div4" onclick="mostrarDiv('div4')"> Funcionarios


    <div id="div1" class="menu-cadastro" style="display:block;">
            <form action="cadastrarCliente" method="post">
                <label>Nome
                    <input type="text" name="nome"></label>
                <label>Telefone
                    <input type="text" name="telefone"></label>
                <label>Endereço
                    <input type="text" name="endereco"></label>
                <input type="submit" value="Cadastrar">
            </form>
    </div>
    <div id="div2" class="menu-cadastro" style="display:none;">
        <form>
            <label>Nome
                <input type="text" name="nome"></label>
            <label>modelo
                <input type="text" name="modelo"></label>
            <label>Marca
                <input type="text" name="marca"></label>
            <label>Numero de serie
                <input type="text" name="serialN"></label>
            <input type="submit" value="Cadastrar">
        </form>
    </div>
    <div id="div3" class="menu-cadastro" style="display:none;">
        <form>
            <label>Nome
                <input type="text" name="nome"></label>
            <label>Descrição
                <input type="text" name="descricao"></label>
            <label>Valor
                <input type="text" name="valor"></label>

            <input type="submit" value="Cadastrar">
        </form>
    </div>
    <div id="div4" class="menu-cadastro" style="display:none;">
        <form action="cadastrarFuncionario" method="post">
            <label>Nome
                <input type="text" name="nome"></label>
            <label>Login
                <input type="text" name="login"></label>
            <label>Senha
                <input type="text" name="senha"></label>
            <input type="submit" value="Cadastrar">
        </form>
    </div>

</div>
<script src="codigo.js"></script>

</body>
</html>
