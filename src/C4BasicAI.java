import java.util.ArrayList;
import java.util.Random;

public class C4BasicAI extends Player {

    public C4BasicAI(String str){
        super(str);
    }

    public String getMove(Board board){
        ArrayList<String> b = board.getEmptyLocs();
        for (int i = 0; i < b.size(); i++) {
            board.placePiece(b.get(i), "R");
            if (board.isWinner("R")) {
                board.retractPiece(b.get(i));
                return b.get(i);
            } else
                board.retractPiece(b.get(i));
        }

        for (int i = 0; i < b.size(); i++) {
            board.placePiece(b.get(i), "Y");
            if (board.isWinner("Y")) {
                board.retractPiece(b.get(i));
                return b.get(i);
            } else
                board.retractPiece(b.get(i));
        }
        Random r = new Random();
        int num = r.nextInt(b.size());
        System.out.println("Computer Moved To: " + num);
        return b.get(num);
    }
}
