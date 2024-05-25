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




}
