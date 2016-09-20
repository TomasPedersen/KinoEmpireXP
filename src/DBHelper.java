import java.sql.*;

public class DBHelper {

    Statement statement;
    ResultSet resultSet;
    String sqlString;

    public static void connect(){
/*
Server: sql7.freemysqlhosting.net
Name: sql7136625
Username: sql7136625
Password: zvlNm6q1zG
Port number: 3306
 */
        try{
            String url = "jdbc:mysql://slq7.freesqlhosting.net:3306";

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, "sql736625", "zvlNm6q1zG");

            System.out.println(connection);
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
