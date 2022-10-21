package boundary;

import java.util.Scanner;

public class MainUI {
	// Program entry
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.println("===== Welcome to MOBLIMA =====");

		while (choice != 3) {
			System.out.println("1. Administrator");
			System.out.println("2. Movie goer");
			System.out.println("3. Quit MOBLIMA");
			System.out.println("Enter your choice:");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				AdminUI.AdminMainUI();
				break;
			case 2:
				// MovieGoerUI.MovieGoerMainUI();
				break;
			default:
				System.out.println("Thank for using our MOBLIMA app!");
				break;
			}
		}

		input.close();

	}

}
