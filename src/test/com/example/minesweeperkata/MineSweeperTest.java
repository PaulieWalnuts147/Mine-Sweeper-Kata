package com.example.minesweeperkata;
import org.junit.Test;
import static org.junit.Assert.*;

public class MineSweeperTest {

    @Test
    public void change_square_to_one_when_one_bomb_to_the_left() {

        char[][] board = {{'*', '.'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('*', mineSweeper.board[0][0]);
        assertEquals('1', mineSweeper.board[0][1]);
    }

    @Test
    public void change_square_to_one_when_one_bomb_to_the_right() {

        char[][] board = {{'.', '*'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('1', mineSweeper.board[0][0]);
        assertEquals('*', mineSweeper.board[0][1]);
    }


    @Test
    public void change_square_to_two_when_a_bomb_to_left_and_right() {

        char[][] board = {{'*', '.', '*'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('*', mineSweeper.board[0][0]);
        assertEquals('2', mineSweeper.board[0][1]);
    }


    @Test
    public void change_square_to_one_when_bomb_above() {

        char[][] board = {{'*'},
                          {'.'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('*', mineSweeper.board[0][0]);
        assertEquals('1', mineSweeper.board[1][0]);
    }


    @Test
    public void change_square_to_one_when_bomb_below() {

        char[][] board = {{'.'},
                          {'*'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('1', mineSweeper.board[0][0]);
        assertEquals('*', mineSweeper.board[1][0]);
    }

    @Test
    public void change_square_to_one_when_bomb_top_right() {

        char[][] board = {{'.', '.', '*'},
                          {'.', '.', '.'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('.', mineSweeper.board[0][0]);
        assertEquals('1', mineSweeper.board[0][1]);
        assertEquals('*', mineSweeper.board[0][2]);
        assertEquals('.', mineSweeper.board[1][0]);
        assertEquals('1', mineSweeper.board[1][1]);
        assertEquals('1', mineSweeper.board[1][2]);
    }


    @Test
    public void change_square_to_one_when_bomb_top_left() {

        char[][] board = {{'*', '.', '.'},
                          {'.', '.', '.'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('*', mineSweeper.board[0][0]);
        assertEquals('1', mineSweeper.board[0][1]);
        assertEquals('.', mineSweeper.board[0][2]);
        assertEquals('1', mineSweeper.board[1][0]);
        assertEquals('1', mineSweeper.board[1][1]);
        assertEquals('.', mineSweeper.board[1][2]);
    }


    @Test
    public void change_square_to_one_when_bomb_bottom_right() {

        char[][] board = {{'.', '.', '.'},
                          {'.', '.', '*'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('.', mineSweeper.board[0][0]);
        assertEquals('1', mineSweeper.board[0][1]);
        assertEquals('1', mineSweeper.board[0][2]);
        assertEquals('.', mineSweeper.board[1][0]);
        assertEquals('1', mineSweeper.board[1][1]);
        assertEquals('*', mineSweeper.board[1][2]);
    }

    @Test
    public void change_square_to_one_when_bomb_bottom_left() {

        char[][] board = {{'.', '.', '.'},
                          {'*', '.', '.'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('1', mineSweeper.board[0][0]);
        assertEquals('1', mineSweeper.board[0][1]);
        assertEquals('.', mineSweeper.board[0][2]);
        assertEquals('*', mineSweeper.board[1][0]);
        assertEquals('1', mineSweeper.board[1][1]);
        assertEquals('.', mineSweeper.board[1][2]);
    }


    @Test
    public void correctly_calculate_every_scenario() {

        char[][] board = {{'*', '*', '.'},
                          {'.', '.', '.'},
                          {'.', '*', '.'},
                          {'.', '.', '*'},
                          {'.', '*', '.'}};

        MineSweeper mineSweeper = new MineSweeper(board);

        mineSweeper.sweep();

        printBoard(mineSweeper.board);

        assertEquals('*', mineSweeper.board[0][0]);
        assertEquals('*', mineSweeper.board[0][1]);
        assertEquals('1', mineSweeper.board[0][2]);

        assertEquals('3', mineSweeper.board[1][0]);
        assertEquals('3', mineSweeper.board[1][1]);
        assertEquals('2', mineSweeper.board[1][2]);

        assertEquals('1', mineSweeper.board[2][0]);
        assertEquals('*', mineSweeper.board[2][1]);
        assertEquals('2', mineSweeper.board[2][2]);

        assertEquals('2', mineSweeper.board[3][0]);
        assertEquals('3', mineSweeper.board[3][1]);
        assertEquals('*', mineSweeper.board[3][2]);

        assertEquals('1', mineSweeper.board[4][0]);
        assertEquals('*', mineSweeper.board[4][1]);
        assertEquals('2', mineSweeper.board[4][2]);
    }









    public void printBoard(char[][] board) {
        for (char[] x : board) {
            for (char y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
