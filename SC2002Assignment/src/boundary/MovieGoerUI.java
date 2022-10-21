package boundary;

import java.util.Scanner;

import control.MovieGoerController;

public class MovieGoerUI {
		
		private static Scanner input = new Scanner(System.in);

		
		public static  void MovieGoerMainUI() {
			int choice = 0;
			System.out.println("===== Welcome to MovieGoer UI =====");

			while (choice != 3) {
				System.out.println("1. Log in");
				System.out.println("2. Sign up");
				System.out.println("3. Quit MovieGoer UI");
				System.out.println("Enter your choice:");
				
				choice = input.nextInt();

				switch (choice) {
				case 1:
					try {
						MovieGoerController.movieGoerLogIn();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						MovieGoerController.movieGoerSignUp();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				default:
					return;
				}
			}
			
			
		}

}

