package entity;

import java.io.Serializable;

/**
 * This class contains all the information of a movie goer
 */

public class MovieGoer implements Serializable {
	/**
	 * The username of the movie goer
	 */
	private String username;
	
	/**
	 * The password of the movie goer
	 */
	private String password;
	
	/**
	 * The name of the movie goer
	 */
	private String name;
	
	/**
	 * The mobile number of the movie goer
	 */
	private String mobile;
	
	/**
	 * The email address of the movie goer
	 */
	private String email;
	
	/**
	 * The age of the movie goer
	 */
	private Integer age;
	
	/**
     * This method creates a MobileGoer object with the given username, password, name, mobile, email and age
     */
	
	public MovieGoer(String username, String password, String name, String mobile, String email, Integer age) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.age = age;
	}
	
	/**
     * This method returns the username of the movie goer
     * @return the username of the movie goer
     */	
	public String getUsername() {
		return this.username;
	}
	
	/**
     * This method sets the username of the movie goer
     * @param username the new username of the movie goer
     */	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
     * This method returns the password of the movie goer
     * @return the password of the movie goer
     */	
	public String getPassword() {
		return this.password;
	}
	
	/**
     * This method sets the password of the movie goer
     * @param password the new password of the movie goer
     */	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
     * This method returns the name of the movie goer
     * @return the name of the movie goer
     */	
	public String getName() {
		return this.name;
	}
	
	/**
     * This method sets the name of the movie goer
     * @param name the new name of the movie goer
     */	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * This method returns the mobile of the movie goer
     * @return the mobile of the movie goer
     */	
	public String getMobile() {
		return this.mobile;
	}
	
	/**
     * This method sets the mobile of the movie goer
     * @param mobile the new mobile of the movie goer
     */	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
     * This method returns the email of the movie goer
     * @return the email of the movie goer
     */	
	public String getEmail() {
		return this.email;
	}
	
	/**
     * This method sets the email of the movie goer
     * @param email the new email of the movie goer
     */	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
     * This method returns the age of the movie goer
     * @return the age of the movie goer
     */	
	public Integer getAge() {
		return this.age;
	}
	
	/**
     * This method sets the age of the movie goer
     * @param age the new age of the movie goer
     */	
	public void setAge(Integer age) {
		this.age = age;
	}

}
