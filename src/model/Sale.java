package model;

import java.time.LocalDateTime;

public class Sale {

    private Show show;
    private Customer customer;
    private int seatIndex;
    private LocalDateTime timeOfSale;
    private String status;   // sold or reserved

    public Sale(Show show, Customer customer, int seatIndex, LocalDateTime timeOfSale, String status) {
        this.show = show;
        this.customer = customer;
        this.seatIndex = seatIndex;
        this.timeOfSale = timeOfSale;
        this.status = status;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getSeatIndex() {
        return seatIndex;
    }

    public void setSeatIndex(int seatIndex) {
        this.seatIndex = seatIndex;
    }

    public LocalDateTime getTimeOfSale() {
        return timeOfSale;
    }

    public void setTimeOfSale(LocalDateTime timeOfSale) {
        this.timeOfSale = timeOfSale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
