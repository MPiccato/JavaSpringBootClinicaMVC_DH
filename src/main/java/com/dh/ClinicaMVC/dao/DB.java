package com.dh.ClinicaMVC.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class DB {

    //declaro la constante que trae el driver del gestor de base de datos

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:./dc";

    private static final String USER = "sa";
    private static final String PASSWORD = "sa";


    // Método para la conexión a la base de datos
    public static Connection getConnection() throws Exception  {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //Método para creación de las tablas
    public static void createTables() {
        Connection connection = null;

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
