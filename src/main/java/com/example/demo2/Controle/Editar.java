package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.Servico;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "editar", value = "/editar")
public class Editar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String tid=request.getParameter("id");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String numeroSerie = request.getParameter("numeroSerie");
        String descricao = request.getParameter("descricao");
        String tvalor = request.getParameter("valor");
        String tipo=request.getParameter("tipo");

        //se os dados existirem
        if(Validador.temValor(tid)&&Validador.temValor(tipo)) {
            int id=Integer.parseInt(tid);

            switch (tipo) {
                case "cliente":

                    try {
                        ClienteDaoInterface dao = new ClienteDaoClasse();
                        Cliente c = new Cliente(id, nome, telefone, endereco);
                        dao.editar(c);
                        dao.sair();
                        response.sendRedirect("buscarClientes?mensagem=editadocomsucesso");
                    } catch (ErroDao e) {
                        response.sendRedirect("buscarClientes?mensagem=erroaotentareditar");
                    }
                    break;
                case "aparelho":
                    try {
                        AparelhoDaoInterface dao = new AparelhoDaoClasse();
                        Aparelho a = new Aparelho(id, nome, modelo, marca, numeroSerie);
                        System.out.println(a.toString());
                        dao.editar(a);
                        dao.sair();
                        response.sendRedirect("buscarAparelhos?mensagem=editadocomsucesso");
                    } catch (ErroDao e) {
                        response.sendRedirect("buscarAparelhos?mensagem=erroaotentareditar");
                    }
                    break;
                case "servico":

                    try {
                        double valor= Double.parseDouble(tvalor);

                        ServicoDaoInterface dao = new ServicoDaoClasse();
                        Servico s = new Servico(id,nome,descricao,valor);
                        System.out.println("AQUI" + s.toString());// aqui chega
                        dao.editar(s);
                        dao.sair();
                        response.sendRedirect("buscarServicos?mensagem=editadocomsucesso");
                    } catch (ErroDao e) {
                        response.sendRedirect("buscarServicos?mensagem=erroaotentareditar");
                    }
                    break;
                case "funcionario":

                    try {
                        FuncionarioDaoInterface dao = new FuncionarioDaoClasse();
                        dao.deletar(id);
                        dao.sair();
                        response.sendRedirect("buscar?mensagem=removidocomsucesso");
                    } catch (ErroDao e) {
                        response.sendRedirect("buscar?mensagem=erroaotentarremover");
                    }
                    break;
            }

        }else{
            response.sendRedirect("home.jsp?mensagem=faltadados");
        }
    }
}
 