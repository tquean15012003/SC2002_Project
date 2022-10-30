package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ShowTime implements Serializable{
    private LocalDateTime startDateTime;
    
    private Movie movie;
    
    private String[][] layout = new String[10][10];
    
    public ShowTime(LocalDateTime startDateTime, Movie movie) {
        this.startDateTime = startDateTime;
        this.movie = movie;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.layout[i][j]= "";
            }
        }
    }
    
    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }
    
    public Movie getMovie() {
        return this.movie;
    }
    
    public String[][] getLayout() {
        return this.layout;
    }
    
    public void takeSeat(Integer row, Integer column, String transactionId) {
        this.layout[row][column] = transactionId;
    }
}
