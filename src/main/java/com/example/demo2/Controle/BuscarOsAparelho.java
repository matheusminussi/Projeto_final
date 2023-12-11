package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.OrdemServico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarOsAparelho", value = "/buscarOsAparelho")
public class BuscarOsAparelho extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String numeroSerie = request.getParameter("numeroSerie");
            try {
                AparelhoDaoInterface daoAparelho=new AparelhoDaoClasse();
                OsDaoInterface daoOs = new OsDaoClasse();
                Set<OrdemServico> osAparelho =  daoOs.buscarAparelho(daoAparelho.buscarNumeroSerie(numeroSerie));
                daoOs.sair();
                daoAparelho.sair();

                if(osAparelho!=null) // se cliente for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("os",osAparelho);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioOsAparelho.jsp");
                    // Encaminhe a requisição para a JSP "relatorioClientes.jsp"
                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=SemClientes");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarClientes");
            }



    }
}
 