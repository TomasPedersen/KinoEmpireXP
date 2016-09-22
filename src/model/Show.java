package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Show {

    private Film film;
    private LocalDate date;
    private int time;
    private int theater;
    private ArrayList<Seat> lilleSalSeatList; // amountOfSeats smallest theater = 240
    private ArrayList<Seat> storSalSeatList; // amountOfSeats smallest theater = 400


    public Show(Film film, LocalDate date, int time, int theater) {
        this.film = film;
        this.date = date;
        this.time = time;
        this.theater = theater;
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

    public int getTheater() {
        return theater;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
