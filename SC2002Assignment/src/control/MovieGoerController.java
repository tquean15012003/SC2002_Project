package control;

import java.util.ArrayList;
import java.util.Scanner;

import boundary.MovieGoerUI;
import entity.DataPath;
import entity.MovieGoer;
import entity.Serialization;

public class MovieGoerController {
	public static void movieGoerSignUp() throws Exception {
		Scanner input = new Scanner(System.in);

		ArrayList<MovieGoer> movieGoerList = (ArrayList<MovieGoer>) Serialization.readSerializedObject(DataPath.MOVIEGOER);


		System.out.println("Enter username:");
		String username = input.nextLine();
		
		System.out.println("Enter password:");
		String password = input.nextLine();
		
		System.out.println("Enter your name:");
		String name = input.nextLine();
		
		System.out.println("Enter your mobile number:");
		String mobile = input.nextLine();
		
		System.out.println("Enter your email address:");
		String email = input.nextLine();

		System.out.println("Enter your age:");
		Integer age = input.nextInt();	

		MovieGoer movieGoer = new MovieGoer(username, password, name, mobile, email, age);
		
		boolean isExist = false;

		if (movieGoerList != null) {
			for (int i = 0; i < movieGoerList.size(); i++) {
				if (movieGoerList.get(i).getUsername().equals(movieGoer.getUsername())) {
					isExist = true;
					break;
				}
			}
		} else {
			movieGoerList = new ArrayList<MovieGoer>();
		}
		
		if (!isExist) {
			movieGoerList.add(movieGoer);
			Serialization.writeSerializedObject(DataPath.MOVIEGOER, movieGoerList);
			System.out.println("Sign up successfully!");
			MovieGoerUI.MovieGoerServicesUI(movieGoer);
		} else {
			System.out.println("Admin already exist!");
		}
	}
	
	public static void movieGoerLogIn() throws Exception{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter username:");
		String username = input.nextLine();

		System.out.println("Enter password:");
		String password = input.nextLine();

		ArrayList<MovieGoer> movieGoerList = (ArrayList<MovieGoer>) Serialization.readSerializedObject(DataPath.MOVIEGOER);
		MovieGoer movieGoer;
		boolean isAuth = false;
		
		if (movieGoerList != null) {
			for (int i = 0; i < movieGoerList.size(); i++) {
				movieGoer = movieGoerList.get(i);
				if (movieGoer.getUsername().equals(username) && movieGoer.getPassword().equals(password)) {
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
