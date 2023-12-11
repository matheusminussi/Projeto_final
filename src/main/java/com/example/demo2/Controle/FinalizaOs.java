package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "finalizaOs", value = "/finalizaOs")
public class FinalizaOs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String tid=request.getParameter("id");

        //se os dados existirem
        if(Validador.temValor(tid)) {
            int id=Integer.parseInt(tid);

                try {
                    OsDaoInterface dao=new OsDaoClasse();
                    OrdemServico os = dao.buscar(id);
                    LocalDateTime dataHoraAtual = LocalDateTime.now();
                    dao.finaliar(os,dataHoraAtual);
                    dao.sair();
                    response.sendRedirect("buscarOs?mensagem=OsFinalizada");
                }catch (ErroDao e) {
                        response.sendRedirect("buscarClientes?mensagem=erroaotentareditar");
                    }

        }else{
            response.sendRedirect("home.jsp?mensagem=faltadados");
        }
    }
}
 