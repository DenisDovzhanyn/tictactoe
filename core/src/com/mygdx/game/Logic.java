package com.mygdx.game;

public class Logic {
    char[][] board = new char[3][3];
    static boolean isPlayer1 = false;


    public Logic(){
        resetBoard();
    }

    // this resets or creates the board and fills it with '-'
    public void resetBoard(){
        for (int i = 0; i < board.length; i++){
            for (int k = 0; k < board.length; k++){
                board[i][k] = '-';
            }
        }
    }

    public void setBoard(int row, int column){
        if (isPlayer1) board[row][column] = 'x';
        else{
            board[row][column] = 'o';
        }
    }
    public boolean isIsPlayer1(){
        isPlayer1 = !isPlayer1;
        return isPlayer1;
    }
    public boolean getPlayer(){
        return isPlayer1;
    }

    public boolean didYouWin(){

        // checks each row for a winner
        for (int a = 0; a < board.length ; a++){
            if (board[a][0] == board[a][1] && board[a][1] == board[a][2] && board[a][0] != '-'){
                if (board[a][0] == 'x'){

                    return true;
                }else {

                    return true;
                }
            }
        }

        // checks each column for a winner
        for (int b = 0; b < board.length ; b++){
            if (board[0][b] == board[1][b] && board[1][b] == board[2][b] && board[0][b] != '-'){
                if (board[0][b] == 'x'){

                    return true;
                } else {

                    return true;
                }
            }
        }

        // these two if statements check for diagonal winners
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
            if (board[0][0] == 'x') {

                return true;
            } else {

                return true;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'){
            if (board[0][2] == 'x') {
                ;
                return true;
            } else {

                return true;
            }
        }
        return false;
    }





}
