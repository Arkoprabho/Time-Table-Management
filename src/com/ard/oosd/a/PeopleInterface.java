package com.ard.oosd.a;

/**
 * @author Arko<br>
 * Contains a basic blueprint of how a person implementing this interface should be like
 */
public interface PeopleInterface {
    // TODO Further functionalities are to be added as they seem necessary.

    /**
     * Sets the type of user.
     */
    void setTypeOfUser();

    /**
     * @return the type of user.
     */
    TypeOfUser getTypeOfUser();

    /**
     * Logs the user into the application
     */
    void login();
}
