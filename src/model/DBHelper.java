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


    public void updateMovies(String title, String column, Object newCell) {
        try {
            if(newCell instanceof String){
                String newString = (String) newCell;
                sqlString = "UPDATE Movies SET '" + column + "' = '" + newString + "' WHERE Title = '" + title + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Movies SET '" + column + "' = '" + newInt + "' WHERE Title = '" + title + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateShows(int showId, String column, Object newCell){
        try {
            if(newCell instanceof String){
                String newString = (String) newCell;
                sqlString = "UPDATE Shows SET '" + column + "' = '" + newString + "' WHERE Title = '" + showId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Shows SET '" + column + "' = '" + newInt + "' WHERE Title = '" + showId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }
           }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateCustomers(String email, String column, String newCell){
        try {
            sqlString = "UPDATE Customers SET '" + column + "' = '" + newCell + "' WHERE Title = '" + email + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateSales(int SalesId, String column, Object newCell){
        try {
            if(newCell instanceof String){
                String newString = (String) newCell;
                sqlString = "UPDATE Log SET '" + column + "' = '" + newString + "' WHERE Title = '" + SalesId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Log SET '" + column + "' = '" + newInt + "' WHERE Title = '" + SalesId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }
        }catch(Exception e) {
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
                    + "','" + movie.getPrice()
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
            sqlString = "INSERT INTO Sales VALUES '"
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