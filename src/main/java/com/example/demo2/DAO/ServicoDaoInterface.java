package com.example.demo2.DAO;

import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Servico;

import java.util.Set;

public interface ServicoDaoInterface {
    public void inserir(Servico s) throws ErroDao;
    public void deletar(Servico s) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Servico s) throws ErroDao;
    public Servico buscar(int id, String nome) throws ErroDao;
    public Servico buscar(String nome) throws ErroDao;
    public Set<Servico> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
