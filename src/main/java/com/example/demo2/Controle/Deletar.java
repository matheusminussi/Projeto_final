package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Modelo.Servico;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "deletar", value = "/deletar")
public class Deletar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String tid = request.getParameter("id");
        String tipo = request.getParameter("tipo");
        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {

        //se os dados existirem
        if (Validador.temValor(tid) && Validador.temValor(tipo)) {
            int id = Integer.parseInt(tid);

            if (tipo.equals("cliente")) {

                try {
                    ClienteDaoInterface dao = new ClienteDaoClasse();
                    dao.deletar(id);
                    dao.sair();
                    response.sendRedirect("buscarClientes?mensagem=removidocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("buscarClientes?mensagem=erroaoten                            tarremover");
                }
            } else if (tipo.equals("aparelho")) {

                try {
                    AparelhoDaoInterface dao = new AparelhoDaoClasse();
                    dao.deletar(id);
                    dao.sair();
                    response.sendRedirect("buscarAparelhos?mensagem=removidocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("buscarAparelhos?mensagem=erroaotentarremover");
                }
            } else if (tipo.equals("servico")) {

                try {
                    ServicoDaoInterface dao = new ServicoDaoClasse();
                    dao.deletar(id);
                    dao.sair();
                    response.sendRedirect("buscarServicos?mensagem=removidocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("buscarServicos?mensagem=erroaotentarremover");
                }
            } else if (tipo.equals("funcionario")) {

                try {
                    FuncionarioDaoInterface dao = new FuncionarioDaoClasse();
                    dao.deletar(id);
                    dao.sair();
                    response.sendRedirect("buscar?mensagem=removidocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("buscar?mensagem=erroaotentarremover");
                }
            } else if (tipo.equals("os")) {

                try {
                    OsDaoInterface dao = new OsDaoClasse();
                    dao.deletar(id);
                    dao.sair();
                    response.sendRedirect("buscarOs?mensagem=removidocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("buscarOs?mensagem=erroaotentarremover");
                }

            } else {
                response.sendRedirect("home.jsp?mensagem=faltadados");
            }
        }

        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }
}
 