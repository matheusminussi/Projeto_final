package com.example.demo2.DAO;

public class ErroDao extends Exception{
    public ErroDao() {
        super("Erro DAO.");
    }

    public ErroDao(String message) {
        super("Erro DAO: "+message);
    }

    public ErroDao(Exception e) {
        super("Erro DAO: "+e);
    }
}
