package boundary;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import control.ShowTimeController;
import entity.Cinema;
import entity.Cineplex;
import entity.DataPath;
import entity.Movie;
import entity.Serialization;
import entity.ShowTime;
import entity.ShowingStatus;

/**
 * This class contains methods to display all show-time-related UI
 */
public class ShowTimeUI {
    
    /**
     * The method displays the all cineplexes
     * @param cineplexList the list of cineplex
     */
    public static void displayCineplexList(ArrayList<Cineplex> cineplexList) {
        System.out.println("\nCineplex list:");
        for (int i = 0; i < cineplexList.size(); i++) {
            System.out.println((i + 1 ) + ". " + cineplexList.get(i).getName());
        }
    }
    
    /**
     * The method displays all cinemas of a cineplex
     * @param cineplex that contains cinemas
     */
    public static void displayCinemaList(Cineplex cineplex) {
        System.out.println("\nCinema list:");
        for (int i = 0; i < cineplex.getCinemas().size(); i++) {
            System.out.println((i + 1 ) + ". " + cineplex.getCinemas().get(i).getCinemaCode());
        }
    }
    
    /**
     * The method displays all showtimes of a cinemas
     * @param showTimeList the list of show times
     */
    public static void displayShowTimeList(ArrayList<ShowTime> showTimeList) {
        System.out.println("\nShow time list:");
        for (int i = 0; i < showTimeList.size(); i++) {
            ShowTime showTime = showTimeList.get(i);
            System.out.println((i + 1 ) + ". " + showTime.getMovie().getTitle() + " " + showTime.getStartDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }
    }
    
    /**
     * The method displays updating options of a show time
     */
    public static void displayShowTimeUpdateOption() {
        System.out.println("\nWhat would you want to update?");
        System.out.println("1. Movie");
        System.out.println("2. Start Date Time");
    }
    
    /**
     * The method displays all available showtimes for a admin
     * @param cineplexList the list of all cineplexes
     */
    public static void displayShowTimeAdmin(ArrayList<Cineplex> cineplexList) {
        for (int i = 0; i < cineplexList.size(); i++) {
            Cineplex cineplex = cineplexList.get(i);
            ArrayList <Cinema> cinemaList = cineplex.getCinemas();
            System.out.println(cineplex.getName());
            System.out.println("------------------");
            ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
            for (int j = 0; j < movieList.size(); j++) {
                ArrayList<ShowTime> showTimeListToShow = new ArrayList<ShowTime>();
                Movie movie = movieList.get(j);
                for (int m = 0; m < cinemaList.size(); m++) {
                    ArrayList<ShowTime> showTimeList = cinemaList.get(m).getShowTimes();
                    for (int n = 0; n < showTimeList.size(); n++) {
                        ShowTime showTime = showTimeList.get(n);
                        if (movie.getTitle().equalsIgnoreCase(showTime.getMovie().getTitle())) {
                            showTimeListToShow.add(showTime);
                        }
                    }
                }
                if (showTimeListToShow.size() > 0) {
                    System.out.println(movie.getTitle());
                    showTimeListToShow = ShowTimeController.sortShowTimeList(showTimeListToShow);
                    for (int p = 0; p < showTimeListToShow.size(); p++) {
                        ShowTime showTimeToShow = showTimeListToShow.get(p);
                        System.out.println(showTimeToShow.getStartDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + " (" + showTimeToShow.getCinemaCode() + ")");
                    }                    
                    System.out.println();
                }
            }
        }
    }
    
    /**
     * The method displays all available showtimes for a movie goer
     * @param cineplexList the list of all cineplexes
     */
    public static void displayShowTimeMovieGoer(ArrayList<Cineplex> cineplexList) {
        for (int i = 0; i < cineplexList.size(); i++) {
            Cineplex cineplex = cineplexList.get(i);
            ArrayList <Cinema> cinemaList = cineplex.getCinemas();
            System.out.println(cineplex.getName());
            System.out.println("------------------");
            ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
            for (int j = 0; j < movieList.size(); j++) {
                ArrayList<ShowTime> showTimeListToShow = new ArrayList<ShowTime>();
                Movie movie = movieList.get(j);
                for (int m = 0; m < cinemaList.size(); m++) {
                    ArrayList<ShowTime> showTimeList = cinemaList.get(m).getShowTimes();
                    for (int n = 0; n < showTimeList.size(); n++) {
                        ShowTime showTime = showTimeList.get(n);
                        if (movie.getTitle().equalsIgnoreCase(showTime.getMovie().getTitle()) && (movie.getShowingStatus().getLabel().equalsIgnoreCase(ShowingStatus.PREVIEW.getLabel()) ||  movie.getShowingStatus().getLabel().equalsIgnoreCase(ShowingStatus.NOW_SHOWING.getLabel())) ) {
                            showTimeListToShow.add(showTime);
                        }
                    }
                }
                if (showTimeListToShow.size() > 0) {
                    System.out.println(movie.getTitle());
                    showTimeListToShow = ShowTimeController.sortShowTimeList(showTimeListToShow);
                    for (int p = 0; p < showTimeListToShow.size(); p++) {
                        ShowTime showTimeToShow = showTimeListToShow.get(p);
                        System.out.println(showTimeToShow.getStartDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + " (" + showTimeToShow.getCinemaCode() + ")");
                    }                    
                    System.out.println();
                }
            }
        }
    }
    
}
