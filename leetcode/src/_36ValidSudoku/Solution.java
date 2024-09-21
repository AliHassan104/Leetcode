package _36ValidSudoku;

import java.util.HashSet;

public class Solution {

    public static boolean isValidSudoku(char[][] board) {

        HashSet<String> numbersFound = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.'){

                    if (!numbersFound.add(i +" row "+ board[i][j])){
                        return false;
                    }

                    if (!numbersFound.add(j +" column "+ board[i][j])){
                        return false;
                    }

                    int boxNumber = ((i/3)*3)+(j/3);

                    if (!numbersFound.add(boxNumber + "box" + board[i][j])){
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuChatGPT(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (current != '.') {
                    if (!checkAndAdd(seen, i, j, current)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkAndAdd(HashSet<String> seen, int row, int col, char num) {
        int boxIndex = (row / 3) * 3 + (col / 3);
        if (!seen.add(num + " in row " + row) ||
                !seen.add(num + " in col " + col) ||
                !seen.add(num + " in box " + boxIndex)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char [][] board =
        {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        isValidSudoku(board);
    }

}
