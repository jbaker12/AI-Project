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
    public String getMove(Board board){
        boolean canWin = false;

        for(int i = 0; i < 3; i++){
            //Checks if bot can win vertically
            if(board.streakInCol(i, "X", 2 )){
                for(int r = 0; r < 3; r++){
                    if(!board.get(r, i).equals("X") && !board.get(r, i).equals("O"))
                        return Integer.toString((r*3) + i + 1);
                }
            }
            //Checks if bot can win horizontally
            if(board.streakInRow(i, "X", 2)){
                for(int c = 0; c < 3; c++){
                    if(!board.get(i,c).equals("X") && !board.get(i,c).equals("O"))
                        return Integer.toString((i*3) + c + 1);
                }
            }
        }
        //Checks if bot can win in / direction
        if(board.streakInNorthEastDiag(2,0,"X",2)){
            if(board.get(2,0).equals("7"))
                return "7";
            if(board.get(1, 1).equals("5"))
                return "5";
            if(board.get(0, 2).equals("3"))
                return "3";
        }
        //Checks if bot can win in \ direction
        if(board.streakInSouthEastDiag(0,0,"X", 2)){
            if(board.get(0,0).equals("1"))
                return "1";
            if(board.get(1,1).equals("5"))
                return "5";
            if(board.get(2, 2).equals("9"))
                return "9";
        }

        //No move that makes the bot win
        //Check if human can win (bot will block)
        for(int i = 0; i < 3; i++){
            //Checks if bot can win vertically
            if(board.streakInCol(i, "O", 2 )){
                for(int r = 0; r < 3; r++){
                    if(!board.get(r, i).equals("X") && !board.get(r, i).equals("O"))
                        return Integer.toString((r*3) + i + 1);
                }
            }
            //Checks if bot can win horizontally
            if(board.streakInRow(i, "O", 2)){
                for(int c = 0; c < 3; c++){
                    if(!board.get(i,c).equals("X") && !board.get(i,c).equals("O"))
                        return Integer.toString((i*3) + c + 1);
                }
            }
        }
        //Checks if bot can win in / direction
        if(board.streakInNorthEastDiag(2,0,"O",2)){
            if(board.get(2,0).equals("7"))
                return "7";
            if(board.get(1, 1).equals("5"))
                return "5";
            if(board.get(0, 2).equals("3"))
                return "3";
        }
        //Checks if bot can win in \ direction
        if(board.streakInSouthEastDiag(0,0,"O", 2)){
            if(board.get(0,0).equals("1"))
                return "1";
            if(board.get(1,1).equals("5"))
                return "5";
            if(board.get(2, 2).equals("9"))
                return "9";
        }
        boolean done = false;
        while(!done){
            Random ran = new Random();
            int r = ran.nextInt(3);
            int c = ran.nextInt(3);
            if(!board.get(r,c).equals("X") && !board.get(r,c).equals("O")){
                return Integer.toString((r*3)+ c + 1);
            }

        }
        System.out.println("Computer Moved");
        return "1";
    }
}
