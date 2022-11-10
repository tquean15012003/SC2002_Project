package entity;

import java.io.Serializable;

/**
 * This class contains all the information of a seat
 */
public class Seat implements Serializable{
    /**
     * The serialization version number
     */
    public static final long serialVersionUID = 10L;
    
    /**
     * The seat type of a seat
     */
    private SeatType seatType;
    
    /**
     * The transaction id which the seat is associated with
     */
    private String transactionId;
    
    /**
     * The seat status of a seat
     */
    private SeatStatus seatStatus;
    
    /**
     * Creates a {@code Seat} object with the given transaction id, and seat type
     * @param transactionId the transaction id which the seat is associated with
     * @param seatType the type of the seat
     */
    public Seat(String transactionId, SeatType seatType) {
        this.transactionId = transactionId;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.NOT_TAKEN;
    }
    
    /**
     * This method returns the transaction id which the seat is associated with
     * @return the transaction id of the seat
     */
    public String getTransactionId() {
        return this.transactionId;
    }
    
    /**
     * This method sets the transaction id which the seat is associated with
     * @param transactionId the transaction id of the seat
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    /**
     * This method returns the type of the seat
     * @return the type of the seat
     */
    public SeatType getSeatType() {
        return this.seatType;
    }
    
    /**
     * This method sets the type of the seat
     * @param seatType the type of the seat
     */
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    
    /**
     * This method returns the status of the seat
     * @return the status of the seat
     */
    public SeatStatus getSeatStatus() {
        return this.seatStatus;
    }
    
    /**
     * This method sets the status of the seat
     * @param seatStatus the status of the seat
     */
    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
