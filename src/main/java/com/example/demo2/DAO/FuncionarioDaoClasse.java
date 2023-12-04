package com.example.demo2.DAO;

import com.example.demo2.Modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioDaoClasse implements FuncionarioDaoInterface{
    private Connection con;
    public FuncionarioDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Funcionario f) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into funcionario(nome,login,senha) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,f.getNome());
            stm.setString(2,f.getLogin());
            stm.setString(3,f.getSenha());
            stm.executeUpdate();
            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next())
            {
                f.setId(rs.getInt(1));
            }
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Funcionario f) throws ErroDao {
        deletar(f.getId());
    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from funcionario where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Funcionario f) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("update funcionario set nome=?, login=?, senha=? where id=?");
            stm.setString(1,f.getNome());
            stm.setString(2,f.getLogin());
            stm.setString(3,f.getSenha());
            stm.setInt(4,f.getId());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Funcionario buscar(String login, String senha) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from funcionario where login=? and senha=?");
            stm.setString(1,login);
            stm.setString(2,senha);
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                Funcionario f=new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                return f;
            }
            else
                return null;

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Funcionario> buscar() throws ErroDao {
        try {
            Set<Funcionario> funcionarios=new HashSet();
            PreparedStatement stm=con.prepareStatement
                    ("select * from funcionario");
            ResultSet rs= stm.executeQuery();
            while (rs.next()){
                Funcionario f=new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }
            return funcionarios;
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
