package com.example.demo2.Controle;

import com.example.demo2.DAO.ErroDao;
import com.example.demo2.DAO.OsDaoClasse;
import com.example.demo2.DAO.OsDaoInterface;
import com.example.demo2.Modelo.OrdemServico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarOsFinalizadas", value = "/buscarOsFinalizadas")
public class BuscarOsFinalizadas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try {
                OsDaoInterface dao=new OsDaoClasse();
                Set<OrdemServico> ordemServicos=dao.buscarFinalizadas();
                dao.sair();

                if(ordemServicos!=null)
                {
                    request.setAttribute("os",ordemServicos);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioOs.jsp");

                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=SemOs");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarClientes");
            }



    }
}
 