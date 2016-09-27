package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Util {

    public static java.sql.Date convertLocalDateToSQLDate(LocalDate localDate){
        //Converting LocalDate to java.sql.Date: http://stackoverflow.com/questions/29750861/convert-between-localdate-and-sql-date
        return java.sql.Date.valueOf(localDate);
    }

    public static LocalDate convertSQLDateToLocalDate(java.sql.Date SQLDate){
        return SQLDate.toLocalDate();
    }

    /**
     *
     * @param resultSet
     * @return
     */
    public static ArrayList<Object> readResultsetToArrayList(ResultSet resultSet) {

        ArrayList<Object> listToReturn = new ArrayList<>();

        try {
            while (resultSet.next()) {
                listToReturn.add(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listToReturn;
    }


}
