package com.example.demo2.Modelo;

import java.util.Objects;

public class Aparelho {
    int id;
    String nome,modelo,marca,numero_serie;

    public Aparelho() {
    }

    public Aparelho(String nome, String modelo, String marca, String numero_serie) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.numero_serie = numero_serie;
    }

    public Aparelho(int id, String nome, String modelo, String marca, String numero_serie) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.numero_serie = numero_serie;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aparelho aparelho = (Aparelho) o;
        return id == aparelho.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aparelho{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", numero_serie='" + numero_serie + '\'' +
                '}';
    }
}
