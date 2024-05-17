import java.util.Scanner;

public class Main {
    int boardLength = 3;
    char[][] board = new char[boardLength][boardLength];
    char x = 'x';
    char o = 'o';
    boolean isPlayer1 = true;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().resetBoard();
        new Main().printBoard();



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
    }

    
}