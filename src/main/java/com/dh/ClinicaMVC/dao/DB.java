package com.dh.ClinicaMVC.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class DB {

    //declaro la constante que trae el driver del gestor de base de datos

    private static final String DRIVER = "org.h2.DriverR";
    private static final String URL = "jdbc:h2:./dc";

    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    private static final String SQL_DROP_CREATE_ADDRESSES = "DROP TABLE IF EXISTS" +
            "ADDRESSES; CREATE TABLE ADDRESSES" +
            "(" + "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "STREET VARCHAR(100) NOT NULL," +
            "STREET_NUMBER INT NOT NULL," +
            "LOCATION VARCHAR(100) NOT NULL," +
            "PROVINCE VARCHAR(100)" +
            ")";
    private static final String SQL_DROP_CREATE_PATIENT = "DROP TABLE IF EXISTS" +
            "PATIENT; CREATE TABLE PATIENT " + "(" +
            "ID INT AUTO_INCREMENT PROMARY KEY," +
            "NAME VARCHAR(100) NOT NULL," +
            "LAST_NAME VARCHAR(100) NOT NULL," +
            "CARD_IDENTITY INT NOT NULL," +
            "ADMISSION_OF_DATE DATE NOT NULL," +
            "ADDRESS_ID VARCHAR(100) NOT NULL" + ")";

    private static final String SQL_DROP_CREAT_DENTIST = "DROP TABLE IF EXISTS" +
            "DENTIST; CREATE TABLE DENTIST " + "(" +
            "ID INT AUTO_INCREMENT PROMARY KEY," +
            "REGISTRATION INT NOT NULL," +
            "NAME VARCHAR(100) NOT NULL," +
            "LAST_NAME VARCHAR(100 NOT NULL," + ")";


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

            statement.execute(SQL_DROP_CREATE_ADDRESSES);
            statement.execute(SQL_DROP_CREATE_PATIENT);
            statement.execute(SQL_DROP_CREAT_DENTIST);

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
