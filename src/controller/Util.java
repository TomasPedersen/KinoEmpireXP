package controller;

import java.time.LocalDate;
import java.util.ArrayList;


public class Util {

    public static java.sql.Date convertLocalDateToSQLDate(LocalDate localDate){
        //Converting LocalDate to java.sql.Date: http://stackoverflow.com/questions/29750861/convert-between-localdate-and-sql-date
        return java.sql.Date.valueOf(localDate);
    }

    public LocalDate convertSQLDateToLocalDate(java.sql.Date SQLDate){
        return SQLDate.toLocalDate();
    }

    public ArrayList<Object> readResultsetToArrayList() {

        /*ArrayList<Object>*/


    }


}
