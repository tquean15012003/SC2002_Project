package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class contains all the information of a show time
 */
public class ShowTime implements Serializable{
    
    /**
     * The serialization version number
     */
    private static final long serialVersionUID = 8L;

    /**
     * The start date and time of a show time
     */
    private LocalDateTime startDateTime;
    
    /**
     * The movie of the show time
     */
    private Movie movie;
    
    /**
     * The cinemaCode of a show time
     */
    private String cinemaCode;
    
    /**
     * The seat layout of a show time
     */
    private Seat[][] layout = new Seat[10][10];
    
    /**
     * Creates a {@code ShowTime} object with the given cinemaCode, start date and time and movie
     * @param startDateTime the start date time of the show time
     * @param movie the movie of the show time
     * @param cinemaCode the cinemaCode which the show time belongs to
     */
    public ShowTime(LocalDateTime startDateTime, Movie movie, String cinemaCode) {
        this.startDateTime = startDateTime;
        this.movie = movie;
        this.cinemaCode = cinemaCode;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.layout[i][j] = new Seat("", SeatType.NORMAL);
            }
        }
        for (int i = 0; i < 10; i++)  {
            this.layout[9][i].setSeatType(SeatType.PREMIUM);
        }
    }
    
    /**
     * This method returns the start date time of the show time
     * @return the start date time of the show time
     */
    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }
    
    /**
     * This method sets the start date time of the show time
     * @param startDateTime the start date time of the show time
     */
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    
    /**
     * This method returns the movie of the show time
     * @return start the movie of the show time
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * This method sets the movie of the show time
     * @param movie the movie of the show time
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    /**
     * This method returns the movie of the show time
     * @return cinemaCode the cinema code of the show time
     */
    public String getCinemaCode() {
        return this.cinemaCode;
    }

    /**
     * This method sets the cinema code of the show time
     * @param cinemaCode the cinema code of the show time
     */
    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }
    
    /**
     * This method returns the layout of the show time
     * @return layout the layout of the show time
     */
    public Seat[][] getLayout() {
        return this.layout;
    }
    
    /**
     * This method assign the transaction id to the seat
     * @param row the row of the seat
     * @param column the column of the seat
     * @param transactionId the transaction id which the booking belongs to
     */
    public void takeSeat(Integer row, Integer column, String transactionId) {
        this.layout[row][column].setTransactionId(transactionId);
    }
}
