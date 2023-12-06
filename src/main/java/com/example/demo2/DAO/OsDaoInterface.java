package com.example.demo2.DAO;


import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Modelo.Servico;

import java.util.List;
import java.util.Set;

public interface OsDaoInterface {
    public void inserir(OrdemServico os) throws ErroDao;
    public void deletar(OrdemServico os) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(OrdemServico os) throws ErroDao;
    public OrdemServico buscar(int id, Cliente cliente) throws ErroDao;
    public Set<OrdemServico> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
