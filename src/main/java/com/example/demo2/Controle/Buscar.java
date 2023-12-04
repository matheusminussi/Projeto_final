package com.example.demo2.Controle;

import com.example.demo2.DAO.ErroDao;
import com.example.demo2.DAO.FuncionarioDaoClasse;
import com.example.demo2.DAO.FuncionarioDaoInterface;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "buscar", value = "/buscar")
public class Buscar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");

        if(Validador.temValor(login)&&Validador.temValor(senha)){
            try {

                FuncionarioDaoInterface dao=new FuncionarioDaoClasse();
                Funcionario f=dao.buscar(login,senha);
                dao.sair();

                if(f!=null) // se funcionario for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("funcionario",f);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
                    // Encaminhe a requisição para a JSP "editar.jsp"
                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("index.jsp?mensagem=loginousenhaincorretos");

                }
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaologar");
            }
        }


    }
}
 