import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        boolean playAgain = false;
        boolean moveValidated = false;
        boolean stillPlaying = true;
        Scanner pipe = new Scanner(System.in);
        int rowMove = 0;
        int colMove = 0;


        clearBoard();
        do {


            do {
                rowMove = SafeInput.getRangedInt(pipe, "Please type the row of your move player " + currentPlayer, 1, ROWS) - 1;
                colMove = SafeInput.getRangedInt(pipe, "Please type the column of your move player " + currentPlayer, 1, COLS) - 1;
                if (isValidMove(rowMove, colMove)) {

                    moveValidated = true;
                } else {
                    System.out.println("Invalid Location");
                    moveValidated = false;
                }
                if (currentPlayer.equalsIgnoreCase("X"))
                {
                    board[rowMove][colMove] = "X";
                    currentPlayer = "O";
                }
                else
                {
                    board[rowMove][colMove] = "O";
                    currentPlayer = "X";
                }
            } while (!moveValidated);


            display();
        }while (stillPlaying);
        //playAgain = SafeInput.getYNConfirm(pipe ,"Would you like to play again" );
    }


    /*main()
        for 0 to ROWS step 1
            output "| "
            for 0 to COLS step 1
              output board row,col + " | ";
            endFor
        endFor
        return
     */
    private static void display()
    {
        for (int i = 0; i < ROWS; i++)
        {
            System.out.printf("| ");
            for (int j = 0; j < COLS; j++)
            {

                System.out.printf(board[i][j] + " | ");

            }
            System.out.println();
        }
    }
    /*main()

            boolean validMove
        if board row,col == " "
        validMove = true
        endIf
      return
    */
    private static boolean isValidMove(int row, int col) {
         boolean validMove = false;

         if (board[row][col].equals(" "))
         {
             validMove = true;
         }

        return validMove;
    }
    /*main()
        for 0 to ROWS step 1
            for 0 to COLS step 1
              output " ";
            endFor
        endFor
        return
     */
    private static void clearBoard()
    {
        currentPlayer = "X";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }
    //private static boolean isWin(String player)
    {

    }

}