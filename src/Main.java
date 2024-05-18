import java.util.Scanner;

public class Main {
    char[][] board = new char[3][3];

    static boolean isPlayer1 = true;
    static int score;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main game = new Main();


        game.resetBoard();
        game.printBoard();

        for (int turn = 0; turn < 9 ; turn++){
            System.out.println("It is currently " + game.whoTurn());

            game.getPlayerInput(input);

            game.printBoard();
            isPlayer1 = !isPlayer1;
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
            if (getBoard(row, col) != '-') {
                System.out.println("A player already has claimed that spot!");
            }

        } while (getBoard(row, col) != '-');

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

    public char getBoard(int row, int col){
        return board[row][col];
    }

    public String whoTurn(){
        // checks to see whos turn it is
        if (isPlayer1 == true){
            return "player ones turn";
        } else {
            return  "Player twos turn";
        }
    }

}