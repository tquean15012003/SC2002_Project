package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Booking implements Serializable{
    private MovieGoer movieGoer;
    
    private Double price;
    
    private String transactionId;
    
    private ArrayList<Ticket> tickets;
    
    public Booking(MovieGoer movieGoer, Double price, String transactionId, ArrayList<Ticket> tickets) {
        this.movieGoer = movieGoer;
        this.price = price;
        this.transactionId = transactionId;
        this.tickets = tickets;
    }
    
//    public String generateTransactionId(Cinema cinema) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
//        String transaction = cinema.getCinemaCode() + LocalDateTime.now().format(formatter);
//        return transaction;
//        
//    }
    
    public MovieGoer getMovieGoer() {
        return this.movieGoer;
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public String getTransactionId() {
        return this.transactionId;
    }
    
    public ArrayList<Ticket> tickets() {
        return this.tickets;
    }
}
