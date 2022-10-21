package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Admin;
import entity.DataPath;
import entity.Serialization;

public class AdminController {
	public static void adminSignUp() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the secret key to sign up as a admin:");
		if (!input.nextLine().equals("SC2002")) {
			System.out.println("You are not allowed to sign up as a admin");
			return;
		}

		ArrayList<Admin> adminList = (ArrayList<Admin>) Serialization.readSerializedObject(DataPath.ADMIN);
		
		Admin admin;
		admin = new Admin();
		
		boolean isExist = false;

		if (adminList != null) {
			for (int i = 0; i < adminList.size(); i++) {
				if (adminList.get(i).getUsername().equals(admin.getUsername())) {
					isExist = true;
					break;
				}
			}
		} else {
			adminList = new ArrayList<Admin>();
		}
		
		if (!isExist) {
			adminList.add(admin);
			Serialization.writeSerializedObject(DataPath.ADMIN, adminList);
			System.out.println("Sign up successfully!");
		} else {
			System.out.println("Admin already exist!");
		}	
	}
	
	public static void adminLogIn() throws Exception{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter username:");
		String username = input.nextLine();
		System.out.println("Enter password:");
		String password = input.nextLine();
		
		
		ArrayList<Admin> adminList = (ArrayList<Admin>) Serialization.readSerializedObject(DataPath.ADMIN);
		Admin admin;
		boolean isAuth = false;
		
		if (adminList != null) {
			for (int i = 0; i < adminList.size(); i++) {
				admin = adminList.get(i);
				if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
					isAuth = true;
					break;
				}
			}
		}

		if (isAuth) {
			System.out.println("Sign in successfully!");
			
		} else {
			System.out.println("Username or password is not valid!");
		}
	}
}
