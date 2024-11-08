import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";
    private static boolean playAgain = false;
    private static Scanner pipe = new Scanner(System.in);
    private static int currentMove = 0;

    public static void main(String[] args) {

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

            } while (!moveValidated);

            if (currentPlayer.equalsIgnoreCase("X"))
            {
                board[rowMove][colMove] = "X";
                currentPlayer = "O";
                currentMove += 1;
            }
            else
            {
                board[rowMove][colMove] = "O";
                currentPlayer = "X";
                currentMove += 1;
            }
            if (currentMove == 9)
            {
                isTie();
            }


            display();
        }while (stillPlaying);

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
    /*main()
              display()
              output "It was a tie";
              output "Would you like to play again:"
              input playAgain
                if playAgain == true
                   clearBoard()
                   playAgain = false
                endIf

        return
     */
    private static boolean isTie()
    {
        display();
        System.out.println("The game was a tie!");
        playAgain = SafeInput.getYNConfirm(pipe ,"Would you like to play again" );


        if (playAgain == true)
        {
            clearBoard();
            playAgain = false;
        }
        return playAgain;
    }

}