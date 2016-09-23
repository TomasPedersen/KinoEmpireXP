package controller;

import model.DBHelper;
import model.Movie;
import model.Show;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovieProgram {


    public void createProgramForTheNextThreeMonths() {

        DBHelper db = new DBHelper();
        Movie movie1 = new Movie("Haha, you're dead!", null, "Comedy", 123, "For the whole family.", null, 80, "Mr. Film Director", 0, null);
        Show show1 = new Show(movie1, null, 1000, 0);
        Show show2 = new Show(movie1, null, 1300, 0);
        Show show3 = new Show(movie1, null, 1600, 0);
        Show show4 = new Show(movie1, null, 2000, 0);

        Movie movie2 = new Movie("Gotta save the world.", null, "Action", 123, "A retired man is asked by the president to save the world. And he does.", null, 80, "Mr. Film Director", 0, null);
        Show show5 = new Show(movie2, null, 1000, 0);
        Show show6 = new Show(movie2, null, 1300, 0);
        Show show7 = new Show(movie2, null, 1600, 0);
        Show show8 = new Show(movie2, null, 2000, 0);

        Movie movie3 = new Movie("Ghost Nuns 2", null, "Horror", 123, "Diapers will be provided.", null, 80, "Mr. Film Director", 16, null);
        Show show9 = new Show(movie3, null, 1900, 0);
        Show show11 = new Show(movie3, null, 2200, 0);
        Show show12 = new Show(movie3, null, 2300, 0);


        LocalDate date = LocalDate.now();
        LocalDate threeMonthsForward = date.plusMonths(3);

        while (date != threeMonthsForward){



            db.insertShow(show1);

            date.plusDays(1);

            show1.setDate(date);

        }

    }





}
