package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.*;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "buscar", value = "/buscar")
public class Buscar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String tid=request.getParameter("id");
        String nome=request.getParameter("nome");
        String tipo=request.getParameter("tipo");

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {

            //se os dados existirem
            if (Validador.temValor(tid) && Validador.temValor(tipo)) {
                int id = Integer.parseInt(tid);

                if (tipo.equals("cliente")) {

                    try {
                        ClienteDaoInterface dao = new ClienteDaoClasse();
                        Cliente cliente = dao.buscar(id);
                        dao.sair();
                        request.setAttribute("cliente", cliente);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
                        // Encaminha a requisição para a JSP "editar.jsp"
                        dispatcher.forward(request, response);
                    } catch (ErroDao e) {
                        response.sendRedirect("buscarClientes?mensagem=erroaotentareditar");
                    }
                } else if (tipo.equals("aparelho")) {

                    try {
                        AparelhoDaoInterface dao = new AparelhoDaoClasse();
                        Aparelho aparelho = dao.buscar(id);
                        dao.sair();
                        request.setAttribute("aparelho", aparelho);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
                        // Encaminha a requisição para a JSP "editar.jsp"
                        dispatcher.forward(request, response);
                    } catch (ErroDao e) {
                        response.sendRedirect("buscarAparelhos?mensagem=erroaotentarremover");
                    }
                } else if (tipo.equals("servico")) {

                    try {
                        ServicoDaoInterface dao = new ServicoDaoClasse();
                        Servico servico = dao.buscar(id);
                        dao.sair();
                        request.setAttribute("servico", servico);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
                        // Encaminha a requisição para a JSP "editar.jsp"
                        dispatcher.forward(request, response);
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
                }if (tipo.equals("os")) {

                    try {
                        OsDaoInterface dao = new OsDaoClasse();
                        OrdemServico os = dao.buscar(id);
                        dao.sair();
                        request.setAttribute("os", os);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
                        // Encaminha a requisição para a JSP "editar.jsp"
                        dispatcher.forward(request, response);
                    } catch (ErroDao e) {
                        response.sendRedirect("buscarClientes?mensagem=erroaotentareditar");
                    }
                }

            } else {
                response.sendRedirect("home.jsp?mensagem=faltadados");
            }
        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }
}
 