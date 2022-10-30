package entity;

import java.io.Serializable;

public class Ticket implements Serializable{
    
    private Integer row;
    
    private Integer column;
        
    Ticket(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
    
    public Integer getRow() {
        return this.row;
    }
    
    public Integer getColumn() {
        return this.column;
    }
    
}
