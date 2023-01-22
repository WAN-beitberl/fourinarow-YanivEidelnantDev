import java.util.Scanner;

class Main{  
    public static void main(String args[]){  
        Board board = new Board();
        Board.PlayerColor currentPlayer = Board.PlayerColor.RED;
        int Input = 1;
        Scanner myScanner = new Scanner(System.in);

        while(true)
        {
            System.out.print("\n\n");
            System.out.println("-------------");
            board.printBoard();
            System.out.println("-------------");
            if(currentPlayer == Board.PlayerColor.RED)
            {
                System.out.println("RED TURN!");
            }
            else
            {
                System.out.println("YELLOW TURN!");
            }
            Input = myScanner.nextInt();
            System.out.println("");
            board.insertToBoard(currentPlayer, Input-1);

            if(board.checkWin(currentPlayer))
            {
                break;
            }

            if(currentPlayer == Board.PlayerColor.RED)
            {
                currentPlayer = Board.PlayerColor.YELLOW;
            }
            else
            {
                currentPlayer = Board.PlayerColor.RED; 
            }
            

        }
        
        System.out.println("-------------");
        board.printBoard();
        System.out.println("-------------");
        System.out.println(currentPlayer + " WINS!\n");

        
        
    }

    
    
    
}  