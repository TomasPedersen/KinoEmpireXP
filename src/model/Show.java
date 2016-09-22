package model;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public ArrayList<Seat> getLilleSalSeatList() {
        return lilleSalSeatList;
    }

    public void setLilleSalSeatList(ArrayList<Seat> lilleSalSeatList) {
        this.lilleSalSeatList = lilleSalSeatList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Seat> getStorSalSeatList() {
        return storSalSeatList;
    }

    public void setStorSalSeatList(ArrayList<Seat> storSalSeatList) {
        this.storSalSeatList = storSalSeatList;
    }
}
