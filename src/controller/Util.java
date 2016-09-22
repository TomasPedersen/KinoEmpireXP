package controller;

import java.time.LocalDate;


public class Util {

    public java.sql.Date convertLocalDateToSQLDate(LocalDate localDate){
        //Converting LocalDate to java.sql.Date: http://stackoverflow.com/questions/29750861/convert-between-localdate-and-sql-date
        return java.sql.Date.valueOf(localDate);
    }

    public LocalDate convertSQLDateToLocalDate(java.sql.Date SQLDate){
        return SQLDate.toLocalDate();
    }
}
