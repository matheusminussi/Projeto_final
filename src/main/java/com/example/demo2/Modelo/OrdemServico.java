package com.example.demo2.Modelo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrdemServico {
    int id;
    Cliente cliente;
    Aparelho aparelho;
    String observacao;
    List<Servico> servicos = new ArrayList<>();
    LocalDateTime dataEntrada;
    LocalDateTime dataSaida;
    double valorTotal;

    public OrdemServico() {
    }

    public OrdemServico(Cliente cliente, Aparelho aparelho, String observacao, LocalDateTime dataEntrada) {
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
    }

    public OrdemServico(Cliente cliente, Aparelho aparelho, String observacao, LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public LocalDateTime getDataEntrada(){
        return dataEntrada;
    }
    public String getDataEntradaFormatada(){
       return dataEntrada.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm"));
    }
    public String getDataSaidaFormatada(){
        return dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm"));
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada.toLocalDateTime();
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida.toLocalDateTime();
    }

    public double getValorTotal() {
        double total=0;
        for(Servico servico: servicos){
         total+=servico.getValor();
        }
        return total;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
