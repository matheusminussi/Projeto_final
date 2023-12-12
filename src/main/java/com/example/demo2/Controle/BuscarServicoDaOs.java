package com.example.demo2.Controle;

import com.example.demo2.DAO.ErroDao;
import com.example.demo2.DAO.OsDaoClasse;
import com.example.demo2.DAO.OsDaoInterface;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Modelo.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "buscarServicoDaOs", value = "/buscarServicoDaOs")
public class BuscarServicoDaOs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {
            try {
                OsDaoInterface dao=new OsDaoClasse();
                List<Servico> listaServicosDaOs = new ArrayList<>();
                listaServicosDaOs = dao.buscarServicos(dao.buscarIdServicos(id));
                dao.sair();

                if(listaServicosDaOs!=null)
                {
                    request.setAttribute("servicosDaOs",listaServicosDaOs);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/buscarOsFinalizadas");

                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=SemOs");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarClientes");
            }

        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");

    }
}
 