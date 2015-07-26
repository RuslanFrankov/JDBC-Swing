package com.catalog.servcie;

import com.catalog.model.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 14.07.2015.
 */
public class CountryService {

    private static final String INSERT_COUNTRY = "INSERT INTO country (code, name) VALUES ('%s', '%s')";
    private static final String SELECT_COUNTRY = "SELECT * FROM country";


    public boolean insert(Country country) throws SQLException {
        Connection connection = Connections.getConnection();
        Statement statement = null;


        try {
            statement = connection.createStatement();
            String insertQuery = String.format(INSERT_COUNTRY, country.getCode(), country.getName());
            System.out.println(insertQuery);
            statement.execute(insertQuery);
            return true;
        } catch (SQLException e) {
            System.out.println("Insert failed for country " + country);
            e.printStackTrace();
            return false;
        }
        finally {
            Connections.closeStatementConnection(statement, connection);
        }
    }

    public List <Country> select () {
        Connection connection = Connections.getConnection();
        Statement statement = null;
        ResultSet resultSet;
        List <Country> countryList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            String selectQuery = new String(SELECT_COUNTRY);
            resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String code = resultSet.getString("Code");
                String name = resultSet.getString("Name");
                System.out.println(code + ", " + name);
                Country newCountry = new Country(code, name);
                countryList.add(newCountry);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Select failed for all countries ");
            e.printStackTrace();

        }
        finally {
            try {
                if (statement!=null)
                connection.close();
            } catch (SQLException ae){
                ae.printStackTrace();
            }
            Connections.closeStatementConnection(statement, connection);
        }
        return countryList;
    }

    public List <Country> findAll(){
        List <Country> countryList = new ArrayList<>();
        //логика чтения name, country из базы
        return countryList;
    }
}
