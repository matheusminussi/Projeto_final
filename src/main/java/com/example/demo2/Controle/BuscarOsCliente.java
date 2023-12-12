package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.Funcionario;
import com.example.demo2.Modelo.OrdemServico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "buscarOsCliente", value = "/buscarOsCliente")
public class BuscarOsCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeCliente = request.getParameter("nomeCliente");

        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("funcionario");
        if(funcionarioLogado!=null) {
            try {
                ClienteDaoInterface daoCliente=new ClienteDaoClasse();
                OsDaoInterface daoOs = new OsDaoClasse();
                Set<OrdemServico> osCliente = daoOs.buscarCliente(daoCliente.buscar(nomeCliente));
                System.out.println("AQUI -----------------> "+osCliente.toString());
                daoOs.sair();
                daoCliente.sair();

                if(osCliente!=null) // se cliente for diferente de null atribui os funcionarios na requisisao
                {
                    request.setAttribute("os",osCliente);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorioOsCliente.jsp");
                    // Encaminhe a requisição para a JSP "relatorioClientes.jsp"
                    dispatcher.forward(request, response);

                }
                else {
                    response.sendRedirect("home.jsp?mensagem=SemClientes");

                }
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroBuscarClientes");
            }


        }else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }
}
 