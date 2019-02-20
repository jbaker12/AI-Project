import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class TTTPlayerBasicAI extends Player {

    public TTTPlayerBasicAI(String str){
        super(str);
    }

    /**
     *
     * @param board the board of the game
     * @return the location the computer will move
     */
    public String getMove(Board board) {
        ArrayList<String> b = board.getEmptyLocs();
        for (int i = 0; i < b.size(); i++) {
            board.placePiece(b.get(i), "X");
            if (board.isWinner("X")) {
                board.retractPiece(b.get(i));
                return b.get(i);
            } else
                board.retractPiece(b.get(i));
        }

        for (int i = 0; i < b.size(); i++) {
            board.placePiece(b.get(i), "O");
            if (board.isWinner("O")) {
                board.retractPiece(b.get(i));
                return b.get(i);
            } else
                board.retractPiece(b.get(i));
        }
        Random r = new Random();
        int num = r.nextInt(b.size());
        return b.get(num);
    }
}
