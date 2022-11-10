package entity;

/**
 * The seat types for a show time seat
 */
public enum SeatType implements LabelledItem {
    /**
    * Normal
    */
   NORMAL("Normal"),
   /**
    * Premium
    */
   PREMIUM("Premium");
 
   /**
    * The label of the seat type
    */
   String label;
   
   private SeatType(String label) {
       this.label = label;
   }

   @Override
   public String getLabel() {
       return label;
   }
}

