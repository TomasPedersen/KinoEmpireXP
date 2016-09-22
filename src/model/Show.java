package model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class Show {

    private Film film;
    private LocalDate date;
    private ArrayList<Seat> lilleSalSeatList; // amountOfSeats smallest theater = 240
    private ArrayList<Seat> storSalSeatList; // amountOfSeats smallest theater = 400

    public Show(Film film, LocalDate date) {
        this.film = film;
        this.date = date;
        ArrayList<Seat> lilleSalSeatList = new ArrayList<Seat>();
        ArrayList<Seat> storSalSeatList = new ArrayList<Seat>();
    }

}
