package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable{
    private String name;
    
    private ArrayList<Cinema> cinnemas = new ArrayList<Cinema>();
    
    public Cineplex(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<Cinema> getCinemas() {
        return this.cinnemas;
    }
}
