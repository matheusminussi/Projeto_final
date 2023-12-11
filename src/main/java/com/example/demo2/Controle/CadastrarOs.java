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
import java.time.LocalDateTime;
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
        String[] idServicos=request.getParameterValues("servicos");
        //se os dados existirem
        if(Validador.temValor(nomeCliente)&&Validador.temValor(nomeAparelho)&&Validador.temValor(obs)) {



            try {
                ClienteDaoInterface daoCliente=new ClienteDaoClasse();
                Cliente cliente=daoCliente.buscar(nomeCliente); // retorna o cliente
                daoCliente.sair();

                AparelhoDaoInterface daoAparelho= new AparelhoDaoClasse();
                Aparelho aparelho=daoAparelho.buscar(nomeAparelho); // retorna o aparelho
                daoAparelho.sair();




                LocalDateTime dataHoraAtual = LocalDateTime.now();

                OrdemServico os = new OrdemServico(cliente,aparelho,obs,dataHoraAtual);


                ServicoDaoInterface daoServico= new ServicoDaoClasse();
                for (int i=0;i<idServicos.length;i++){
                    int id = Integer.parseInt(idServicos[i]);
                    Servico servico=daoServico.buscar(id);

                    os.getServicos().add(servico);
                }daoServico.sair();

                OsDaoInterface daoOs = new OsDaoClasse();
                daoOs.inserir(os);



                //envia para o relatorio com a mensagem de sucesso
                response.sendRedirect("home.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                System.out.println(e);
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
 