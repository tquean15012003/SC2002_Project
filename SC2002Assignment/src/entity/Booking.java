package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains all the information of a booking
 */
public class Booking implements Serializable{
    
    /**
     * The serialization version number
     */
    private static final long serialVersionUID = 2L;

    /**
     * The movie goer that books seat(s)
     */
    private MovieGoer movieGoer;
    
    /**
     * The total price of booking
     */
    private Double price;
    
    /**
     * The transaction id of booking
     */
    private String transactionId;
    
    /**
     * The tickets that are associated with the booking
     */
    private ArrayList<Ticket> tickets;
    
    /**
     * The cineplex name corresponding to the booking
     */
    private String cineplexName;
        
    /**
     * The show time corresponding to the booking
     */
    private ShowTime showTime;
    
    /**
     * Creates a {@code Booking} object with the given movie goer, price, transaction id, tickets, corresponding cineplex name and corresponding show time
     * @param movieGoer the movie goer that book seat(s)
     * @param price the price of booking
     * @param transactionId the transactionId of booking
     * @param tickets the tickets that are associated with the booking
     * @param cineplexName the cineplex name corresponding to the booking
     * @param showTime the show time corresponding to the booking
     */
    public Booking(MovieGoer movieGoer, Double price, String transactionId, ArrayList<Ticket> tickets, String cineplexName, ShowTime showTime) {
        this.movieGoer = movieGoer;
        this.price = price;
        this.transactionId = transactionId;
        this.tickets = tickets;
        this.cineplexName = cineplexName;
        this.showTime = showTime;
    }
    
    /**
     * This method returns the movie goer that books seat(s)
     * @return the movie goer that book seat(s)
     */
    public MovieGoer getMovieGoer() {
        return this.movieGoer;
    }
    
    /**
     * This method returns the price of the booking
     * @return the price of the booking
     */
    public Double getPrice() {
        return this.price;
    }
    
    /**
     * This method returns the transaction id of the booking
     * @return the transaction id of the booking
     */
    public String getTransactionId() {
        return this.transactionId;
    }
    
    /**
     * This method returns the tickets that are associated with the booking
     * @return the tickets that are associated with the booking
     */
    public ArrayList<Ticket> tickets() {
        return this.tickets;
    }
    
    /**
     * This method returns the cineplex name corresponding to the booking
     * @return the cineplex name corresponding to the booking
     */
    public String getCineplexName() {
        return this.cineplexName;
    }
    
    /**
     * This method returns the show time corresponding to the booking
     * @return the show time corresponding to the booking
     */
    public ShowTime getShowTime() {
        return this.showTime;
    }
}
