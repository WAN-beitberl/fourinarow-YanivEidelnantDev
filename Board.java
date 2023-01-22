public class Board {
    public enum PlayerColor{ 
        ZERO, RED, YELLOW
    };
    private static final int BOARD_WIDTH  = 7;
    private static final int BOARD_HEIGHT = 6;

    private PlayerColor[][] board = new PlayerColor[BOARD_HEIGHT][BOARD_WIDTH];

    public Board()
    {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                this.board[i][j] = PlayerColor.ZERO;
            }
        }
    }

    public boolean checkWin(PlayerColor color)
    {
        // Vectical
        for (int i = 0; i < this.BOARD_HEIGHT-3; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if(this.board[i][j] == color &&
                this.board[i+1][j] == color &&
                this.board[i+2][j] == color &&
                this.board[i+3][j] == color)
                {
                    return true;
                }
            }
        }

        // Horizontal
        for (int j = 0; j < BOARD_WIDTH-3; j++) {
            for (int i = 0; i < BOARD_HEIGHT; i++) {
                if(this.board[i][j] == color &&
                this.board[i][j+1] == color &&
                this.board[i][j+2] == color &&
                this.board[i][j+3] == color)
                {
                    return true;
                }
            }
        }

        // Asc Horizontal
        for (int i = 3; i < this.BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH-3; j++) {
                if(this.board[i][j] == color &&
                this.board[i-1][j+1] == color &&
                this.board[i-2][j+2] == color &&
                this.board[i-3][j+3] == color)
                {
                    return true;
                }
            }
        }

        // Desc Horizontal
        for (int i = 3; i < this.BOARD_HEIGHT; i++) {
            for (int j = 3; j < BOARD_WIDTH; j++) {
                if(this.board[i][j] == color &&
                this.board[i-1][j-1] == color &&
                this.board[i-2][j-2] == color &&
                this.board[i-3][j-3] == color)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public void printBoard()
    {
        for (int i = 0; i < this.BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if(this.board[i][j] == PlayerColor.RED)
                {
                    System.out.print("R ");
                }
                else if(this.board[i][j] == PlayerColor.YELLOW)
                {
                    System.out.print("Y ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public void insertToBoard(PlayerColor color, int column)
    {
        if(this.board[0][column] != PlayerColor.ZERO)
        {
            return;
        }
        for (int i = 0; i < BOARD_HEIGHT-1; i++) {
            if(this.board[i+1][column] != PlayerColor.ZERO)
            {
                this.board[i][column] = color;
                return;
            }
        }
        this.board[BOARD_HEIGHT-1][column] = color;
    }

}
