package tests;

import model.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class ProgramTests {


    /**
     * Check a game is able to initialise with 6 players and draw a proper board
     *
     * @author Vaibhav Ekambaram
     */
    @Test
    public void checkGeneratedBoard() {
        String validBoard =
                "|x|x|x|x|x|x|x|x|x|3|x|x|x|x|4|x|x|x|x|x|x|x|x|x|\n" +
                        "|k|k|k|k|k|k|x|_|_|_|b|b|b|b|_|_|_|x|c|c|c|c|c|c|\n" +
                        "|k|_|_|_|_|k|_|_|b|b|b|_|_|b|b|b|_|_|c|_|_|_|_|c|\n" +
                        "|k|_|_|_|_|k|_|_|b|_|_|_|_|_|_|b|_|_|c|_|_|_|_|c|\n" +
                        "|k|_|_|_|_|k|_|_|b|_|_|_|_|_|_|b|_|_|v|c|_|_|c|c|\n" +
                        "|k|k|_|_|_|k|_|_|<|_|_|_|_|_|_|>|_|_|_|c|c|c|c|x|\n" +
                        "|x|k|k|k|v|k|_|_|b|_|_|_|_|_|_|b|_|_|_|_|_|_|_|5|\n" +
                        "|_|_|_|_|_|_|_|_|b|v|b|b|b|b|v|b|_|_|_|_|_|_|_|x|\n" +
                        "|x|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|i|i|i|i|i|i|\n" +
                        "|d|d|d|d|d|_|_|_|_|_|_|_|_|_|_|_|_|_|<|_|_|_|_|i|\n" +
                        "|d|_|_|_|d|d|d|d|_|_|x|x|x|x|x|_|_|_|i|_|_|_|_|i|\n" +
                        "|d|_|_|_|_|_|_|d|_|_|x|x|x|x|x|_|_|_|i|_|_|_|_|i|\n" +
                        "|d|_|_|_|_|_|_|>|_|_|x|x|x|x|x|_|_|_|i|i|i|i|v|i|\n" +
                        "|d|_|_|_|_|_|_|d|_|_|x|x|x|x|x|_|_|_|_|_|_|_|_|x|\n" +
                        "|d|_|_|_|_|_|_|d|_|_|x|x|x|x|x|_|_|_|l|l|^|l|l|x|\n" +
                        "|d|d|d|d|d|d|v|d|_|_|x|x|x|x|x|_|_|l|l|_|_|_|l|l|\n" +
                        "|x|_|_|_|_|_|_|_|_|_|x|x|x|x|x|_|_|<|_|_|_|_|_|l|\n" +
                        "|2|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|l|l|_|_|_|l|l|\n" +
                        "|x|_|_|_|_|_|_|_|_|h|h|^|^|h|h|_|_|_|l|l|l|l|l|x|\n" +
                        "|o|o|o|o|o|o|^|_|_|h|_|_|_|_|h|_|_|_|_|_|_|_|_|6|\n" +
                        "|o|_|_|_|_|_|o|_|_|h|_|_|_|_|>|_|_|_|_|_|_|_|_|x|\n" +
                        "|o|_|_|_|_|_|o|_|_|h|_|_|_|_|h|_|_|^|y|y|y|y|y|y|\n" +
                        "|o|_|_|_|_|_|o|_|_|h|_|_|_|_|h|_|_|y|_|_|_|_|_|y|\n" +
                        "|o|_|_|_|_|o|o|_|_|h|_|_|_|_|h|_|_|y|y|_|_|_|_|y|\n" +
                        "|o|o|o|o|o|o|x|1|x|h|h|h|h|h|h|x|_|x|y|y|y|y|y|y|\n";

        Game game = new Game(false);

        // check overall board
        assertEquals(validBoard, game.getBoard().toString());

        // check players are properly associated with board
        assertEquals("Miss Scarlett", game.getBoard().getPositions()[24][7].getCharacter().getCharacterName());
        assertEquals("Col. Mustard", game.getBoard().getPositions()[17][0].getCharacter().getCharacterName());
        assertEquals("Mrs. White", game.getBoard().getPositions()[0][9].getCharacter().getCharacterName());
        assertEquals("Mr. Green", game.getBoard().getPositions()[0][14].getCharacter().getCharacterName());
        assertEquals("Mrs. Peacock", game.getBoard().getPositions()[6][23].getCharacter().getCharacterName());
        assertEquals("Prof. Plum", game.getBoard().getPositions()[19][23].getCharacter().getCharacterName());
    }


    /**
     * Check Dice Throw updates moves remaining
     *
     * @author Vaibhav Ekambaram
     */
    @Test
    public void checkDiceResults() {
        Game game = new Game(false);
        int value = game.rollDice();
        assertEquals(game.getMovesRemaining(), value);
    }


    /**
     * Check player movement, including multiple points at once, including valid door position checker
     *
     * @author Vaibhav Ekambaram
     */
    @Test
    public void checkMovement() {
        String validBoard =
                "|x|x|x|x|x|x|x|x|x|3|x|x|x|x|4|x|x|x|x|x|x|x|x|x|\n" +
                        "|k|k|k|k|k|k|x|_|_|_|b|b|b|b|_|_|_|x|c|c|c|c|c|c|\n" +
                        "|k|_|_|_|_|k|_|_|b|b|b|_|_|b|b|b|_|_|c|_|_|_|_|c|\n" +
                        "|k|_|_|_|_|k|_|_|b|_|_|_|_|_|_|b|_|_|c|_|_|_|_|c|\n" +
                        "|k|_|_|_|_|k|_|_|b|_|_|_|_|_|_|b|_|_|v|c|_|_|c|c|\n" +
                        "|k|k|_|_|_|k|_|_|<|_|_|_|_|_|_|>|_|_|_|c|c|c|c|x|\n" +
                        "|x|k|k|k|v|k|_|_|b|_|_|_|_|_|_|b|_|_|_|_|_|_|_|5|\n" +
                        "|_|_|_|_|_|_|_|_|b|v|b|b|b|b|v|b|_|_|_|_|_|_|_|x|\n" +
                        "|x|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|i|i|i|i|i|i|\n" +
                        "|d|d|d|d|d|_|_|_|_|_|_|_|_|_|_|_|_|_|<|_|_|_|_|i|\n" +
                        "|d|_|_|_|d|d|d|d|_|_|x|x|x|x|x|_|_|_|i|_|_|_|_|i|\n" +
                        "|d|_|_|_|_|_|_|d|_|_|x|x|x|x|x|_|_|_|i|_|_|_|_|i|\n" +
                        "|d|_|_|_|_|_|_|>|_|_|x|x|x|x|x|_|_|_|i|i|i|i|v|i|\n" +
                        "|d|_|_|_|_|_|_|d|_|_|x|x|x|x|x|_|_|_|_|_|_|_|_|x|\n" +
                        "|d|_|_|_|_|_|_|d|_|_|x|x|x|x|x|_|_|_|l|l|^|l|l|x|\n" +
                        "|d|d|d|d|d|d|v|d|_|_|x|x|x|x|x|_|_|l|l|_|_|_|l|l|\n" +
                        "|x|_|_|_|_|_|_|_|_|_|x|x|x|x|x|_|_|<|_|_|_|_|_|l|\n" +
                        "|2|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|l|l|_|_|_|l|l|\n" +
                        "|x|_|_|_|_|_|_|_|_|h|h|^|^|h|h|_|_|_|l|l|l|l|l|x|\n" +
                        "|o|o|o|o|o|o|1|_|_|h|_|_|_|_|h|_|_|_|_|_|_|_|_|6|\n" +
                        "|o|_|_|_|_|_|o|_|_|h|_|_|_|_|>|_|_|_|_|_|_|_|_|x|\n" +
                        "|o|_|_|_|_|_|o|_|_|h|_|_|_|_|h|_|_|^|y|y|y|y|y|y|\n" +
                        "|o|_|_|_|_|_|o|_|_|h|_|_|_|_|h|_|_|y|_|_|_|_|_|y|\n" +
                        "|o|_|_|_|_|o|o|_|_|h|_|_|_|_|h|_|_|y|y|_|_|_|_|y|\n" +
                        "|o|o|o|o|o|o|x|_|x|h|h|h|h|h|h|x|_|x|y|y|y|y|y|y|\n";

        Game game = new Game(false);
        game.setMovesRemaining(9);
        game.movementInput(new Move(Move.Direction.UP, 3));

        // check moves remaining depletion
        assertEquals(6, game.getMovesRemaining());
        game.movementInput(new Move(Move.Direction.UP, 2));

        // check invalid wall does not succeed and thus does not reduce the moves remaining
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        assertEquals(4, game.getMovesRemaining());

        game.movementInput(new Move(Move.Direction.UP, 1));
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        game.movementInput(new Move(Move.Direction.DOWN, 1));

        // check 1 room remaining
        assertEquals(1, game.getMovesRemaining());
        assertEquals(validBoard, game.getBoard().toString());
    }

    /**
     * Check room associations with tiles and the connection with the current player
     */
    @Test
    public void checkMovementRoom() {
        Game game = new Game(false);
        game.setMovesRemaining(9);
        game.movementInput(new Move(Move.Direction.UP, 3));
        game.movementInput(new Move(Move.Direction.UP, 2));

        // validate current tile is not a room
        assertNull(game.getCurrentPlayer().getCurrentPosition().getRoom());

        game.movementInput(new Move(Move.Direction.UP, 1));
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        game.movementInput(new Move(Move.Direction.DOWN, 1));
        assertEquals("Lounge", game.getCurrentPlayer().getCurrentPosition().getRoom().toString());
    }


    /**
     * Tests if the player can finish their movements without using all of them
     *
     * @author Baxter Kirikiri
     */
    @Test
    public void checkFinishMoves() {
        Game game = new Game(false);
        game.setMovesRemaining(9);
        game.movementInput(new Move(Move.Direction.UP, 3));
        game.actionTransition();

        assertEquals(7, game.getCurrentPlayer().getCurrentPosition().getLocationX());
        assertEquals(21, game.getCurrentPlayer().getCurrentPosition().getLocationY());
        assertEquals(-1, game.getMovesRemaining());
    }

    /**
     * Tests if the player can no longer accuse after making a false accusation
     *
     * @author Baxter Kirikiri
     */
    @Test
    public void failedAccusation() {
        Game game = new Game(false);
        game.setMovesRemaining(2);
        game.actionTransition();
        game.setMurderScenario(new Scenario((WeaponCard) game.getWeaponCardsMap().get("Dagger"), (RoomCard) game.getRoomCardsMap().get("Conservatory"), (CharacterCard) game.getCharacterCardsMap().get("Col. Mustard")));

        assertTrue(game.getCurrentPlayer().getCanAccuse());

        game.makeAccusation(game.getCurrentPlayer(), "Miss Scarlett" + "\t" + "Candlestick" + "\t" + "Library");

        assertFalse(game.getCurrentPlayer().getCanAccuse());
    }

    /**
     * Tests if the player wins the game after a correct accusation
     *
     * @author Baxter Kirikiri
     */
    @Test
    public void correctAccusation() {
        Game game = new Game(false);
        game.setMovesRemaining(2);
        game.actionTransition();
        game.setMurderScenario(new Scenario((WeaponCard) game.getWeaponCardsMap().get("Candlestick"), (RoomCard) game.getRoomCardsMap().get("Library"), (CharacterCard) game.getCharacterCardsMap().get("Miss Scarlett")));
        game.finishTransition();
        game.makeAccusation(game.getCurrentPlayer(), "Miss Scarlett" + "\t" + "Candlestick" + "\t" + "Library");
        assertEquals(Game.States.FINISHED, game.getGameState());
    }

    /**
     * Check player is unable to make suggestion if not located within a room time
     *
     * @author Vaibhav Ekambaram
     */
    @Test
    public void cantMakeSuggestion() {
        Game game = new Game(false);
        game.setMovesRemaining(2);
        game.actionTransition();
        int value = game.makeSuggestion(game.getCurrentPlayer(), null, null, -1);
        assertEquals(-1, value);
    }

    /**
     * Check player is able to make suggestion if located within a room time
     *
     * @author Baxter Kirikiri
     */
    @Test
    public void suggestionCouldNotRefute() {
        Game game = new Game(false);
        game.setMovesRemaining(9);
        game.movementInput(new Move(Move.Direction.UP, 5));
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        game.movementInput(new Move(Move.Direction.UP, 1));
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        game.movementInput(new Move(Move.Direction.DOWN, 1));
        game.actionTransition();

        assertEquals("Lounge", game.getCurrentPlayer().getCurrentPosition().getRoom().toString());

        String[] refutationPresets = {"-1", "-1", "-1", "-1", "-1"};

        int value = game.makeSuggestion(game.getCurrentPlayer(), "Col. Mustard" + "\t" + "Dagger", refutationPresets, -1);

        assertEquals(0, value);
    }

    /**
     * Check player is able to make suggestion if located within a room time
     *
     * @author Baxter Kirikiri
     */
    @Test
    public void suggestionRefute() {
        Game game = new Game(false);
        game.setMovesRemaining(9);
        game.movementInput(new Move(Move.Direction.UP, 5));
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        game.movementInput(new Move(Move.Direction.UP, 1));
        game.movementInput(new Move(Move.Direction.LEFT, 1));
        game.movementInput(new Move(Move.Direction.DOWN, 1));
        game.actionTransition();

        assertEquals("Lounge", game.getCurrentPlayer().getCurrentPosition().getRoom().toString());

        String[] refutationPresets = {"-1", "Dagger", "-1", "-1", "-1"};

        int value = game.makeSuggestion(game.getCurrentPlayer(), "Col. Mustard" + "\t" + "Dagger", refutationPresets, -1);

        assertEquals(1, value);
    }
}
