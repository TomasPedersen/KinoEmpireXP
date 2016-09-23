package model;

import java.sql.*;
import java.sql.DriverManager;
import java.time.LocalDate;

public class DBHelper {

    Statement statement;
    ResultSet resultSet;
    String sqlString;
    Connection connection;

    public void connect() {
/*
Server: db4free.net
DatabaseName: kinoempire
Username: kino123
Password: kinoempire
Port number: 3306
 */
        try {
            String url = "jdbc:mysql://db4free.net:3306/kinoempire?useSSL=false";

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(url, "kino123", "kinoempire");

            System.out.println(connection);
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateMovies(String title, String column, Object newCell) {
        try {
            if (newCell instanceof String) {
                String newString = (String) newCell;
                sqlString = "UPDATE Movies SET '" + column + "' = '" + newString + "' WHERE Title = '" + title + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
                connection.close();
            } else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Movies SET '" + column + "' = '" + newInt + "' WHERE Title = '" + title + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateShows(int showId, String column, Object newCell) {
        try {
            if (newCell instanceof String) {
                String newString = (String) newCell;
                sqlString = "UPDATE Shows SET '" + column + "' = '" + newString + "' WHERE Title = '" + showId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
                connection.close();
            } else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Shows SET '" + column + "' = '" + newInt + "' WHERE Title = '" + showId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomers(String email, String column, String newCell) {
        try {
            sqlString = "UPDATE Customers SET '" + column + "' = '" + newCell + "' WHERE Title = '" + email + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSales(int SalesId, String column, Object newCell) {
        try {
            if (newCell instanceof String) {
                String newString = (String) newCell;
                sqlString = "UPDATE Log SET '" + column + "' = '" + newString + "' WHERE Title = '" + SalesId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
                connection.close();
            } else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Log SET '" + column + "' = '" + newInt + "' WHERE Title = '" + SalesId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertMovie(Film movie) {
        try {
            sqlString = "INSERT INTO Movies VALUES ('"
                    + movie.getDanishTitle()
                    + "','" + movie.getOriginalTitle()
                    + "','" + movie.getGenre()
                    + "','" + movie.getFilmLength()
                    + "','" + movie.getFilmDescription()
                    + "','" + movie.getReleaseDate()
                    + "','" + movie.getPrice()
                    + "','" + movie.getDirector()
                    + "','" + movie.getAgeRestriction()
                    + "','" + movie.getVersions() + "')";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Kan ikke indsætte show, uden der er en tilsvarende film i Movies i DB
    public void insertShow(Show show) {
        try {
            sqlString = "INSERT INTO Shows VALUES (default, '"
                    + show.getFilm().getDanishTitle()
                    + "','" + show.getDate()
                    + "','" + show.getTime()
                    + "','" + show.getTheater() + "');";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer) {
        try {
            sqlString = "INSERT INTO Customers VALUES ('"
                    + customer.getEmail()
                    + "','" + customer.getName()
                    + "','" + customer.getPhoneNumber()
                    + "')";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertSale(Sale sale) {
        try {
            sqlString = "INSERT INTO Sales VALUES (default, '"
                    + findShowId(sale.getShow().getFilm().getDanishTitle(),
                        sale.getShow().getDate(), sale.getShow().getTime(), sale.getShow().getTheater())
                    + "','" + sale.getCustomer().getName()
                    + "','" + sale.getSeatIndex()
                    + "','" + sale.getTimeOfSale()
                    + "','" + sale.getStatus()
                    + "')";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectFromMovies(String title, String column) {
        try {
            statement = connection.createStatement();
            if (title.equals(null)) {
                sqlString = "select " + column + "from Movies";
                resultSet = statement.executeQuery(sqlString);
                connection.close();
            } else {
                sqlString = "select " + column + " from Movies where Title =" + title;
                resultSet = statement.executeQuery(sqlString);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectFromShows(int show_id, String column) {
        try {
            statement = connection.createStatement();
            sqlString = "select " + column + "from Shows where Show_id = " + show_id;
            resultSet = statement.executeQuery(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int findShowId(String title, LocalDate localDate, int time, int theater){
        int id = 0;
        Date date = Date.valueOf(localDate);
        try {
            statement = connection.createStatement();
            sqlString = "select show_id from Shows where [Danish Title] = '" + title
                    + "' and Date = '" + date + "' and Time = '" + time + "' and Theater = '" + theater + "'; ";
            resultSet = statement.executeQuery(sqlString);
            id = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public ResultSet selectColumnFromShows(String column) {
        try {
            statement = connection.createStatement();
            sqlString = "select" + column + "from Shows";
            resultSet = statement.executeQuery(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectFromCustomers(String email, String column) {
        try {
            statement = connection.createStatement();
            if (email.equals(null)) {
                sqlString = "select " + column + " from Customers";
                resultSet = statement.executeQuery(sqlString);
                connection.close();
            } else {
                sqlString = "select " + column + " from Customers where email = " + email;
                resultSet = statement.executeQuery(sqlString);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectFromSales(int sales_id, String column) {
        try {
            statement = connection.createStatement();
            sqlString = "select " + column + " from Sales where sales_id =" + sales_id;
            resultSet = statement.executeQuery(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectColumnFromSales(String column) {
        try {
            statement = connection.createStatement();
            sqlString = "select " + column + " from Sales";
            resultSet = statement.executeQuery(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void delete(Object primaryKey, String table) {
        try {
            sqlString = "delete from " + table + " where (SELECT `COLUMN_NAME`" +
                    "FROM `information_schema`.`COLUMNS`" +
                    "WHERE (`TABLE_NAME` = " + table +
                    " AND (`COLUMN_KEY` = 'PRI') = " + primaryKey;
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object resultSetToObject(ResultSet set){
        Object result = null;
        try {
            result = set.getObject(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}