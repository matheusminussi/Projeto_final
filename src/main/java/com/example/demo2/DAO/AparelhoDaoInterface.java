package com.example.demo2.DAO;

import com.example.demo2.Modelo.Aparelho;

import java.util.Set;

public interface AparelhoDaoInterface {
    public void inserir(Aparelho a) throws ErroDao;
    public void deletar(Aparelho a) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Aparelho a) throws ErroDao;
    public Aparelho buscar(int id, String nome) throws ErroDao;
    public Set<Aparelho> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
