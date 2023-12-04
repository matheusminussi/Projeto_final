package com.example.demo2.DAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection pegaConexao() throws ErroDao{
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("RecursoPostgres");
            return ds.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
