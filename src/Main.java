import java.util.Scanner;

public class Main {
     char[][] board = new char[3][3];

    static boolean isPlayer1 = true;

    static int player1Score;
    static int player2Score;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main game = new Main();


        game.resetBoard();
        game.printBoard();

        for (int turn = 0; turn < 9 ; turn++){
            System.out.println("It is currently " + game.whoTurn());

            game.getPlayerInput(input);

            game.printBoard();
            if (game.didYouWin() == true){
                System.out.println("Player ones score: " + player1Score);
                System.out.println("Player twos score: " + player2Score);
                break;
            }
            isPlayer1 = !isPlayer1;

            if (turn == 8 && game.didYouWin() == false){
                System.out.println("No one wins!");
            }

        }

    }

    public void getPlayerInput(Scanner scanner){
        int row;
        int col;

        do {
            // checks to see if input is out of bounds, if it is, will run while loop
            System.out.println("Please choose a row from 1 to 3");
            row = scanner.nextInt() - 1;
            while (row < 0 || row > 2) {
                System.out.println("That is not between 1 and 3! Please input a correct row");
               row = scanner.nextInt() - 1;
            }

            System.out.println("Now please choose a column from 1 to 3");
            col = scanner.nextInt() - 1;
            while (col < 0 || col > 2) {
                System.out.println("That is not between 1 and 3! Please input a correct column");
                col = scanner.nextInt() - 1;
            }


            // checks to see if a player has claimed the spot, otherwise will loop until un-unclaimed spot is chosen
            if (board[row][col] != '-') {
                System.out.println("A player already has claimed that spot!");
            }

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
        if (isPlayer1 == true){
            board[row][col] = 'x';
        }else {
            board[row][col] = 'o';
        }

    }



    public String whoTurn(){
        // checks to see whos turn it is
        if (isPlayer1 == true){
            return "player ones turn";
        } else {
            return  "Player twos turn";
        }
    }

    public boolean didYouWin(){
        for (int a = 0; a < board.length ; a++){
            if (board[a][0] == board[a][1] && board[a][1] == board[a][2] && board[a][0] != '-'){
                if (board[a][0] == 'x'){
                    player1Wins();
                    return true;
                }else {
                    player2Wins();
                    return true;
                }
            }
        }

        for (int b = 0; b < board.length ; b++){
            if (board[0][b] == board[1][b] && board[1][b] == board[2][b] && board[0][b] != '-'){
                if (board[0][b] == 'x'){
                    player1Wins();
                    return true;
                } else {
                    player2Wins();
                    return true;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
            if (board[0][0] == 'x') {
                    player1Wins();
                    return true;
            } else {
                    player2Wins();
                    return true;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'){
            if (board[0][2] == 'x') {
                player1Wins();
                return true;
            } else {
                player2Wins();
                return true;
            }
        }
        return false;
    }

    public void player1Wins(){
        System.out.println("Player one wins!");
        player1Score++;
    }
    public void player2Wins(){
        System.out.println("Player two wins!");
        player2Score++;
    }

}