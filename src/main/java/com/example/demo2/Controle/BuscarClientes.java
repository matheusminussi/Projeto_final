package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarClientes", value = "/buscarClientes")
public class BuscarClientes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try {
                ClienteDaoInterface dao=new ClienteDaoClasse();
                Set<Cliente> clientes=dao.buscar();
                dao.sair();

                if(clientes!=null) // se cliente for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("clientes",clientes);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioClientes.jsp");
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
 