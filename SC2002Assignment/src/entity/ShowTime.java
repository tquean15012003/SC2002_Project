package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ShowTime implements Serializable{
    private static final long serialVersionUID = 8L;

    private LocalDateTime startDateTime;
    
    private Movie movie;
    
    private String cinemaCode;
    
    private String[][] layout = new String[10][10];
    
    public ShowTime(LocalDateTime startDateTime, Movie movie, String cinemaCode) {
        this.startDateTime = startDateTime;
        this.movie = movie;
        this.cinemaCode = cinemaCode;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.layout[i][j]= "";
            }
        }
    }
    
    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }
    
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    
    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public String getCinemaCode() {
        return this.cinemaCode;
    }

    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }
    
    public String[][] getLayout() {
        return this.layout;
    }
    
    public void takeSeat(Integer row, Integer column, String transactionId) {
        this.layout[row][column] = transactionId;
    }
}
