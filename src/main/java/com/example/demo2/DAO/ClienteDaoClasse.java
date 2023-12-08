package com.example.demo2.DAO;

import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.Funcionario;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ClienteDaoClasse implements ClienteDaoInterface{
    private Connection con;
    public ClienteDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Cliente c) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into cliente(nome,telefone,endereco) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,c.getNome());
            stm.setString(2,c.getTelefone());
            stm.setString(3,c.getEndereco());
            stm.executeUpdate();
            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next())
            {
                c.setId(rs.getInt(1));
            }
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Cliente c) throws ErroDao {
        deletar(c.getId());

    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from cliente where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Cliente c) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("update cliente set nome=?, telefone=?, endereco=? where id=?");
            stm.setString(1,c.getNome());
            stm.setString(2,c.getTelefone());
            stm.setString(3,c.getEndereco());
            stm.setInt(4,c.getId());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Cliente buscar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from cliente where id=?");
            stm.setInt(1,id);
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                Cliente c=new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                return c;
            }
            else
                return null;

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
    public Cliente buscar(String nome) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from cliente where nome=?");
            stm.setString(1,nome);
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                Cliente c=new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                return c;
            }
            else
                return null;

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Cliente> buscar() throws ErroDao {
        try {
            Set<Cliente> clientes=new HashSet();
            PreparedStatement stm=con.prepareStatement
                    ("select * from cliente");
            ResultSet rs= stm.executeQuery();
            while (rs.next()){
                Cliente c=new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                clientes.add(c);
            }
            return clientes;
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
