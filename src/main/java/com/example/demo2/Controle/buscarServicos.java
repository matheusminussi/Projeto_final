package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Modelo.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarServicos", value = "/buscarServicos")
public class buscarServicos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {

            try {
                ServicoDaoInterface dao=new ServicoDaoClasse() {
                };
                Set<Servico> servicos=dao.buscar();
                dao.sair();

                if(servicos!=null) // se cliente for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("servicos",servicos);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioservicos.jsp");
                    // Encaminhe a requisição para a JSP "relatorioClientes.jsp"
                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=Semservicos");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarservicos");
            }

        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");

    }
}
 