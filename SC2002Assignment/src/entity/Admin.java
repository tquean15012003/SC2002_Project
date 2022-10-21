package entity;

import java.util.Scanner;
import java.io.Serializable;

/**
 * This class contains all the information of a admin
 */

public class Admin implements Serializable {
	/**
	 * The username of the admin
	 */
	private String username;
	
	/**
	 * The password of the admin
	 */
	private String password;
	
	/**
	 * The name of the admin
	 */
	private String name;
	
	/**
     * This method creates a Admin object with the given username, password and name
     * @param username the username of the admain
     * @param password the password of the admin
     * @param name the name of the admin
     */
	public Admin() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter username:");
		this.username = input.nextLine();
		
		System.out.println("Enter password:");
		this.password = input.nextLine();
		
		System.out.println("Enter your name:");
		this.password = input.nextLine();
			
	}
	
	/**
     * This method returns the username of the admin
     * @return the username of the admin
     */	
	public String getUsername() {
		return this.username;
	}
	
	/**
     * This method sets the username of the admin
     * @param username the new username of the admin
     */	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
     * This method returns the password of the admin
     * @return the password of the admin
     */	
	public String getPassword() {
		return this.password;
	}
	
	/**
     * This method sets the password of the admin
     * @param password the new password of the admin
     */	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
     * This method returns the name of the admin
     * @return the name of the admin
     */	
	public String getName() {
		return this.name;
	}
	
	/**
     * This method sets the name of the admin
     * @param name the new name of the admin
     */	
	public void setName(String name) {
		this.name = name;
	}

}
