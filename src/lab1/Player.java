/*
There are 2 types of comments in Java: single line and multi-line. Comments
must be added to those parts of a program that are complex or for which an
explanation would help understand what the program does and how it works.
*/
package lab1;

public class Player {
    private String name;
    private String position;
    private int jerseyNum;

    /**
     * Creates a player object to store information about a player
     * @author Michael Quick
     * @param theName The name of the player
     * @param thePosition The position the player plays
     * @param theJersey The number of the players jersey
     */
    public Player(String theName, String thePosition, int theJersey) {
        name = theName;
        position = thePosition;
        jerseyNum = theJersey;
    }

    /**
     * Get the name stored in the player object
     * @author Michael Quick
     * @return Returns the name of the player
     */
    public String getName() {
        // Get the player's name
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setPosition(String newPosition) {
        position = newPosition;
    }

    public void setJerseyNum(int newJersey) {
        jerseyNum = newJersey;
    }
}
