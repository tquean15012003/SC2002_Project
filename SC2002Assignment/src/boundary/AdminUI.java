package boundary;


import java.util.Scanner;

import control.AdminController;

public class AdminUI {
	
	private static Scanner input = new Scanner(System.in);

	
	public static  void AdminMainUI() {
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
			default:
				return;
			}
		}
		
		
	}
}
	
