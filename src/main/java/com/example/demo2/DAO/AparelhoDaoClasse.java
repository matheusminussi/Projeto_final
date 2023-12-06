package com.example.demo2.DAO;

import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AparelhoDaoClasse implements AparelhoDaoInterface{
    private Connection con;
    public AparelhoDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Aparelho a) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into aparelho(nome,modelo,marca,numero_serie) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,a.getNome());
            stm.setString(2,a.getModelo());
            stm.setString(3,a.getMarca());
            stm.setString(4,a.getNumero_serie());

            stm.executeUpdate();
            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next())
            {
                a.setId(rs.getInt(1));
            }
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Aparelho a) throws ErroDao {
        deletar(a.getId());

    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from aparelho where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Aparelho a) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("update aparelho set nome=?, modelo=?, marca=? numero_serie=? where id=?");
            stm.setString(1,a.getNome());
            stm.setString(2,a.getModelo());
            stm.setString(3,a.getMarca());
            stm.setString(4,a.getNumero_serie());
            stm.setInt(5,a.getId());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Aparelho buscar(int id, String nome) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from aparelho where id=? and nome=?");
            stm.setInt(1,id);
            stm.setString(2,nome);
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                Aparelho a=new Aparelho();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setModelo(rs.getString("modelo"));
                a.setMarca(rs.getString("marca"));
                a.setNumero_serie(rs.getString("numero_serie"));
                return a;
            }
            else
                return null;

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    public Aparelho buscar(String nome) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from aparelho where nome=?");
            stm.setString(1,nome);
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                Aparelho a=new Aparelho();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setModelo(rs.getString("modelo"));
                a.setMarca(rs.getString("marca"));
                a.setNumero_serie(rs.getString("numero_serie"));
                return a;
            }
            else
                return null;

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Aparelho> buscar() throws ErroDao {
        try {
            Set<Aparelho> aparelhos=new HashSet();
            PreparedStatement stm=con.prepareStatement
                    ("select * from aparelho");
            ResultSet rs= stm.executeQuery();
            while (rs.next()){
                Aparelho a=new Aparelho();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setModelo(rs.getString("modelo"));
                a.setMarca(rs.getString("marca"));
                a.setNumero_serie(rs.getString("numero_serie"));
                aparelhos.add(a);
            }
            return aparelhos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }    }

    @Override
    public void sair() throws ErroDao {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}
