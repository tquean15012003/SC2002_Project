package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Admin;
import entity.DataPath;
import entity.MovieGoer;
import entity.Serialization;

public class MovieGoerController {
	public static void movieGoerSignUp() throws Exception {

		ArrayList<MovieGoer> movieGoerList = (ArrayList<MovieGoer>) Serialization.readSerializedObject(DataPath.MOVIEGOER);
		
		MovieGoer movieGoer = new MovieGoer();
		
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
