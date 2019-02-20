import java.util.Scanner;

public class Driver2 {
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
        Player p1 = new HumanTTT("X");
        Player p2 = new HumanTTT("O");
        boolean done = false;
        int count = 0;
        Board b = new TTTBoard();

        if(gameMode <= 3) {
            b = new TTTBoard();
            if (gameMode == 1) {
                p1 = new HumanTTT("X");
            } else if (gameMode == 2) {
                p1 = new TTTPlayerBasicAI("X");
            } else if (gameMode == 3) {
                p1 = new TTTPlayerProAI("X");
            }
        }
        Player player = p1;
        while(!done) {
            System.out.println(b);
            //player = p1;
            //player.getMove(b);
            count++;
            if(player == p1) {
                b.placePiece(player.getMove(b), "X");
            }
            if(player == p2) {
                b.placePiece(player.getMove(b), "O");
            }

            if(count == 9 || b.isWinner("X") || b.isWinner("O")){
                System.out.println(b);
                if(b.isWinner("X"))
                    System.out.println("Player X Wins!");
                else if(b.isWinner("O"))
                    System.out.println("Player O Wins!");
                else
                    System.out.println("Cats Game");
                done = true;
            }
            if(player == p1){
                player = p2;
            }
            else if(player == p2){
                player = p1;
            }

        }



    }
}
