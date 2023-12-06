package com.example.demo2.DAO;



import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Modelo.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OsDaoClasse implements OsDaoInterface{
    private Connection con;
    public OsDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(OrdemServico os) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into ordem_servico(id_cliente,id_aparelho,obs) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1,os.getCliente().getId());
            stm.setInt(2,os.getAparelho().getId());
            stm.setString(3,os.getObservacao());
            //stm.setDate(4,os.setDataEntrada()); //fazer insert com data_entrada

            stm.executeUpdate();
            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next())
            {
                os.setId(rs.getInt(1));
            }
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into ordem_servico_servico(id_ordem_servico,id_servico) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1,os.getId());
            stm.setInt(2,os.getServicos().get(0).getId());
            stm.executeUpdate();

            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }


    }

    @Override
    public void deletar(OrdemServico os) throws ErroDao {
        deletar(os.getId());

    }

    @Override
    public void deletar(int id) throws ErroDao {

    }

    @Override
    public void editar(OrdemServico os) throws ErroDao {

    }

    @Override
    public OrdemServico buscar(int id, Cliente cliente) throws ErroDao {
        return null;
    }

    @Override
    public Set<OrdemServico> buscar() throws ErroDao {
        return null;
    }

    @Override
    public void sair() throws ErroDao {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}
