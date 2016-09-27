package model;

import controller.Util;

import java.sql.*;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;


public class DBHelper {

    Statement statement;
    ResultSet resultSet;
    String sqlString;
    Connection connection;
    Savepoint savepoint;

    public Connection connect() {
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
            savepoint = connection.setSavepoint();
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void updateMovies(String title, String column, Object newCell) {
        try {
            connection = connect();
            if (newCell instanceof String) {
                String newString = (String) newCell;
                sqlString = "UPDATE Movies SET '" + column + "' = '" + newString + "' WHERE Title = '" + title + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            } else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Movies SET '" + column + "' = '" + newInt + "' WHERE Title = '" + title + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateShows(int showId, String column, Object newCell) {
        try {
            connection = connect();
            if (newCell instanceof String) {
                String newString = (String) newCell;
                sqlString = "UPDATE Shows SET '" + column + "' = '" + newString + "' WHERE Title = '" + showId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            } else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Shows SET '" + column + "' = '" + newInt + "' WHERE Title = '" + showId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomers(String email, String column, String newCell) {
        try {
            connection = connect();
            sqlString = "UPDATE Customers SET '" + column + "' = '" + newCell + "' WHERE Title = '" + email + "'";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSales(int SalesId, String column, Object newCell) {
        try {
            connection = connect();
            if (newCell instanceof String) {
                String newString = (String) newCell;
                sqlString = "UPDATE Sales SET '" + column + "' = '" + newString + "' WHERE Title = '" + SalesId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            } else {
                int newInt = (int) newCell;
                sqlString = "UPDATE Sales SET '" + column + "' = '" + newInt + "' WHERE Title = '" + SalesId + "'";
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            }
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void insertMovie(Movie movie) {
        try {
            connection = connect();
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
                    + "','" + movie.getVersions() + "');";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertShow(Show show) {
        try {
            connection = connect();
            sqlString = "INSERT INTO Shows VALUES (default, '"
                    + show.getMovie().getDanishTitle()
                    + "','" + show.getDate()
                    + "','" + show.getTime()
                    + "','" + show.getTheater() + "');";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer) {
        try {
            connection = connect();
            sqlString = "INSERT INTO Customers VALUES ('"
                    + customer.getEmail()
                    + "','" + customer.getName()
                    + "','" + customer.getPhoneNumber()
                    + "','" + customer.getPassword()
                    + "');";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertSale(Sale sale) {
        try {
            connection = connect();
            sqlString = "INSERT INTO Sales VALUES ( default, '"
                    + findShowId(sale.getShow().getMovie().getDanishTitle(), sale.getShow().getDate(),
                    sale.getShow().getTime(), sale.getShow().getTheater())
                    + "','" + sale.getCustomer().getEmail()
                    + "','" + sale.getSeatIndex()
                    + "','" + sale.getTimeOfSale()
                    + "','" + sale.getStatus()
                    + "');";
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectFromMovies(String title, String column) {
        try {
            connection = connect();
            statement = connection.createStatement();
            if (title == null) {
                sqlString = "select '" + column + "' from Movies;";
                resultSet = statement.executeQuery(sqlString);

            } else {
                sqlString = "select '" + column + "' from Movies where Danish_Title = '" + title+ "' ;";
                resultSet = statement.executeQuery(sqlString);
            }
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public ArrayList<Movie> selectAllDistinctMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            connection = connect();
            statement = connection.createStatement();

            sqlString = "SELECT DISTINCT * FROM Movies;";
            resultSet = statement.executeQuery(sqlString);


            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getString(5), Util.convertSQLDateToLocalDate(resultSet.getDate(6)),
                        resultSet.getDouble(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10));
            }

            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ResultSet selectFromShows(int show_id, String column) {
        try {
            connection = connect();
            statement = connection.createStatement();
            sqlString = "select '" + column + "'from Shows where show_id = '" + show_id + "';";
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;

    }

    public ResultSet selectColumnFromShows(String column) {
        try {
            connection = connect();
            statement = connection.createStatement();
            sqlString = "select '" + column + "' from Shows;";
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectFromCustomers(String email, String column) {
        try {
            connection = connect();
            statement = connection.createStatement();
            if (email == null) {
                sqlString = "select '" + column + "' from Customers;";
                resultSet = statement.executeQuery(sqlString);
            } else {
                sqlString = "select '" + column + "' from Customers where Email = '" + email+ "'; ";
                resultSet = statement.executeQuery(sqlString);
            }
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectFromSales(int sales_id, String column) {
        try {
            connection = connect();
            statement = connection.createStatement();
            sqlString = "select '" + column + "' from Sales where sales_id = '" + sales_id+ "'; ";
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectColumnFromSales(String column) {
        try {
            connection = connect();
            statement = connection.createStatement();
            sqlString = "select '" + column + "' from Sales;";
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int findShowId(String title, LocalDate localDate, int time, int theater){
        Date date = Date.valueOf(localDate);
        int result = 0;
        resultSet = null;
        try {
            sqlString = "select show_id from Shows where Danish_Title = '" + title
                    + "' and Date = '" + date + "' and Time = '" + time + "' and Theater = '" +theater+ "'; ";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            resultSet.next();
            result = resultSet.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void delete(Object primaryKey, String table) {
        try {
            connection = connect();
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

    public ArrayList<Movie> moviesFromDatePicked(LocalDate lD) throws SQLException {
        ArrayList<Movie> dateMovies = new ArrayList<>();
        Date date = Date.valueOf(lD);
        try {
            connection = connect();
            sqlString = "SELECT DISTINCT " + "Movies.Danish_Title, Movies.Original_Title, Movies.Genre, Movies.Filmlength, Movies.Filmdescription, " +
                    "Movies.Release_Date, " + "Movies.Director, Movies.Age_Restriction, Movies.Versions" +
                    " FROM " + " Movies " +" INNER JOIN " + " Shows" + " ON "+" Movies.Danish_Title = Shows.Danish_Title "+" WHERE Date = " + date +"";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getString(5)
                        , null, resultSet.getDouble(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(9));
                CharSequence releaseDate = resultSet.getString(6);
                movie.setReleaseDate(LocalDate.parse(releaseDate));
                dateMovies.add(movie);
            }
            connection.close();
        } catch (SQLException e) {
            connection.rollback(savepoint);
        }
        return dateMovies;
    }

    public ArrayList<String> titlesFromDatePicked(LocalDate lD) throws SQLException {
        ArrayList<String> titles = new ArrayList<>();
        Date date = Date.valueOf(lD);
        try {
            connection = connect();
            sqlString = "select distinct Danish_Title from Shows where Date = '" + date + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (resultSet.next()) {
                    titles.add(resultSet.getString(1));
                }
            }
            connection.close();
        } catch (SQLException e) {
            connection.rollback(savepoint);
        }
        return titles;
    }

    public ArrayList<Movie> fromTitlesToMovies(ArrayList<String> titles) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        try {
            connection = connect();
            for (String s : titles) {
                sqlString = "select Danish_Title, Original_Title, Genre, FilmLength, FilmDescription, Release_Date, Price, Director, Age_Restriction, Versions from Movies where Danish_Title = '" +s+ "';";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sqlString);
                connection.commit();
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No data");
                } else {
                    while (resultSet.next()) {
                        movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5)
                                , null, resultSet.getInt(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(9));
                        CharSequence releaseDate = resultSet.getString(6);
                        movie.setReleaseDate(LocalDate.parse(releaseDate));
                    }
                    movies.add(movie);
                }
            }
            connection.close();
        } catch (SQLException e) {
            connection.rollback(savepoint);
        }
        return movies;
    }

    public Seat[] seatFromDate(int showId) throws SQLException {
        Seat[] seats = new Seat[240];
        ArrayList<Integer> reserved = new ArrayList<>();
        try{
            connection = connect();
            connection.setSavepoint();
            statement = connection.createStatement();
            sqlString = "SELECT " +"SeatIndex"+" FROM "+ "Sales" +" Where "+ "`Show` = '"+showId+"';";
            resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                reserved.add(resultSet.getInt(1));
            }
            connection.close();
        }catch (SQLException e){
            connection.rollback(savepoint);
        }
        for (int i = 0; i < 239; i++){
            seats[i] = new Seat(false);
        }
        for (int a: reserved) {
                    seats[a].setReserved(true);
        }
        return seats;
    }

}