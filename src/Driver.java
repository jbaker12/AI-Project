import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1. Tic-Tac-Toe (Human vs Human)" +
                "\n2. Tic-Tac-Toe (Human vs Basic AI)" +
                "\n3. Tic-Tac-Toe (Human vs Pro AI)" +
                "\n4. Connect 4 (Human vs Human)" +
                "\n5. Connect 4 (Human vs Basic AI)" +
                "\n6. Connect 4 (Human vs Pro AI)" +
                "\nSelect your game (1-6): ");

        int gameMode = in.nextInt();

        if (gameMode == 1) {
            TTTBoard b = new TTTBoard();
            int count = 0;
            String player = "X";

            while (!b.isWinner(player)) {
                if (count%2 == 0)
                    player = "X";
                else
                    player = "O";
                count++;
                System.out.println("");
                System.out.print(b);
                System.out.print("Enter your move (1-9): ");
                int move = in.nextInt();
                b.placePiece(Integer.toString(move), player);
                if (b.isWinner(player)) {
                    System.out.println("");
                    System.out.print(b);
                    System.out.println("PLAYER " + player + " WINS");
                }
            }
        }

        if (gameMode == 2){
            TTTBoard b = new TTTBoard();
            TTTPlayerBasicAI p = new TTTPlayerBasicAI("X");
            int count = 0;
            while(!b.isWinner("X") && !b.isWinner("O") && count < 9){
                System.out.println("");
                System.out.println(b);
                System.out.print("Enter your move (1-9): ");
                int move = in.nextInt();
                b.placePiece(Integer.toString(move), "O");
                count++;
                if(count < 9){
                    System.out.println("");
                    System.out.println(b);
                    b.placePiece(p.getMove(b), "X");
                    System.out.println("Computer moved");
                    count++;
                    if (b.isWinner("X")) {
                        System.out.println("");
                        System.out.print(b);
                        System.out.println("PLAYER X WINS");
                    }
                }
                if(b.isWinner("O")){
                    System.out.println("");
                    System.out.println(b);
                    System.out.println("PLAYER O WINS");
                }
            }
        }

        if (gameMode == 3) {
            TTTBoard b = new TTTBoard();
            TTTPlayerProAI p = new TTTPlayerProAI("X");
            int count = 0;
            while(!b.isWinner("X") && !b.isWinner("O") && count < 9){
                System.out.println("");
                System.out.println(b);
                System.out.print("Enter your move (1-9): ");
                int move = in.nextInt();
                b.placePiece(Integer.toString(move), "O");
                count++;
                if(count < 9){
                    System.out.println("");
                    System.out.println(b);
                    b.placePiece(p.getMove(b), "X");
                    System.out.println("Computer moved");
                    count++;
                    if (b.isWinner("X")) {
                        System.out.println("");
                        System.out.print(b);
                        System.out.println("PLAYER X WINS");
                    }
                }
                if(b.isWinner("O")){
                    System.out.println("");
                    System.out.println(b);
                    System.out.println("PLAYER O WINS");
                }
            }
        }
    }
}