package com.example.demo2.Controle;

import com.example.demo2.DAO.ErroDao;
import com.example.demo2.DAO.FuncionarioDaoClasse;
import com.example.demo2.DAO.FuncionarioDaoInterface;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "relatorio", value = "/relatorio")
public class Relatorio extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {

        if(Validador.temValor(login)&&Validador.temValor(senha)){
            try {

                FuncionarioDaoInterface dao=new FuncionarioDaoClasse();
                Funcionario f=dao.buscar(login,senha);
                dao.sair();
                if(f!=null) // se funcionario for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("funcionario",f);
                    request.getRequestDispatcher("editar.jsp");
                }
                else {
                    response.sendRedirect("index.jsp?mensagem=loginousenhaincorretos");

                }
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaologar");
            }
        }

        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }
}
 