import java.util.ArrayList;

public class C4Board extends Board {
    // Constants
    public static final int ROWS = 6;
    public static final int COLS = 7;

    /**
     * Constructs a 3x3 board for Tic Tac Toe and initializes
     * the board in the following format:
     * 123
     * 456
     * 789
     */
    public C4Board() {
        super(ROWS, COLS);

        int count = 1;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                set(r, c, "" + count);
                count++;
            }
        }
    }

    /**
     * Places a player piece on the board at the given location.
     * @param loc the location to place the piece
     * @param player the player making the move
     */
    public void placePiece(String loc, String player) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (theBoard[r][c].equals(loc))
                    theBoard[r][c] = player;
            }
        }
    }

    /**
     * Retracts the piece at the given location.
     * @param loc the location to reset
     */
    public void retractPiece(String loc) {
        int currentLoc = 1;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (String.valueOf(currentLoc).equals(loc))
                    theBoard[r][c] = loc;

                currentLoc++;
            }
        }
    }

    /**
     * Returns the empty locations on the
     */
    public ArrayList<String> getEmptyLocs() {
        ArrayList<String> empty = new ArrayList<>();

        for(int r = 0; r < theBoard.length; r++) {
            for(int c = 0; c < theBoard[0].length; c++) {
                if(!theBoard[r][c].equals("R") && !theBoard[r][c].equals("Y"))
                    empty.add((String) theBoard[r][c]);
            }
        }

        return empty;
    }

    /**
     * Returns true if the given player wins the game in the
     * current state, false otherwise
     * @param player the player to check for a win
     */
    public boolean isWinner(String player) {

        // check rows for streak
        for(int i = 0; i < getRows(); i++) {
            if (streakInRow(i, player, 4) || streakInCol(i, player, 4))
                return true;
        }

        for (int r = 3; r < 6; r++){
            for(int c = 0; c <= 3; c++){
                if(streakInNorthEastDiag(r, c, player, 4))
                    return true;
                if(streakInSouthEastDiag(c, r, player, 4))
                    return true;
            }

        }
        return false;
    }

    /**
     * Returns true if the game is over, false otherwise
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        if(isWinner("R") || !isWinner("Y") || getEmptyLocs().size() == 0)
            return true;
        else
            return false;

    }

    public String toString(){
        String toReturn = "1234567\n";

        for(int r = 0; r < theBoard.length; r++) {
            for(int c = 0; c < theBoard[0].length; c++) {
                toReturn += theBoard[r][c];
            }

            toReturn += "\n";
        }

        return toReturn;
    }

}
