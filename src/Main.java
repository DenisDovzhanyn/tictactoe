import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
     char[][] board = new char[3][3];

    static boolean isPlayer1 = true;


    static int player1Score;
    static int player2Score;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main game = new Main();
        boolean wantToPlay = true;

        while(wantToPlay) {


            game.resetBoard();
            game.printBoard();

            // 9 is the max possible turns in tic tac toe
            for (int turn = 0; turn < 9; turn++) {
                System.out.println("It is currently " + game.getCurrentPlayerTurn() + "s turn");

                game.getPlayerInput(input);

                game.printBoard();
                if (game.didYouWin()) {
                    System.out.println("Player ones score: " + player1Score);
                    System.out.println("Player twos score: " + player2Score);
                    break;
                }
                isPlayer1 = !isPlayer1;

                // if enough turns have gone by and a winner has not been chosen, it will be a draw
                if (turn == 8 && game.didYouWin() == false) {
                    System.out.println("No one wins!");
                }

            }
            // gives user the option to stop playing otherwise code will run forever
            System.out.println("If you would like to stop playing please input 1, otherwise input any other number to play another game");
            int willKeepPlaying = input.nextInt();
            if (willKeepPlaying == 1){
                wantToPlay = false;
            }
        }
    }

    public void getPlayerInput(Scanner scanner){
        int row = 0;
        int col = 0;
        boolean repeat = true;

        do {
            // checks to see if input is out of bounds or if they did not enter the number correctly, if it is, will run while loop

            while (repeat){
                System.out.println("Please choose a row from 1 to 3");
            try {
                row = scanner.nextInt() - 1;
                while (row < 0 || row > 2) {
                    System.out.println("That is not between 1 and 3! Please input a correct row");
                    row = scanner.nextInt() - 1;
                }
                repeat = false;
            } catch (InputMismatchException letter){
                System.out.println("Please enter your number using digits");
                scanner.next();
                }
            }

            repeat = true;

            while (repeat){
                System.out.println("Now please choose a column from 1 to 3");
                try {
                    col = scanner.nextInt() - 1;
                    while (col < 0 || col > 2) {
                        System.out.println("That is not between 1 and 3! Please input a correct column");
                        col = scanner.nextInt() - 1;

                    }
                    repeat = false;
                } catch (InputMismatchException letter){
                    System.out.println("Please enter your number using digits");
                    scanner.next();
                }
            }

            // checks to see if a player has claimed the spot, otherwise will loop until un-unclaimed spot is chosen
            if (board[row][col] != '-') {
                System.out.println("A player already has claimed that spot!");
            }
            repeat = true;

        } while (board[row][col] != '-');

        setBoard(row, col);
    }


    public void resetBoard() {
        // fills board with ' - ' to show that it is empty

        for (int i = 0; i < board.length; i++) {
            for (int o = 0; o < board.length; o++) {
                board[i][o] = '-';
            }
        }

    }

    public void printBoard(){
        // prints the whole board by iterating through one row at a time, using a nested for loop
        System.out.print("  1 2 3");
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            System.out.print((i + 1) + " ");
            for (int o = 0; o < board.length; o++) {
                System.out.print(board[i][o] + " ");
            }
        }
        System.out.println();
    }

    public void setBoard(int row , int col){
        // using user inputs to update the tictactoe board
        if (isPlayer1){
            board[row][col] = 'x';
        }else {
            board[row][col] = 'o';
        }

    }



    public String getCurrentPlayerTurn(){
        // checks to see whos turn it is
        if (isPlayer1){
            return "Player one";
        } else {
            return  "Player two";
        }
    }

    public boolean didYouWin(){

        // checks each row for a winner
        for (int a = 0; a < board.length ; a++){
            if (board[a][0] == board[a][1] && board[a][1] == board[a][2] && board[a][0] != '-'){
                if (board[a][0] == 'x'){
                    onGameWin();
                    return true;
                }else {
                    onGameWin();
                    return true;
                }
            }
        }

        // checks each column for a winner
        for (int b = 0; b < board.length ; b++){
            if (board[0][b] == board[1][b] && board[1][b] == board[2][b] && board[0][b] != '-'){
                if (board[0][b] == 'x'){
                    onGameWin();
                    return true;
                } else {
                    onGameWin();
                    return true;
                }
            }
        }

        // these two if statements check for diagonal winners
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
            if (board[0][0] == 'x') {
                    onGameWin();
                    return true;
            } else {
                    onGameWin();
                    return true;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'){
            if (board[0][2] == 'x') {
                onGameWin();
                return true;
            } else {
                onGameWin();
                return true;
            }
        }
        return false;
    }

    // if a player wins when checking the board, will print out winner and add to their score
    public void onGameWin(){
        System.out.println(getCurrentPlayerTurn() + " wins!!!");
        if (getCurrentPlayerTurn().equals("Player one")){
            player1Score++;
        }else {
            player2Score++;
        }

    }


}