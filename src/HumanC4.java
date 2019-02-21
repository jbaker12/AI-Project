import java.util.Scanner;

public class HumanC4 extends Player{
    public HumanC4(String str){
        super(str);
    }

    public String getMove(Board board){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your move (1-7): ");
        String move = in.nextLine();
        return move;
    }

}
