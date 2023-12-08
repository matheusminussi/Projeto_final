package com.example.demo2.DAO;



import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Modelo.Servico;

import java.sql.*;
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
                    ("insert into ordem_servico(id_cliente,id_aparelho,obs,data_entrada) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1,os.getCliente().getId());
            stm.setInt(2,os.getAparelho().getId());
            stm.setString(3,os.getObservacao());
            stm.setTimestamp(4, Timestamp.valueOf(os.getDataEntrada()));
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
            for(int i=0;i<os.getServicos().size();i++){
                System.out.println("AQUIIIIIII"+os.getServicos().get(i).getId());
                stm.setInt(2,os.getServicos().get(i).getId());

                stm.executeUpdate();
            }

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
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from ordem_servico_servico where id_ordem_servico=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from ordem_servico where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

    }

    @Override
    public void editar(OrdemServico os) throws ErroDao {

    }

    @Override
    public OrdemServico buscar(int id) throws ErroDao {
        return null;
    }

    @Override
    public Set<OrdemServico> buscar() throws ErroDao {
        try {
            Set<OrdemServico> ordemServicos=new HashSet();
            PreparedStatement stm=con.prepareStatement
                    ("select * from ordem_servico");
            ResultSet rs= stm.executeQuery();
            ClienteDaoInterface clienteDao = new ClienteDaoClasse();
            AparelhoDaoInterface aparelhoDao = new AparelhoDaoClasse();
            while (rs.next()){
                OrdemServico os=new OrdemServico();
                os.setId(rs.getInt("id"));
                os.setCliente(clienteDao.buscar(rs.getInt("id_cliente")));
                os.setAparelho(aparelhoDao.buscar(rs.getInt("id_aparelho")));
                os.setObservacao(rs.getString("obs"));
                os.setDataEntrada(rs.getTimestamp("data_entrada"));
                ordemServicos.add(os);
            }
            clienteDao.sair();
            aparelhoDao.sair();
            return ordemServicos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
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
