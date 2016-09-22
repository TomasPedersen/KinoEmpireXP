package model;

import java.sql.*;
import java.sql.DriverManager;

public class DBHelper {

    Statement statement;
    ResultSet resultSet;
    String sqlString;

    public static void connect(){
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

            Connection connection = DriverManager.getConnection(url, "kino123", "kinoempire");

            System.out.println(connection);
            connection.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void select() {

    }

    public void insert() {

    }

    public void delete() {

    }

}
