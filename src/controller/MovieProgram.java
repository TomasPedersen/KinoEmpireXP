package controller;

import model.DBHelper;
import model.Movie;
import model.Show;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovieProgram {


    public static void createProgramForTheNextThreeMonths() {

        LocalDate date = LocalDate.now();
        DBHelper db = new DBHelper();

        Movie movie1 = new Movie("Haha, you're dead!", "Haha, you're dead!", "Comedy", 123, "For the whole family.", LocalDate.now(), 80, "Mr. Movie Director", 0, "Normal");
        Show show1 = new Show(movie1, date, 1000, 0);
        Show show2 = new Show(movie1, date, 1300, 0);
        Show show3 = new Show(movie1, date, 1600, 0);
        Show show4 = new Show(movie1, date, 2000, 0);

        Movie movie2 = new Movie("Gotta save the world.", "Gotta save the world.", "Action", 123, "A retired man is asked by the president to save the world. And he does.", LocalDate.now(), 80, "Mr. Movie Director", 0, "Normal");
        Show show5 = new Show(movie2, date, 1000, 0);
        Show show6 = new Show(movie2, date, 1300, 0);
        Show show7 = new Show(movie2, date, 1600, 0);
        Show show8 = new Show(movie2, date, 2000, 0);

        Movie movie3 = new Movie("Ghost Nuns 2", "Ghost Nuns 2", "Horror", 123, "Diapers will be provided.", LocalDate.now(), 80, "Mr. Movie Director", 16, "Normal");
        Show show9 = new Show(movie3, date, 1900, 0);
        Show show10 = new Show(movie3, date, 2200, 0);
        Show show11 = new Show(movie3, date, 2300, 0);



        LocalDate threeMonthsForward = date.plusMonths(3);

        //while (date != threeMonthsForward){




            db.insertShow(show1);
/*            db.insertShow(show2);
            db.insertShow(show3);
            db.insertShow(show4);
            db.insertShow(show5);
            db.insertShow(show6);
            db.insertShow(show7);
            db.insertShow(show8);
            db.insertShow(show9);
            db.insertShow(show10);
            db.insertShow(show11);*/

/*            date.plusDays(1);

            show1.setDate(date);
            show2.setDate(date);
            show3.setDate(date);
            show4.setDate(date);
            show5.setDate(date);
            show6.setDate(date);
            show7.setDate(date);
            show8.setDate(date);
            show9.setDate(date);
            show10.setDate(date);
            show11.setDate(date);*/

        //}

    }





}
