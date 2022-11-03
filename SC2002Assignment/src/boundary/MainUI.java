package boundary;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Cinema;
import entity.Cineplex;
import entity.DataPath;
import entity.Serialization;

public class MainUI {
	// Program entry
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
//		ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
//		
//		Cinema cinema1 = new Cinema("GV1", "Normal");
//		Cinema cinema2 = new Cinema("GV2", "Normal");
//		Cinema cinema3 = new Cinema("GV3", "Platinum movie suites");
//	    
//	    Cineplex cineplex1 = new Cineplex("Golden Village");
//	    cineplex1.getCinemas().add(cinema1);
//        cineplex1.getCinemas().add(cinema2);
//        cineplex1.getCinemas().add(cinema3);
//        
//        Cinema cinema4 = new Cinema("CC1", "Normal");
//        Cinema cinema5 = new Cinema("CC2", "Normal");
//        Cinema cinema6 = new Cinema("CC3", "Platinum movie suites");
//        
//        Cineplex cineplex2 = new Cineplex("Cathay Cineplex");
//        cineplex2.getCinemas().add(cinema4);
//        cineplex2.getCinemas().add(cinema5);
//        cineplex2.getCinemas().add(cinema6);
//        
//        Cinema cinema7 = new Cinema("ST1", "Normal");
//        Cinema cinema8 = new Cinema("ST2", "Normal");
//        Cinema cinema9 = new Cinema("ST3", "Platinum movie suites");
//        
//        Cineplex cineplex3 = new Cineplex("Shaw Theatres");
//        cineplex3.getCinemas().add(cinema7);
//        cineplex3.getCinemas().add(cinema8);
//        cineplex3.getCinemas().add(cinema9);
//        
//        cineplexes.add(cineplex1);
//        cineplexes.add(cineplex2);
//        cineplexes.add(cineplex3);
//
//        Serialization.writeSerializedObject(DataPath.CINEPLEX, cineplexes);
        
//        ArrayList<Cineplex> cineplexList = (ArrayList<Cineplex>) Serialization.readSerializedObject(DataPath.CINEPLEX);
//        
//        for (int i = 0; i < cineplexList.size(); i++) {
//            Cineplex cineplex = cineplexList.get(i);
//            System.out.println(cineplex.getName());
//            for (int j = 0; j < cineplex.getCinemas().size(); j++) {
//                System.out.println(cineplex.getCinemas().get(j).getCinemaCode());
//            }
//        }

		
		System.out.println("===== Welcome to MOBLIMA =====");
	
		while (choice != 3) {
			System.out.println("1. Administrator");
			System.out.println("2. Movie Goer");
			System.out.println("3. Quit MOBLIMA");
			System.out.println("Enter your choice:");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				AdminUI.displayAdminMainUI();
				break;
			case 2:
				MovieGoerUI.displayMovieGoerMainUI();
				break;
			default:
				System.out.println("Thank for using our MOBLIMA app!");
				break;
			}
		}

		input.close();

	}

}
