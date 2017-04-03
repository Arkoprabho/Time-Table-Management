package com.ard.oosd.a;

/**
 * Contains methods to define the locations like the room number.
 */
public class Location {
    private String roomName;
    private int roomHashCode;

    /**
     * @return the room number of the current object.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the room number for the current object.\n
     * @param value the value of the room.
     */
    void setRoomName(String value) {
        roomName = value;
        roomHashCode = this.hashCode();
    }

    @Override
    public int hashCode() {
        return (92 * 29 + (this.roomName != null ? this.roomName.toLowerCase().hashCode() : 0));

    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        Location other = (Location) o;
        return other.roomHashCode == this.hashCode();
    }
}
