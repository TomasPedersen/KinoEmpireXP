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
        try {
            connection = connect();
            sqlString = "select show_id from Shows where Danish_Title = '" + title
                    + "' and Date = '" + date + "' and Time = '" + time + "' and Theater = '" +theater+ "'; ";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlString);
            connection.commit();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No Id");
            }else {
                resultSet.next();
                result = resultSet.getInt(1);
            }
            connection.close();
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


    public ArrayList<Show> showsFromDatePicked(LocalDate lD) throws SQLException{
        ArrayList<Show> dateShows = new ArrayList<>();
        Date date = Date.valueOf(lD);
        Movie movie = null;
        ResultSet resultShows;
        try {
            connection = connect();
            sqlString = "SELECT * from Shows where Date = '" +date+ "';";
            statement = connection.createStatement();
            resultShows = statement.executeQuery(sqlString);
            connection.commit();
            if (!resultShows.isBeforeFirst()) {
                System.out.println("No shows");
            }else{
                while (resultShows.next()) {
                    for(Movie m: fromTitlesToMovies(titlesFromDatePicked(lD))){
                        if(m != null) {
                            if (m.getDanishTitle().equals(resultShows.getString(2))) {
                                movie = m;
                            }
                        }else{
                            System.out.println("null in movies");
                        }
                    }
                    Show show = new Show(movie, null, resultShows.getInt(4), resultShows.getInt(5));
                    CharSequence Date = resultShows.getString(3);
                    show.setDate(LocalDate.parse(Date));
                    dateShows.add(show);
                }
            }
            connection.close();
        } catch (SQLException e) {
            connection.rollback(savepoint);
        }
        return dateShows;
    }

    public ArrayList<String> titlesFromDatePicked(LocalDate lD) throws SQLException {
        ArrayList<String> titles = new ArrayList<>();
        Date date = Date.valueOf(lD);
        ResultSet resultTitles;
        try {
        //  internal method, no need to open connection
            sqlString = "select distinct Danish_Title from Shows where Date = '" + date + "';";
            statement = connection.createStatement();
            resultTitles = statement.executeQuery(sqlString);
            connection.commit();
            if (!resultTitles.isBeforeFirst()) {
                System.out.println("No titles ");
            } else {
                while (resultTitles.next()) {
                    titles.add(resultTitles.getString(1));
                }
            }
        // internal method, no need to close connection
        } catch (SQLException e) {
            connection.rollback(savepoint);
        }
        return titles;
    }

    public ArrayList<Movie> fromTitlesToMovies(ArrayList<String> titles) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        ResultSet resultMovies;
        try {
//            connection = connect();
            for (String s : titles) {
                sqlString = "select Danish_Title, Original_Title, Genre, FilmLength, FilmDescription, Release_Date, Price, Director, Age_Restriction, Versions, Poster from Movies where Danish_Title = '" +s+ "';";
                statement = connection.createStatement();
                resultMovies = statement.executeQuery(sqlString);
                connection.commit();

                    while (resultMovies.next()) {
                        movie = new Movie(resultMovies.getString(1), resultMovies.getString(2), resultMovies.getString(3), resultMovies.getInt(4), resultMovies.getString(5)
                                , null, resultMovies.getInt(7), resultMovies.getString(8), resultMovies.getInt(9), resultMovies.getString(9), resultMovies.getString(11));
                        CharSequence releaseDate = resultMovies.getString(6);
                        movie.setReleaseDate(LocalDate.parse(releaseDate));
                    }
                    movies.add(movie);
            }
//            connection.close();
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
        for (int i = 0; i < 240; i++){
            seats[i] = new Seat(false);
        }
        for (int a: reserved) {
                    seats[a].setReserved(true);
        }
        return seats;
    }

}