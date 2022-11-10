package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains all the information of a cineplex
 */
public class Cineplex implements Serializable{
    /**
     * The serialization version number
     */
    private static final long serialVersionUID = 4L;

    /**
     * The name of a cineplex
     */
    private String name;
    
    /**
     * The list of cinemas of a cineplex
     */
    private ArrayList<Cinema> cinnemas = new ArrayList<Cinema>();
    
    /**
     * Creates a {@code Cineplex} object with the given name
     * @param name the name of the cineplex
     */
    public Cineplex(String name) {
        this.name = name;
    }
    
    /**
     * This method returns the name of the cineplex
     * @return name the name of cineplex
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * This method returns the list of cinemas of the cineplex
     * @return cinnemas the list of cinemas of the cineplex
     */
    public ArrayList<Cinema> getCinemas() {
        return this.cinnemas;
    }
}
