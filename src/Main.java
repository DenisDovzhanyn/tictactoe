import java.util.Scanner;

public class Main {
    char[][] board = new char[3][3];
    int row;
    int col;
    static boolean isPlayer1 = true;
    static int score;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main game = new Main();

        game.resetBoard();
        game.printBoard();

        for (int turn = 0; turn < 9 ; turn++){
            System.out.println("It is currently " + game.whoTurn());
            System.out.println("Please choose a row from 1 to 3");

            do {
                // checks to see if input is out of bounds, if it is, will run while loop
                game.setRow(input);
                while (game.getRow() < 0 || game.getRow() > 2) {
                    System.out.println("That is not between 1 and 3! Please input a correct row");
                    game.setRow(input);
                }

                System.out.println("Now please choose a column");
                game.setCol(input);
                while (game.getCol() < 0 || game.getCol() > 2) {
                    System.out.println("That is not between 1 and 3! Please input a correct column");
                    game.setCol(input);
                }

                if (game.getBoard(game.getRow(), game.getCol()) != '-') {
                    System.out.println("A player already has claimed that spot!");
                } else {
                    game.setBoard(game.getRow(), game.getCol());

                }
            } while (game.getBoard(game.getRow(), game.getCol()) != '-');

            /*checks to see if the spot is already taken, if the spot is taken then the loop keeps running until an unclaimed spot is input
            do {
                if (game.getBoard(game.getRow(), game.getCol()) != '-') {
                    System.out.println("A player already has claimed that spot!");
                } else {
                    game.setBoard(game.getRow(), game.getCol());

                }
            } while (game.getBoard(game.getRow(), game.getCol()) != '-');

             */

            game.printBoard();


            isPlayer1 = !isPlayer1;





        }



    }

    public void setRow(Scanner scanner){
        this.row = scanner.nextInt() - 1;
    }
    public int getRow(){
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(Scanner scanner) {
        this.col = scanner.nextInt() - 1;
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
        for (int i = 0; i < board.length; i++) {
            System.out.println();
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