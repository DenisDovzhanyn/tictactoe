import java.util.Scanner;

public class Main {
     int boardLength = 3;
    char[][] board = new char[boardLength][boardLength];
    int row;
    int col;
    char x = 'x';
    char o = 'o';
    static boolean isPlayer1 = true;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main game = new Main();

        game.resetBoard();
        game.printBoard();

        for (int turn = 0; turn < 9 ; turn++){
            System.out.println("It is currently " + game.whoTurn());
            System.out.println("Please choose a row from 1 to 3");
            game.setRow(input);

            // checks to see if input is within bounds, if it is, will continue running without problems
            while (game.getRow() < 1  || game.getRow() > 3){
                System.out.println("That is not between 1 and 3! Please input a correct row");
                game.setRow(input);
            }

            System.out.println("Now please choose a column");
            game.setCol(input);
            while (game.getCol() < 1 || game.getCol() > 3){
                System.out.println("That is not between 1 and 3! Please input a correct column");
                game.setCol(input);
            }

            game.setBoard(game.getRow() - 1, game.getCol() - 1);
            game.printBoard();

            if (isPlayer1 == true){
                isPlayer1 = false;
            } else {
                isPlayer1 = true;
            }





        }



    }

    public void setRow(Scanner scanner){
        this.row = scanner.nextInt();
    }
    public int getRow(){
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(Scanner scanner) {
        this.col = scanner.nextInt();
    }


    public void resetBoard() {
        // fills board with ' - ' to show that it is empty

        for (int i = 0; i < boardLength; i++) {
            for (int o = 0; o < boardLength; o++) {
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
        if (isPlayer1 == true){
            board[row][col] = 'x';
        }else {
            board[row][col] = 'o';
        }

    }

    public String whoTurn(){
        if (isPlayer1 == true){
            return "player ones turn";
        } else {
            return  "Player twos turn";
        }
    }

}