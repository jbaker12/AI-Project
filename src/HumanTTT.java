import java.util.Scanner;

public class HumanTTT extends Player{

    public HumanTTT(String str){
        super(str);
    }

    public String getMove(Board board){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your move (1-9): ");
        String move = in.nextLine();
        return move;
    }
}
