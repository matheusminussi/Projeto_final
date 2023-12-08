package com.example.demo2.Controle;

import com.example.demo2.DAO.ErroDao;
import com.example.demo2.DAO.ServicoDaoClasse;
import com.example.demo2.DAO.ServicoDaoInterface;
import com.example.demo2.Modelo.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarFormOs", value = "/buscarFormOs")
public class BuscarFormOs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try {
                ServicoDaoInterface dao=new ServicoDaoClasse();
                Set<Servico> servicos=dao.buscar();
                dao.sair();

                if(servicos!=null)
                {
                    request.setAttribute("servicos",servicos);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/formOs.jsp");

                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=Semservicos");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarservicos");
            }



    }
}
 