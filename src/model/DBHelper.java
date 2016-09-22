package model;

import java.sql.*;
import java.sql.DriverManager;

public class DBHelper {

    Statement statement;
    ResultSet resultSet;
    String sqlString;
    Connection connection;

    public void connect(){
/*
Server: db4free.net
DatabaseName: kinoempire
Username: kino123
Password: kinoempire
Port number: 3306
 */
        try{
            String url = "jdbc:mysql://db4free.net:3306/kinoempire?useSSL=false";

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(url, "kino123", "kinoempire");

            System.out.println(connection);
            connection.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public void updateMoviesInt(String title, String column, int number) {
        try {
            sqlString = "UPDATE Movies SET '" + column + "' = '" + number + "' WHERE Title = '" + title + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateShowsInt(int showId, String column, int number){
        try {
            sqlString = "UPDATE Shows SET '" + column + "' = '" + number + "' WHERE Title = '" + showId + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateCustomersInt(String email, String column, int number){
        try {
            sqlString = "UPDATE Customers SET '" + column + "' = '" + number + "' WHERE Title = '" + email + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateLogInt(int SalesId, String column, int number){
        try {
            sqlString = "UPDATE Log SET '" + column + "' = '" + number + "' WHERE Title = '" + SalesId + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertMovie(Film movie) {
        try {
            sqlString = "INSERT INTO Movies VALUES '"
                    + movie.getDanishTitle()
                    + "','" + movie.getOriginalTitle()
                    + "','" + movie.getGenre()
                    + "','" + movie.getFilmLength()
                    + "','" + movie.getFilmDescription()
                    + "','" + movie.getPrice1()
                    + "','" + movie.getDirector()
                    + "','" + movie.getAgeRestriction()
                    + "','" + movie.getVersions() + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void insertShow(Show show){
        try {
            sqlString = "INSERT INTO Shows VALUES '"
                    + show.getFilm()
                    + "','" + show.getDate()
                    + "','" + show.getLilleSalSeatList()
                    + "','" + show.getStorSalSeatList() + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer){
        try {
            sqlString = "INSERT INTO Customers VALUES '"
                    + customer.getEmail()
                    + "','" + customer.getName()
                    + "','" + customer.getPhoneNumber()
                    + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertSale(Sale sale){
        try {
            sqlString = "INSERT INTO Customers VALUES '"
                    + sale.getShow()
                    + "','" + sale.getCustomer()
                    + "','" + sale.getSeatIndex()
                    + "','" + sale.getTimeOfSale()
                    + "','" + sale.getStatus()
                    + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void select() {

    }



    public void delete() {

    }

}