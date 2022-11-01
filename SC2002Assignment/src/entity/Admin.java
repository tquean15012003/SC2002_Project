package entity;

import java.io.Serializable;

/**
 * This class contains all the information of a admin
 */

public class Admin extends Account implements Serializable {

    /**
     * This method creates a Admin object with the given username, password and name
     * @param username the username of the admain
     * @param password the password of the admin
     * @param name the name of the admin
     */
    public Admin(String username, String password, String name) {
        super.setUsername(username);
        super.setPassword(password);
        super.setName(name);   
    }
    
}