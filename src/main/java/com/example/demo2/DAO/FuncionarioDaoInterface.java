package com.example.demo2.DAO;

import com.example.demo2.Modelo.Funcionario;

import java.util.Set;

public interface FuncionarioDaoInterface {
    public void inserir(Funcionario f) throws ErroDao;
    public void deletar(Funcionario f) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Funcionario f) throws ErroDao;
    public Funcionario buscar(String login,String senha) throws ErroDao;
    public Set<Funcionario> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
