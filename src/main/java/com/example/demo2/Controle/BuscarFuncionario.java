package com.example.demo2.Controle;

import com.example.demo2.DAO.ErroDao;
import com.example.demo2.DAO.FuncionarioDaoClasse;
import com.example.demo2.DAO.FuncionarioDaoInterface;
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

@WebServlet(name = "buscarFuncionario", value = "/buscarFuncionario")
public class BuscarFuncionario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {

            try {

                FuncionarioDaoInterface dao=new FuncionarioDaoClasse();
                Set<Funcionario> funcionarios=dao.buscar();
                dao.sair();

                if(funcionarios!=null) // se funcionario for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("funcionarios",funcionarios);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioFuncionarios.jsp");
                    // Encaminhe a requisição para a JSP "editar.jsp"
                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("index.jsp?mensagem=loginousenhaincorretos");

                }
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaologar");
            }

        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }



}
 