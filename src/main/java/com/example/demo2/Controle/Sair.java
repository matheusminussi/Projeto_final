package com.example.demo2.Controle;

import com.example.demo2.Modelo.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "sair", value = "/sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao=request.getSession();
        Funcionario funcionarioLogado=(Funcionario) sessao.getAttribute("usuario");
        if(funcionarioLogado!=null)
        {
            sessao.removeAttribute("funcionario");
            response.sendRedirect("login.jsp?mensagem=tchau");
        }
        else
            response.sendRedirect("login.jsp?mensagem=naoestavalogado");
    }

}
 