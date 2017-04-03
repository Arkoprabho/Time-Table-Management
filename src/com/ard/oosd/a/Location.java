package com.ard.oosd.a;

/**
 * Created by arko on 04-04-2017.
 */
public class Location {
    private String name;
    private int id;
    private Coordinates coordinates;

    /**
     * Initializes a new instance of the class
     * @param name the name of the room
     * @param x coordinate
     * @param y coordinate
     */
    Location(String name, int x, int y) {
        this.name = name;
        coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);
    }

    /**
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id of the room
     */
    public int getId() {
        return id;
    }

    /**
     * @return the coordinates of the room
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public int hashCode() {
        id = name.toLowerCase().hashCode();
        return id;
    }
}

/**
 * Class that holds the coordinates of the location
 */
class Coordinates{
    private int x, y;

    /**
     * Initializes a new instance of the coordinates
     */
    Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of x coordinate
     * @param x value to set.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of y coordinate
     * @param y value to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
