package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains all the information of a cinema
 */
public class Cinema implements Serializable{
    
    /**
     * The serialization version number
     */
    private static final long serialVersionUID = 3L;

    /**
     * The code of a cinema
     */
    private String cinemaCode;
    
    
    /**
     * The class of a cinema
     */
    private CinemaClass cinemaClass;
    
    /**
     * The show time list of a cinema
     */
    private ArrayList<ShowTime> showTimes = new ArrayList<ShowTime>();
    
    
    /**
     * Creates a {@code Cinema} object with the given cinema code and cinema class
     * @param cinemaCode the code of the cinema
     * @param cinemaClass the class of the cinema
     */
    public Cinema(String cinemaCode, CinemaClass cinemaClass) {
        this.cinemaCode = cinemaCode;
        this.cinemaClass = cinemaClass;
    }
    
    /**
     * This method returns the code of the cinema
     * @return the code of the cinema
     */
    public String getCinemaCode() {
        return this.cinemaCode;
    }
    
    /**
     * This method returns the class of the cinema
     * @return the class of the cinema
     */
    public CinemaClass getCinemaClass() {
        return this.cinemaClass;
    }
    
    /**
     * This method returns the show time list of the cinema
     * @return the show time list of the cinema
     */
    public ArrayList<ShowTime> getShowTimes() {
        return this.showTimes;
    }
    
    /**
     * This method sets the show time list of the cinema
     * @param showTimes the show time list of the cienma
     */
    public void setShowTimes(ArrayList<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }
}
