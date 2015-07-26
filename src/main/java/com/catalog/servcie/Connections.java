package com.catalog.servcie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dmitry on 17.07.2015.
 */
public final class Connections {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Office_equipment";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "12345";
    private Connections() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Not found " + JDBC_DRIVER, e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new IllegalStateException("No database connection at " + DB_URL, e);
        }
        return connection;

    }
    public static void closeStatementConnection (Statement statement, Connection connection){
        try{
            if(statement!=null)
                statement.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
        try{
            if(connection!=null)
                connection.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
