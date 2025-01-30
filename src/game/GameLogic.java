package game;

import javax.swing.*;

import java.util.Arrays;

public final class GameLogic{

    public static boolean buttonSet(JButton button, boolean stateOfSign){
        button.setEnabled(false);
        button.setText(switchSign(stateOfSign));
        return !stateOfSign;
    }

    public static void buttonSet(JButton button){
        button.setEnabled(false);
        button.setText(switchSign(false));
    }

    private static String switchSign(boolean stateOfSign){
        if(stateOfSign)
            return "O";
        else
            return "X";
    }

    public static boolean isMovesLeft(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 2)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkMatrix(int[][] board, SetWonSign currentGame){
        int diagonalCounter = 0;
        int secondDiagonalCounter = 0;
        boolean rowState = false;
        boolean columnState = false;


        for (int i = 0; i < 3; i++) {
            if (board[i][i] == board[0][0] && (board[i][i] == 0 || board[i][i] == 1)) {
                diagonalCounter++;
            }
            if (board[i][2 - i] == board[0][2] && (board[i][2 - i] == 0 || board[i][2 - i] == 1)) {
                secondDiagonalCounter++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board[i][j] != board[i][0] || (board[i][j] != 0 && board[i][j] != 1)) {
                    rowState = false;
                    break;
                }
                rowState = true;
                currentGame.setWonSign(board[i][j] == 1 ?  'X' :  'O');
            }
            if(rowState)
                return rowState;
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 1; i < 3; i++) {
                if (board[i][j] != board[0][j] || (board[i][j] != 0 && board[i][j] != 1)) {
                    columnState = false;
                    break;
                }
                columnState = true;
                currentGame.setWonSign(board[i][j] == 1 ?  'X' :  'O');
            }
            if(columnState)
                return columnState;
        }

        if(diagonalCounter == 3){
            currentGame.setWonSign(board[0][0] == 1 ?  'X' :  'O');
        }
        else if(secondDiagonalCounter == 3){
            currentGame.setWonSign(board[0][2] == 1 ?  'X' :  'O');
        }
        return diagonalCounter == 3 || secondDiagonalCounter == 3 || rowState || columnState;
    }

    public static void resetBoard(int[][] board){
        for (int[] num : board) {
            Arrays.fill(num, 2);
        }
    }
}
