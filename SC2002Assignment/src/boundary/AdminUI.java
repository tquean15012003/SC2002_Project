package boundary;


import java.util.Scanner;

import control.AdminController;
import control.MovieController;
import control.ShowTimeController;
import entity.Admin;

public class AdminUI {
	
	private static Scanner input = new Scanner(System.in);

	public static void displayAdminMainUI() {
		int choice = 0;
		System.out.println("===== Welcome to Admin UI =====");

		while (choice != 3) {
			System.out.println("1. Log in");
			System.out.println("2. Sign up");
			System.out.println("3. Quit Admin UI");
			System.out.println("Enter your choice:");
			
			choice = input.nextInt();

			switch (choice) {
			case 1:
				try {
					AdminController.adminLogIn();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					AdminController.adminSignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:  return;
			default:
			    break;
			}
		}
	}

	public static void displayAdminServicesUI(Admin admin) {
		int choice = 0;
		System.out.println("Hi " + admin.getName());
		System.out.println("===== What would you like to do? =====");

		while (choice != 3) {
			System.out.println("1. Modify Movie Listings");
			System.out.println("2. Modify Cinema Showtimes");
			System.out.println("3. Modify Ticket Pricing Scheme");
			System.out.println("4. List Top 5 Movies");
			System.out.println("5. Exit");
	        System.out.println("Enter your choice:");

			choice = input.nextInt();

			switch (choice) {
			case 1:
				displayAdminMovieServicesUI();
				break;
			case 2:
			    displayAdminShowtimeServicesUI();
				break;
			case 4:
                displayAdminListTopMovieServicesUI();
                break;
			case 5:
                AdminListTopMovieServicesUI();
                return;
			default:
				break;
			}
		}
	}
	
	public static  void displayAdminMovieServicesUI() {
		int choice = 0;
		System.out.println("===== What would you like to do? =====");

		while (choice != 5) {
			System.out.println("1. View movie details");
			System.out.println("2. Add a Movie");
			System.out.println("3. Update a Movie");
			System.out.println("4. Remove a Movie");
			System.out.println("5. Exit");
	        System.out.println("Enter your choice:");

			choice = input.nextInt();

			switch (choice) {
			case 1:
			    try {
                    MovieController.viewMovieDetail();
                } catch (Exception e) {
                    e.printStackTrace();
                }
				break;
			case 2:
				try {
					MovieController.addMovie();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
                try {
                    MovieController.updateMovie();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
			case 4:
                try {
                    MovieController.removeMovie();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
			default:
			    break;
			}
		}
	}

	public static  void displayAdminShowtimeServicesUI() {
        int choice = 0;
        System.out.println("===== What would you like to do? =====");

        while (choice != 5) {
            System.out.println("1. View movie showtimes");
            System.out.println("2. Add a Show Time");
            System.out.println("3. Update a Show Time");
            System.out.println("4. Remove a Show Time");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            choice = input.nextInt();

            switch (choice) {
       
            case 2:
                try {
                    ShowTimeController.addShowTime();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
     
            default:
                return;
            }
        }
	}
        
    public static void displayAdminListTopMovieServicesUI() {
        int choice = 0;
        System.out.println("Top 5 movies by ... ");

        while (choice != 3) {
            System.out.println("1. Ratings");
            System.out.println("2. Ticket sales");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    try {
                        MovieController.listTopMovieByRating();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        MovieController.listTopMovieBySales();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
	
}
	
