package com.example.minesweeperkata;

public class MineSweeper {
    public char[][] board;

    public MineSweeper(char[][] board) {
        this.board = board;
    }

    public void sweep() {
        for(int row=0; row<board.length; row++) {
            for(int column=0; column<board[row].length; column++) {
                int bombsInTheVicinity = 0;
                if(board[row][column] != '*') {
                    if (thereIsAColumnToTheLeft(column) && neighbouringSquareContainsABomb(row, column - 1)) { //left
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsAColumnToTheRight(row, column) && neighbouringSquareContainsABomb(row, column + 1)) { //right
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsARowAbove(row) && neighbouringSquareContainsABomb(row - 1, column)) { //top
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsARowBelow(row) && neighbouringSquareContainsABomb(row + 1, column)) { //bottom
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsAColumnToTheRight(row, column) && thereIsARowAbove(row) && neighbouringSquareContainsABomb(row - 1, column + 1)) {//top right
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsAColumnToTheLeft(column)  && thereIsARowAbove(row) && neighbouringSquareContainsABomb(row - 1, column - 1)) { //top left
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsARowBelow(row) && thereIsAColumnToTheRight(row, column) && neighbouringSquareContainsABomb(row + 1, column + 1)) { //bottom right
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                    if (thereIsARowBelow(row) && thereIsAColumnToTheLeft(column) && neighbouringSquareContainsABomb(row + 1, column - 1)) { //bottom left
                        bombsInTheVicinity++;
                        updateBombDistanceValue(row, column, bombsInTheVicinity);
                    }
                }
            }

        }
    }

    private boolean thereIsAColumnToTheLeft(int j) {
        return thereIsARowAbove(j);
    }

    private boolean thereIsAColumnToTheRight(int rowIndex, int columnIndex) {
        return board[rowIndex].length > columnIndex + 1;
    }

    private boolean thereIsARowAbove(int row) {
        return row - 1 >= 0;
    }

    private boolean thereIsARowBelow(int row) {
        return row + 1 < board.length;
    }

    private boolean neighbouringSquareContainsABomb(int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex] == '*';
    }

    private void updateBombDistanceValue(int i, int j, int distanceFromBomb) {
        board[i][j] = (char) ('0' + distanceFromBomb);
    }
}
