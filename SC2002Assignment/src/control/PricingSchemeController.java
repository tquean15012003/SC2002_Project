package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.CommonUI;
import boundary.PricingSchemeUI;
import entity.AgeGroup;
import entity.CinemaClass;
import entity.DataPath;
import entity.DateType;
import entity.MovieType;
import entity.PricingScheme;
import entity.SeatType;
import entity.Serialization;

/**
 * This class controls all pricing-scheme-related services
 */
public class PricingSchemeController {
    
    /**
     * This method controls modifying base price
     */
    public static void modifyBasePrice() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        CommonUI.displaySingleMessage("Current base price: " + pricingScheme.getBasePrice());
        pricingScheme.setBasePrice(getBasePrice());
        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
        CommonUI.displaySingleMessage("Modify base price successfully!\n");
    }

    /**
     * This method controls updating cinema class multiplier
     */
    public static void updateCinemeClassMutiplier() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);
        CinemaClass cinemaClass = getCinemaClass();
        CommonUI.displaySingleMessage("Current multiplier: " + pricingScheme.getCinemaMultiplier(cinemaClass));
        pricingScheme.setCinemaMultiplier(cinemaClass, getMultiplier());
        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
        CommonUI.displaySingleMessage("Modify multiplier successfully!\n");

    }

    /**
     * This method controls updating age group multiplier
     */
    public static void updateAgeGroupMutiplier() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        AgeGroup ageGroup = getAgeGroup();
        CommonUI.displaySingleMessage("Current multiplier: " + pricingScheme.getAgeMultiplier(ageGroup));
        pricingScheme.setAgeMultiplier(ageGroup, getMultiplier());
        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
        CommonUI.displaySingleMessage("Modify multiplier successfully!\n");

    }

    /**
     * This method controls updating movie type multiplier
     */
    public static void updateMovieTypeMutiplier() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        MovieType movieType = getMovieType();
        CommonUI.displaySingleMessage("Current multiplier: " + pricingScheme.getMovieMultiplier(movieType));
        pricingScheme.setMovieMultiplier(movieType, getMultiplier());
        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
        CommonUI.displaySingleMessage("Modify multiplier successfully!\n");

    }

    /**
     * This method controls updating date type multiplier
     */
    public static void updateDateTypeMutiplier() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        DateType dateType = getDateType();
        CommonUI.displaySingleMessage("Current multiplier: " + pricingScheme.getDateMultiplier(dateType));
        pricingScheme.setDateMultiplier(dateType, getMultiplier());
        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
        CommonUI.displaySingleMessage("Modify multiplier successfully!\n");

    }

    /**
     * This method controls updating seat type multiplier
     */
    public static void updateSeatTypeMutiplier() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        SeatType seatType = getSeatType();
        CommonUI.displaySingleMessage("Current multiplier: " + pricingScheme.getSeatMultiplier(seatType));
        pricingScheme.setSeatMultiplier(seatType, getMultiplier());
        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
        CommonUI.displaySingleMessage("Modify multiplier successfully!\n");

    }

    /**
     * This method controls adding a new holiday
     */
    public static void addHoliday() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        LocalDate localDate = getLocalDate();

        if (checkHolidayExist(pricingScheme.getHolidayDates(), localDate)) {
            CommonUI.displaySingleMessage("Holiday already existed!\n");
        } else {
            pricingScheme.getHolidayDates().add(localDate);
            Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);
            CommonUI.displaySingleMessage("Add holiday successfully!\n");
        }
    }

    /**
     * This method controls removing a  holiday
     */
    public static void removeHoliday() {
        PricingScheme pricingScheme = (PricingScheme) Serialization.readSerializedObject(DataPath.PRCING_SCHEME);

        if (pricingScheme == null) {
            pricingScheme = new PricingScheme();
        }

        int choice = chooseHolidayFromList(pricingScheme.getHolidayDates());

        if (choice == -1) {
            CommonUI.displaySingleMessage("\nThere is no holiday to remove!\n");
            return;
        }

        pricingScheme.getHolidayDates().remove(choice - 1);

        Serialization.writeSerializedObject(DataPath.PRCING_SCHEME, pricingScheme);

        CommonUI.displaySingleMessage("The holiday has been removed!\n");

    }

    /**
     * This method returns the base price of a ticket
     * @return the base price of a ticket
     */
    private static double getBasePrice() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter base price:");
        Double basePrice = input.nextDouble();
        return basePrice;
    }

    /**
     * This method return the date
     * @return the date
     */
    private static LocalDate getLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                CommonUI.displaySingleMessage("Enter start date (dd/mm/yyyy): ");
                String dateTimeString = input.nextLine();
                return LocalDate.parse(dateTimeString, formatter);

            } catch (DateTimeParseException e) {
                CommonUI.displaySingleMessage("Please enter a valid date (dd/mm/yyyy):");
            }
        }
    }

    /**
     * This method return true if the holiday already existed
     * @return true if the holiday already existed
     */
    private static boolean checkHolidayExist(ArrayList<LocalDate> holidayList, LocalDate holiday) {
        for (int i = 0; i < holidayList.size(); i++) {
            if (holidayList.get(i).equals(holiday)) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method controls choosing a holiday from the holiday list
     * @param holidayList the list of holidays
     * @return the index of the movie
     */
    public static int chooseHolidayFromList(ArrayList<LocalDate> holidayList) {
        int choice = -1;
        if (holidayList == null || holidayList.size() == 0) {
            return choice;
        }

        choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice < 1 || choice > holidayList.size()) {
            PricingSchemeUI.displayHodidayList(holidayList);
            CommonUI.displaySingleMessage("Enter your choice:");
            choice = input.nextInt();
        }
        return choice;
    }

    /**
     * This method returns the cinema class
     * @return the cinema class
     */
    private static CinemaClass getCinemaClass() {
        int choice = 0;
        CinemaClass cinemaClass;
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("==== Please choose showing status ====");
        CommonUI.displaySingleMessage("1. Normal\n2. Platinum Movie Suite\nEnter your choice:");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                cinemaClass = CinemaClass.NORMAL;
                break;
            case 2:
                cinemaClass = CinemaClass.PLATINUM_MOVIE_SUITE;
                break;
            default:
                cinemaClass = CinemaClass.NORMAL;
                break;
        }

        return cinemaClass;
    }

    /**
     * This method returns the age group
     * @return the age group
     */
    private static AgeGroup getAgeGroup() {
        int choice = 0;
        AgeGroup ageGroup;
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("==== Please choose age group ====");
        CommonUI.displaySingleMessage("1. Child\n2. Adult\n3. Senior Citizen\nEnter your choice:");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                ageGroup = AgeGroup.CHILD;
                break;
            case 2:
                ageGroup = AgeGroup.ADULT;
                break;
            case 3:
                ageGroup = AgeGroup.SENIOR_CITIZEN;
                break;
            default:
                ageGroup = AgeGroup.ADULT;
                break;
        }

        return ageGroup;
    }

    /**
     * This method returns the movie type
     * @return the movie type
     */
    private static MovieType getMovieType() {
        int choice = 0;
        MovieType movieType;
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("==== Please choose movie type ====");
        CommonUI.displaySingleMessage("1. Regular\n2. Blockbuster\n3. 3D\nEnter your choice:");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                movieType = MovieType.REGULAR;
                break;
            case 2:
                movieType = MovieType.BLOCKBUSTER;
                break;
            case 3:
                movieType = MovieType._3D;
                break;
            default:
                movieType = MovieType.REGULAR;
                break;
        }

        return movieType;
    }

    /**
     * This method returns the date type
     * @return the date type
     */
    private static DateType getDateType() {
        int choice = 0;
        DateType dateType;
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("==== Please choose date type ====");
        CommonUI.displaySingleMessage("1. Weekday\n2. Weekend\n3. Holiday\nEnter your choice:");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                dateType = DateType.WEEKDAY;
                break;
            case 2:
                dateType = DateType.WEEKEND;
                break;
            case 3:
                dateType = DateType.HOLIDAY;
                break;
            default:
                dateType = DateType.WEEKDAY;
                break;
        }

        return dateType;
    }

    /**
     * This method returns the seat type
     * @return the seat type
     */
    private static SeatType getSeatType() {
        int choice = 0;
        SeatType seatType;
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("==== Please choose seat type ====");
        CommonUI.displaySingleMessage("1. Normal\n2. Premium\nEnter your choice:");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                seatType = SeatType.NORMAL;
                break;
            case 2:
                seatType = SeatType.PREMIUM;
                break;
            default:
                seatType = SeatType.NORMAL;
                break;
        }

        return seatType;
    }

    /**
     * This method returns the multiplier
     * @return the multiplier
     */
    private static double getMultiplier() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter multiplier:");
        Double multiplier = input.nextDouble();
        return multiplier;
    }
}
