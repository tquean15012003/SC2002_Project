package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{
    private String cinemaCode;
    
    private String cinemaClass;
    
    private ArrayList<ShowTime> showTimes = new ArrayList<ShowTime>();
    
    public Cinema(String cinemaCode, String cinemaClass) {
        this.cinemaCode = cinemaCode;
        this.cinemaClass = cinemaClass;
    }
    
    public String getCinemaCode() {
        return this.cinemaCode;
    }
    
    public String getCinemaClass() {
        return this.cinemaClass;
    }
    
    public ArrayList<ShowTime> getShowTimes() {
        return this.showTimes;
    }
}
