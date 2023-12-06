package com.example.demo2.Controle;

import com.example.demo2.DAO.*;
import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Modelo.Servico;
import com.example.demo2.Utils.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "cadastrarOs", value = "/cadastrarOs")
public class CadastrarOs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String nomeCliente=request.getParameter("cliente");
        String nomeAparelho=request.getParameter("aparelho");
        String obs=request.getParameter("obs");
        String nomeServico=request.getParameter("servico");
        //se os dados existirem
        if(Validador.temValor(nomeCliente)&&Validador.temValor(nomeAparelho)&&Validador.temValor(obs)) {



            try {
                ClienteDaoInterface daoCliente=new ClienteDaoClasse();
                Cliente cliente=daoCliente.buscar(nomeCliente); // retorna o cliente
                daoCliente.sair();

                AparelhoDaoInterface daoAparelho= new AparelhoDaoClasse();
                Aparelho aparelho=daoAparelho.buscar(nomeAparelho); // retorna o aparelho
                daoAparelho.sair();

                ServicoDaoInterface daoServico= new ServicoDaoClasse();
                Servico servico=daoServico.buscar(nomeServico); // retorna servico
                daoServico.sair();


                Date dataAtual = new Date();

                OrdemServico os = new OrdemServico(cliente,aparelho,obs,dataAtual);
                os.getServicos().add(servico);

                OsDaoInterface daoOs = new OsDaoClasse();
                daoOs.inserir(os);



                //envia para o relatorio com a mensagem de sucesso
                response.sendRedirect("home.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                response.sendRedirect("home.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else //senão
        {
            //envia para o home com a mensagem de erro
            response.sendRedirect("home.jsp?mensagem=faltadados");
        }
    }
}
 