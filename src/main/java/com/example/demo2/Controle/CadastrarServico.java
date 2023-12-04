package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Servico;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastrarServico", value = "/cadastrarServico")
public class CadastrarServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String nome=request.getParameter("nome");
        String descricao=request.getParameter("descricao");
        String Tvalor=request.getParameter("valor");
        //se os dados existirem
        if(Validador.temValor(nome)&&Validador.temValor(descricao)&&Validador.temValor(Tvalor)) {
            double valor = Double.parseDouble(Tvalor);

            Servico s=new Servico(nome,descricao,valor);
            try {
                ServicoDaoInterface dao=new ServicoDaoClasse() {
                };
                dao.inserir(s);
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
 