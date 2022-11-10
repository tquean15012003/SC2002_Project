package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * This class contains methods to display all pricing-scheme-related UI
 */
public class PricingSchemeUI {
    
    /**
     * The method displays the all holidays
     * @param holidayList the list of holidays
     */
    public static void displayHodidayList(ArrayList<LocalDate> holidayList) {
        System.out.println("\nHoliday list:");
        for (int i = 0; i < holidayList.size(); i++) {
            System.out.println((i + 1 ) + ". " + holidayList.get(i).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
}
