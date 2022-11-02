package control;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.CommonUI;
import boundary.ShowTimeUI;
import entity.Cinema;
import entity.Cineplex;
import entity.DataPath;
import entity.Movie;
import entity.Serialization;
import entity.ShowTime;

public class ShowTimeController {
    public static void addShowTime() {
        ArrayList<Cineplex> cineplexList = (ArrayList<Cineplex>) Serialization.readSerializedObject(DataPath.CINEPLEX);
        
        if (cineplexList == null || cineplexList.size() == 0) {
            CommonUI.displaySingleMessage("\nThere is no cineplex to add a showtime!\n");
            return;
        }
        
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > cineplexList.size()) {
            ShowTimeUI.displayCineplexList(cineplexList);
            CommonUI.displaySingleMessage("Enter your choice:");
            choice = input.nextInt();
        }
        
        if (cineplexList == null || cineplexList.size() == 0) {
            CommonUI.displaySingleMessage("\nThere is no cineplex to add a showtime!\n");
            return;
        }
        
        int cineplexIndex = choice - 1;
        Cineplex cineplex = cineplexList.get(cineplexIndex);
       
        choice = 0;
        while (choice < 1 || choice > cineplexList.size()) {
            ShowTimeUI.displayCinemaList(cineplex);
            CommonUI.displaySingleMessage("Enter your choice:");
            choice = input.nextInt();
        }
        int cinemaIndex = choice - 1;
        Cinema cinema = cineplex.getCinemas().get(cinemaIndex);
        
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        choice = MovieController.chooseMovieFromList(movieList);
        
        Movie movie = movieList.get(choice - 1);
        
        Integer duration = Integer.parseInt(movie.getDuration());
        
        LocalDateTime startDateTime = getDateTime();
        
    }
    
    public static LocalDateTime getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                CommonUI.displaySingleMessage("Enter start date & time (dd/mm/yyyy hh:mm): ");
                String dateTimeString = input.nextLine();
                return LocalDateTime.parse(dateTimeString, formatter);
                
            } catch (DateTimeParseException e) {
                CommonUI.displaySingleMessage("Please enter a valid date time of format: dd/mm/yyyy hh:mm");
            }
        }
    }
    
    public static boolean checkClash() {
        return true;
    }
}
