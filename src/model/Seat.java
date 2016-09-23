package model;

public class Seat {

    private boolean isReserved;

    public Seat(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public Seat() {}

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
