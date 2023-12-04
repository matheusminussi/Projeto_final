package com.example.demo2.DAO;

import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.Funcionario;

import java.util.Set;

public interface ClienteDaoInterface {
    public void inserir(Cliente c) throws ErroDao;
    public void deletar(Cliente c) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Cliente c) throws ErroDao;
    public Cliente buscar(int id, String nome) throws ErroDao;
    public Set<Cliente> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
