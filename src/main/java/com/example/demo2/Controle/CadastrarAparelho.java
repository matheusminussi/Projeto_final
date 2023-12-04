package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastrarAparelho", value = "/cadastrarAparelho")
public class CadastrarAparelho extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String nome=request.getParameter("nome");
        String modelo=request.getParameter("modelo");
        String marca=request.getParameter("marca");
        String numeroSerie=request.getParameter("serialN");
        //se os dados existirem
        if(Validador.temValor(nome)&&Validador.temValor(modelo)&&Validador.temValor(marca)&&Validador.temValor(numeroSerie)) {

            Aparelho a=new Aparelho(nome,modelo,marca,numeroSerie);
            try {
                AparelhoDaoInterface dao=new AparelhoDaoClasse();
                dao.inserir(a);
                dao.sair();
                //envia para o relatorio com a mensagem de sucesso
                response.sendRedirect("home.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else //senão
        {
            //envia para o index com a mensagem de erro
            response.sendRedirect("home.jsp?mensagem=faltadados");
        }
    }
}
 