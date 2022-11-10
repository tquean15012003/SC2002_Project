package entity;

import java.io.Serializable;

/**
 * This class contains all the information of a ticket
 */
public class Ticket implements Serializable{
    /**
     * The serialization version number
     */
    private static final long serialVersionUID = 9L;

    /**
     * The row of the booked seat
     */
    private Integer row;
    
    /**
     * The column of the booked seat
     */
    private Integer column;
        
    /**
     * Creates a {@code Ticket} object of seat booked with the given row and column
     * @param row the row of the booked seat
     * @param column the column of the booked seat
     */
    public Ticket(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
    
    /**
     * This method returns the row of the booked seat
     * @return the row of the booked seat
     */
    public Integer getRow() {
        return this.row;
    }
    
    /**
     * This method returns the column of the booked seat
     * @return the column of the booked seat
     */
    public Integer getColumn() {
        return this.column;
    }
    
}
