package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.DataPath;
import entity.Movie;
import entity.Serialization;

public class MovieController {
    
    public static void viewMovieDetail() {
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        if (movieList == null || movieList.size() == 0) {
            System.out.println("\nThere is no movie now!\n");
            return;
        }
        
        System.out.println();
        System.out.println("Movie list:");
        
        int choice = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1 ) + ". " + movieList.get(i).getTitle());
        }
        System.out.println("Enter your choice:");
        choice = input.nextInt();
        Movie movie = movieList.get(choice - 1);
        System.out.println();
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Synopsis: " + movie.getSynopsis());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Cast:" );
        for (int i = 0; i < movie.getCast().size(); i++) {
            System.out.println(" *" + movie.getCast().get(i));
        }
        System.out.println("Showing status: " + movie.getShowingStatus());
        System.out.println("Movie type: " + movie.getMovieType());
        System.out.println("Duration: " + movie.getDuration());
        System.out.println("Overall rating: " + movie.getOverallRating());
        System.out.println("Sale: " + movie.getSales());
        System.out.println();
        return;
    }
    
    public static void addMovie() {
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        if (movieList == null) {
            movieList = new ArrayList<Movie>();
        }
        System.out.println();
        String title = getTitle();
        String synopsis = getSynopsis();
        String director = getDirector();
        ArrayList<String> cast = getCast();
        String showingStatus = getShowingStatus();
        String movieType = getMovieType();
        String duration = getDuration();
        
        Movie movie = new Movie(title, synopsis,director, cast, showingStatus, movieType, duration);
        
        movieList.add(movie);
        
        Serialization.writeSerializedObject(DataPath.MOVIE, movieList);
        
        System.out.println("The movie has been added!\n");
    }
    
    public static void updateMovie() {
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        if (movieList == null || movieList.size() == 0) {
            System.out.println("\nThere is no movie to remove!\n");
            return;
        }
        
        System.out.println();
        System.out.println("Movie list:");
        
        int choice = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1 ) + ". " + movieList.get(i).getTitle());
        }
        System.out.println("Enter your choice:");
        choice = input.nextInt();
        int index = choice - 1;
        Movie movie = movieList.get(index);
        
        System.out.println();
        System.out.println("What would you want to update?");
        System.out.println("1. Title");
        System.out.println("2. Synopsis");
        System.out.println("3. Director");
        System.out.println("4. Cast");
        System.out.println("5. Showing status");
        System.out.println("6. Movie type");
        System.out.println("7. Duration: ");
        System.out.println("Enter your choice:");
        choice = input.nextInt();
        
        switch(choice) {
            case 1:
                movie.setTitle(getTitle());
                break;
            case 2:
                movie.setSynopsis(getSynopsis());
                break;
            case 3:
                movie.setDirector(getDirector());
                break;
            case 4:
                movie.setCast(getCast());
                break;
            case 5:
                movie.setShowingStatus(getShowingStatus());
                break;
            case 6:
                movie.setMovieType(getMovieType());
                break;
            case 7:
                movie.setDuration(getDuration());
                break;
            default: 
                break;
        }
        
        movieList.set(index, movie);
        
        Serialization.writeSerializedObject(DataPath.MOVIE, movieList);

        System.out.println("The movie has been updated!\n");

        return;
    }
    
    public static void removeMovie() {
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        if (movieList == null || movieList.size() == 0) {
            System.out.println("\nThere is no movie to remove!\n");
            return;
        }
        
        System.out.println();
        System.out.println("Movie list:");
        
        int choice = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1 ) + ". " + movieList.get(i).getTitle());
        }
        System.out.println("Enter your choice:");
        choice = input.nextInt();
        movieList.remove(choice - 1);
        
        Serialization.writeSerializedObject(DataPath.MOVIE, movieList);

        System.out.println("The movie has been removed!\n");

        return;
    }
    
    public static void listTopMovieByRating() {
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        if (movieList == null || movieList.size() == 0) {
            System.out.println("\nThere is no movie now!\n");
            return;
        }
        
        for (int i = 1; i < movieList.size(); i++)
        {
            for (int j = i; j > 0; j--) {
                if (movieList.get(j).getOverallRating() > movieList.get(j-1).getOverallRating()) {
                    Movie movie = movieList.get(j);
                    movieList.set(j, movieList.get(j-1));
                    movieList.set(j - 1, movie);
                } else {
                    break;
                }
            }
        }
        
        System.out.println("\nTop movies by overall rating:");
        int size = movieList.size() < 5 ? movieList.size() : 5;
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1 ) + ". " + movieList.get(i).getTitle() + " - Overall rating: " + movieList.get(i).getOverallRating());
        }
        System.out.println("");
    }
    
    public static void listTopMovieBySales() {
        ArrayList<Movie> movieList = (ArrayList<Movie>) Serialization.readSerializedObject(DataPath.MOVIE);
        if (movieList == null || movieList.size() == 0) {
            System.out.println("\nThere is no movie now!\n");
            return;
        }
        
        for (int i = 1; i < movieList.size(); i++)
        {
            for (int j = i; j > 0; j--) {
                if (movieList.get(j).getSales() > movieList.get(j-1).getSales()) {
                    Movie movie = movieList.get(j);
                    movieList.set(j, movieList.get(j-1));
                    movieList.set(j - 1, movie);
                } else {
                    break;
                }
            }
        }
        
        System.out.println("\nTop movies by sales:");
        int size = movieList.size() < 5 ? movieList.size() : 5;
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1 ) + ". " + movieList.get(i).getTitle() + " - Total sales: " + movieList.get(i).getSales());
        }
        System.out.println("");
        
    }
    
    
    
    private static String getTitle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = input.nextLine();
        return title;
    }
    
    private static String getSynopsis() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter synopsis:");
        String synopsis = input.nextLine();
        return synopsis;
    }
    
    private static String getDirector() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter director:");
        String director = input.nextLine();
        return director;
    }
    
    private static ArrayList<String> getCast() {
        ArrayList<String> cast = new ArrayList<String>();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cast size:");
        Integer castSize = input.nextInt();
        input.nextLine();
        for (int i = 0; i < castSize; i++) {
            System.out.println("Enter cast's name " + (i + 1) + ":");
            String castName = input.nextLine();
            cast.add(castName);
        }
        
        return cast;
    }
    
    private static String getShowingStatus() {
        int choice = 0;
        String showingStatus = "";
        Scanner input = new Scanner(System.in);
        System.out.println("==== Please choose showing status ====");
        
        while (choice != 1) {
            System.out.println("1. Coming soon");
            System.out.println("2. Preview");
            System.out.println("3. Now showing");
            System.out.println("4. End of showing");
            System.out.println("Enter your choice:");

            choice = input.nextInt();

            switch (choice) {
            case 1:
                return "Coming soon";
            case 2:
                return "preview";
            case 3:
                return "Now showing";
            case 4:
                return "End of showing";
            default:
                return "End of showing";
            }
        }
        return "End of showing";
    }
    
    private static String getMovieType() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("==== Please choose movie type ====");
        
        while (choice != 1) {
            System.out.println("1. Regular");
            System.out.println("2. Blockbuster");
            System.out.println("3. 3D");
            System.out.println("Enter your choice:");

            choice = input.nextInt();

            switch (choice) {
            case 1:
                return "Regular";
            case 2:
                return "Blockbuster";
            case 3:
                return "3D";
            default:
                return "Regular";
            }
        }
        
        return "Regular";
    }
    
    private static String getDuration() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter duration (in minutes):");
        String duration = input.nextLine();
        return duration;
    }
}
