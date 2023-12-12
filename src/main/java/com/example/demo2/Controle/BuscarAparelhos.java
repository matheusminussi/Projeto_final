package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.Funcionario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarAparelhos", value = "/buscarAparelhos")
public class BuscarAparelhos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {

            try {
                AparelhoDaoInterface dao=new AparelhoDaoClasse();
                Set<Aparelho> aparelhos=dao.buscar();
                dao.sair();

                if(aparelhos!=null) // se cliente for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("aparelhos",aparelhos);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioAparelhos.jsp");
                    // Encaminhe a requisição para a JSP "relatorioClientes.jsp"
                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=SemAparelho");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarAparelho");
            }


        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }
}
 