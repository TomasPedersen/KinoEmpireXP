package controller;

import model.DBHelper;
import model.Film;
import model.Seat;
import model.Show;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reservation {

    public void createShow(Film film, LocalDate date) {
        //        Show show = dbHelper.selectFromMovies(date);


    }



// remember to turn reserved seats red 'Images/seat%20(red).png'

    public ArrayList<Seat> seatArrangementLilleSal(Show show) {

        DBHelper dbHelper = new DBHelper();
        ArrayList<Seat> seats = show.getLilleSalSeatList();

/*SELECT * FROM LOG WHERE DATA = SELECTEDDATE && WHERE SEAT=i*/

        for (int i = 0; i < 240; i++) {
/*            if(NOW WE CHECK IF a seat is available) {
                Seat seat = new Seat(true); // is reserved true
            } else {
                Seat seat = new Seat(false);
            }*/
        }
        return seats;
    }


    public ArrayList<Seat> seatArrangementStoreSal(Film film, LocalDate date) {

// SAME AS ABOVE EXCEPT i < 400 in for loop
        return null;
    }







}
