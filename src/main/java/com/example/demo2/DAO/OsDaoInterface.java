package com.example.demo2.DAO;


import com.example.demo2.Modelo.Aparelho;
import com.example.demo2.Modelo.Cliente;
import com.example.demo2.Modelo.OrdemServico;
import com.example.demo2.Modelo.Servico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface OsDaoInterface {
    public void inserir(OrdemServico os) throws ErroDao;
    public void deletar(OrdemServico os) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(OrdemServico os) throws ErroDao;
    public OrdemServico buscar(int id) throws ErroDao;
    public Set<OrdemServico> buscarAbertas()throws ErroDao;
    public Set<OrdemServico> buscarFinalizadas()throws ErroDao;
    public Set<OrdemServico> buscarCliente(Cliente c)throws ErroDao;
    public Set<OrdemServico> buscarAparelho(Aparelho a)throws ErroDao;
    public List<Integer> buscarIdServicos(int idDaOs) throws ErroDao;
    public List<Servico> buscarServicos(List<Integer> idServicos) throws ErroDao;
    public void finaliar(OrdemServico os, LocalDateTime dataHoraAtual) throws ErroDao;
    public void sair() throws ErroDao;
}
