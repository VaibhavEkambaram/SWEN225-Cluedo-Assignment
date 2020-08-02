/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


// line 100 "model.ump"
// line 190 "model.ump"
public class Position {

    //------------------------
    // MEMBER VARIABLES
    //------------------------


    //Position Attributes
    private CharacterCard character;
    private Room inRoom;
    private String displayName = "_";

    private boolean isRoom = false;
    private boolean passableTile;
    private boolean canMove;

    private int xLoc;
    private int yLoc;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Position(Room aInRoom, boolean aPassableTile, int x, int y) {
        inRoom = aInRoom;
        passableTile = aPassableTile;
        displayName = x + ", " + y;
        xLoc = x;
        yLoc = y;
    }

    // Default Constructor
    public Position(int x, int y, boolean canMove) {
        this.xLoc = x;
        this.yLoc = y;
        this.canMove = canMove;
        if (!canMove) {
            this.displayName = "x";
        }
    }

    // Character Position Constructor
    public Position(int x, int y, boolean canMove, CharacterCard character) {
        this.xLoc = x;
        this.yLoc = y;
        this.canMove = canMove;
        this.character = character;

        this.displayName = character.getCharacterBoardChar();
    }

    // Room Position Constructor
    public Position(int x, int y, boolean canMove, boolean passableTile, boolean isShow, Room inRoom) {
        this.xLoc = x;
        this.yLoc = y;
        this.canMove = canMove;
        this.inRoom = inRoom;
        this.isRoom = true;
        this.passableTile = passableTile;
        // Check for door or outer wall
        if (this.passableTile == false) {
            this.displayName = inRoom.getRoomChar().toLowerCase();
        } else if (isShow) {
            this.displayName = "z";
        }
    }


    //------------------------
    // INTERFACE
    //------------------------

    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfBoards() {
        return 0;
    }

    public boolean setInRoom(Room aInRoom) {
        boolean wasSet = false;
        inRoom = aInRoom;
        wasSet = true;
        return wasSet;
    }

    public boolean setPassableTile(boolean aPassableTile) {
        boolean wasSet = false;
        passableTile = aPassableTile;
        wasSet = true;
        return wasSet;
    }

    public boolean setDisplayName(String aDisplayName) {
        boolean wasSet = false;
        displayName = aDisplayName;
        wasSet = true;
        return wasSet;
    }

    public boolean setIsRoom(boolean aIsRoom) {
        boolean wasSet = false;
        isRoom = aIsRoom;
        wasSet = true;
        return wasSet;
    }

    public Room getInRoom() {
        return inRoom;
    }

    /**
     * Not quite sure we will need this as the Room card should store this information for us, instead of individual tiles.
     * CharacterCard hasCharacter;
     * WeaponCard hasWeapon;
     */
    public boolean getPassableTile() {
        return passableTile;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean getIsRoom() {
        return isRoom;
    }

    /* Code from template attribute_IsBoolean */
    public boolean isIsRoom() {
        return isRoom;
    }

    public int getxLoc() {
        return xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }


    public String toString() {
        return this.displayName;
    }
}