package boundary;

import java.util.ArrayList;

import entity.Cineplex;

public class ShowTimeUI {
    public static void displayCineplexList(ArrayList<Cineplex> cineplexList) {
        System.out.println("\nCineplex list:");
        for (int i = 0; i < cineplexList.size(); i++) {
            System.out.println((i + 1 ) + ". " + cineplexList.get(i).getName());
        }
    }
    
    public static void displayCinemaList(Cineplex cineplex) {
        System.out.println("\nCinema list:");
        for (int i = 0; i < cineplex.getCinemas().size(); i++) {
            System.out.println((i + 1 ) + ". " + cineplex.getCinemas().get(i).getCinemaCode());
        }
    }
}
