package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMariaDB {

    private static final String URL = "jdbc:mariadb://localhost:3306/proyectoprogramacion";

    private static final String USER = "root";              // USUARIO DE MARIADB,
    private static final String PASS = "";     // PASSWORD DE MARIADB

    public static Connection getConexion() throws SQLException {
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException e) {

            throw new SQLException("Driver no encontrado", e);
        }
    }
}