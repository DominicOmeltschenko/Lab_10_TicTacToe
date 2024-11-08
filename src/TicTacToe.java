import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";
    private static boolean playAgain = false;
    private static Scanner pipe = new Scanner(System.in);
    private static int currentMove = 0;

    /*
    main()

        boolean moveValidated = false
        boolean stillPlaying = true
        int rowMove = 0
        int colMove = 0

        do
            do
               output "please type the row of your move player" + currentPlayer
               input rowMove
               output "please type the column of your move player" + currentPlayer
               input colMove
               VALIDATEMOVE
             while (NOT moveValidated)
           if currentPlayer == "x"
                board row,col = "x"
                currentMove = currentMove + 1
           else
                board row,col = "o"
                currentMove = currentMove + 1
           end if
           if currentMove >= 5
                isWin input currentPlayer
           endIf
           if currentMove = 9 // since this is called after the previous code, if someone wins on the 9th turn, the board will be cleared, so there won't be any accidental ties
                isTie()
           endIf


           if currentPlayer = "X"

                currentPlayer = "O"

            else

                currentPlayer = "X"
            endIf
            display()
           while(stillPlaying)




    */

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
               moveValidated = isValidMove(rowMove, colMove);

            } while (!moveValidated);

            if (currentPlayer.equalsIgnoreCase("X"))
            {
                board[rowMove][colMove] = "X";
                currentMove += 1;
            }
            else
            {
                board[rowMove][colMove] = "O";
                currentMove += 1;
            }
            if (currentMove >= 5)
            {
               isWin(currentPlayer);
            }
            if (currentMove == 9)
            {
                isTie();
            }
            // after you play, it checks if you are x, if you are switch to o, if you aren't switch to x

            if (currentPlayer.equalsIgnoreCase("X"))
            {
                currentPlayer = "O";
            }
            else
            {
                currentPlayer = "X";
            }
            display();
        }while (stillPlaying);

    }


    /*display()
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
    /*isValidMove()

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
         else
         {
             System.out.println("Invalid Move");
         }

        return validMove;
    }
    /*clearBoard()
        for 0 to ROWS step 1
            for 0 to COLS step 1
              output " ";
            endFor
        endFor
        return
     */
    private static void clearBoard()
    {
        currentMove = 0;
        currentPlayer = "X";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }

    }

    /*isWin()
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
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            display();
            System.out.println(currentPlayer + " won! Congratulations!");
            playAgain = SafeInput.getYNConfirm(pipe ,"Would you like to play again" );
            clearBoard();
            return true;
        }
        return false;
    }

    /*isColWin()
        for 0 to COLS step 1
            if board 2 , col == currentPlayer AND board 2 , col == currentPlayer AND board 3 , col == currentPlayer
               return true
            end if
        endFor
        return false
        return
     */
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COLS; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    /*isRowWin()
        for 0 to ROWS step 1
            if board row , 1 == currentPlayer AND board row , 2 == currentPlayer AND board row , 3 == currentPlayer
               return true
            end if
        endFor
        return false
        return
     */
    private static boolean isRowWin(String player)
    {

        for(int row=0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    /*isDiagonalWin()
        for 0 to ROWS step 1
            if board row , 1 == currentPlayer AND board row , 2 == currentPlayer AND board row , 3 == currentPlayer
               return true
            end if
        endFor
        return false
        return
     */
    private static boolean isDiagonalWin(String player) {

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }

        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }




    /*isTie()
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