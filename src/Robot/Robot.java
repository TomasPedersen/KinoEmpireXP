package robot;

import model.Customer;
import model.DBHelper;
import model.Sale;
import model.Show;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Robot implements Runnable{


    /** This method creates a new thread that adds sales and either buys or reserves tickets
     * It takes random customers from the database and random shows and tries to purchase a seat */
    @Override
    public void run() {
        DBHelper db = new DBHelper();

        ArrayList<Show> shows = new ArrayList<>(); // todo get all shows from db
        ArrayList<Customer> customers = new ArrayList<>(); // todo get all customers from db
        ArrayList<String> status = new ArrayList<>();
        status.add("Reserved");
        status.add("Purchased");
        int amountOfSeats = 240;

        while(true) {
            LocalDateTime timeOfSale = LocalDateTime.now();
            Sale sale = new Sale(shows.get(ranNum(1, shows.size())), customers.get(ranNum(1, customers.size())),
                    ranNum(1, amountOfSeats-1), timeOfSale, status.get(ranNum(1, status.size())) );
            // have to check if sale does not already exist.. concurrency is being tested
            db.insertSale(sale);

            try {
                Thread.sleep(ranNum(0, 15000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public int ranNum(int lowerLimit, int upperLimit) {

        Random rand = new Random();

        return rand.nextInt((upperLimit - lowerLimit) + 1) + lowerLimit;
    }
}
