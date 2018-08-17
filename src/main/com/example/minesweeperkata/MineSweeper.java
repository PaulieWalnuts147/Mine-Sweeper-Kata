package com.example.minesweeperkata;

public class MineSweeper {
    public char[][] board;

    public MineSweeper(char[][] board) {
        this.board = board;
    }

    public void sweep() {
        for(int row=0; row<board.length; row++) {
            for(int column=0; column<board[row].length; column++) {
                calculateBombsSurroundingASquare(row, column);
            }
        }
    }

    private void calculateBombsSurroundingASquare(int row, int column) {
        int bombsInTheVicinity = 0;
        for (int i = 0; i < bombCheckerConditions(row,column).length; i++ ){
            if (bombCheckerConditions(row,column)[i]) {
                bombsInTheVicinity++;
                updateBombDistanceValue(row, column, bombsInTheVicinity);
            }
        }
    }

    private boolean [] bombCheckerConditions(int row, int column) {
        boolean[] bombChecks = new boolean[8];
        if(board[row][column] != '*') {
            bombChecks[0] = thereIsABombToTheLeft(row, column);
            bombChecks[1] = thereIsABombToTheRight(row, column);
            bombChecks[2] = thereIsABombAbove(row, column);
            bombChecks[3] = thereIsABombBelow(row, column);
            bombChecks[4] = thereIsABombToTheTopRight(row, column);
            bombChecks[5] = thereIsABombToTheTopLeft(row, column);
            bombChecks[6] = thereIsABombToTheBottomRight(row, column);
            bombChecks[7] = thereIsABombToTheBottomLeft(row, column);
        }
        return bombChecks;
    }

    private boolean thereIsABombToTheLeft(int row, int column) {
        return thereIsAColumnToTheLeft(column) && neighbouringSquareContainsABomb(row, column - 1);
    }

    private boolean thereIsABombToTheRight(int row, int column) {
        return thereIsAColumnToTheRight(row, column) && neighbouringSquareContainsABomb(row, column + 1);
    }

    private boolean thereIsABombAbove(int row, int column) {
        return thereIsARowAbove(row) && neighbouringSquareContainsABomb(row - 1, column);
    }

    private boolean thereIsABombBelow(int row, int column) {
        return thereIsARowBelow(row) && neighbouringSquareContainsABomb(row + 1, column);
    }

    private boolean thereIsABombToTheTopRight(int row, int column) {
        return thereIsAColumnToTheRight(row, column) && thereIsARowAbove(row) && neighbouringSquareContainsABomb(row - 1, column + 1);
    }

    private boolean thereIsABombToTheTopLeft(int row, int column) {
        return thereIsAColumnToTheLeft(column)  && thereIsARowAbove(row) && neighbouringSquareContainsABomb(row - 1, column - 1);
    }

    private boolean thereIsABombToTheBottomRight(int row, int column) {
        return thereIsARowBelow(row) && thereIsAColumnToTheRight(row, column) && neighbouringSquareContainsABomb(row + 1, column + 1);
    }

    private boolean thereIsABombToTheBottomLeft(int row, int column) {
        return thereIsARowBelow(row) && thereIsAColumnToTheLeft(column) && neighbouringSquareContainsABomb(row + 1, column - 1);
    }

    private boolean thereIsAColumnToTheLeft(int columnIndex) {
        return columnIndex - 1 >= 0;
    }

    private boolean thereIsAColumnToTheRight(int rowIndex, int columnIndex) {
        return board[rowIndex].length > columnIndex + 1;
    }

    private boolean thereIsARowAbove(int rowIndex) {
        return rowIndex - 1 >= 0;
    }

    private boolean thereIsARowBelow(int rowIndex) {
        return rowIndex + 1 < board.length;
    }

    private boolean neighbouringSquareContainsABomb(int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex] == '*';
    }

    private void updateBombDistanceValue(int i, int j, int distanceFromBomb) {
        board[i][j] = (char) ('0' + distanceFromBomb);
    }
}
