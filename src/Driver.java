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
        Player p1 = new HumanTTT("X");
        Player p2 = new HumanTTT("O");
        boolean done = false;
        int count = 0;
        Board b = new TTTBoard();
        int c = 0;

        if(gameMode <= 3) {
            c = 9;
            b = new TTTBoard();
            if (gameMode == 1) {
                p1 = new HumanTTT("X");
            } else if (gameMode == 2) {
                p1 = new TTTPlayerBasicAI("X");
            } else if (gameMode == 3) {
                p1 = new TTTPlayerProAI("X");
            }
        }
        else{
            c = 42;
            b = new C4Board();
            p2 = new HumanC4("Y");
            if(gameMode == 4)
                p1 = new HumanC4("R");
            else if(gameMode == 5)
                p1 = new C4BasicAI("R");
        }
        Player player = p1;
        while(!done) {
            System.out.println(b);
            count++;
            if(player == p1) {
                b.placePiece(player.getMove(b), player.name);
            }
            if(player == p2) {
                b.placePiece(player.getMove(b), player.name);
            }
            if(count == c || b.isWinner(player.name) || b.isWinner(player.name)){
                System.out.println(b);
                if(b.isWinner(player.name))
                    System.out.println("Player " + player.name + " Wins!");
                else
                    System.out.println("Cats Game");
                done = true;
            }
            if(player == p1)
                player = p2;
            else
                player = p1;
        }
    }
}
