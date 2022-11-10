package control;

import java.util.ArrayList;
import java.util.Scanner;

import boundary.CommonUI;
import boundary.MovieGoerUI;
import entity.DataPath;
import entity.MovieGoer;
import entity.Serialization;

/**
 * This class controls all movie-goer-related services
 */
public class MovieGoerController {
    /**
     * This method controls signing up for the movie goer
     * @throws error
     */
    public static void movieGoerSignUp() throws Exception {
        Scanner input = new Scanner(System.in);

        ArrayList<MovieGoer> movieGoerList = (ArrayList<MovieGoer>) Serialization.readSerializedObject(DataPath.MOVIEGOER);

        
        String username = getUsername();
        
        if (movieGoerList != null) {
            for (int i = 0; i < movieGoerList.size(); i++) {
                if (movieGoerList.get(i).getUsername().equals(username)) {
                    CommonUI.displaySingleMessage("Movie goer username already exist!\n");
                    return;
                }
            }
        }
        
		String password = getPassword();
		String name = getName();
		String mobile = getMobile();
		String email = getEmail();
		Integer age = getAge();


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
			CommonUI.displaySingleMessage("Sign up successfully!\n");
		} else {
	        CommonUI.displaySingleMessage("Movie goer already exist!\n");

		}
	}

    /**
     * This method controls signing in for the movie goer
     * @throws error
     */
    public static void movieGoerLogIn() throws Exception{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = input.nextLine();

        System.out.println("Enter password:");
        String password = input.nextLine();

        ArrayList<MovieGoer> movieGoerList = (ArrayList<MovieGoer>) Serialization.readSerializedObject(DataPath.MOVIEGOER);
        MovieGoer movieGoer = null;
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
			CommonUI.displaySingleMessage("Sign in successfully!\n");
	         MovieGoerUI.displayMovieGoerServicesUI(movieGoer);
		} else {
	         CommonUI.displaySingleMessage("Username or password is not valid!\n");
		}
	}
	
    /**
     * This method returns the username of the movie goer
     * @return the username of the movie goer
     */
	private static String getUsername() {
	    Scanner input = new Scanner(System.in);
	    CommonUI.displaySingleMessage("Enter username:");
	    String username = input.nextLine();
	    return username;
	}
	
	/**
     * This method returns the password of the movie goer
     * @return the password of the movie goer
     */
	private static String getPassword() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter password:");
        String password = input.nextLine();
        return password;
    }
	
	/**
     * This method returns the name of the movie goer
     * @return the name of the movie goer
     */
	private static String getName() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter name:");
        String name = input.nextLine();
        return name;
    }
	
	/**
     * This method returns the mobile number of the movie goer
     * @return the mobile number of the movie goer
     */
	private static String getMobile() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter mobile number:");
        String mobile = input.nextLine();
        return mobile;
    }
	
	/**
     * This method returns the email of the movie goer
     * @return the email of the movie goer
     */
	private static String getEmail() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter email:");
        String email = input.nextLine();
        return email;
    }
	
	/**
     * This method returns the age of the movie goer
     * @return the age of the movie goer
     */
	private static Integer getAge() {
        Scanner input = new Scanner(System.in);
        CommonUI.displaySingleMessage("Enter age:");
        Integer age = input.nextInt();
        return age;
    }
}
