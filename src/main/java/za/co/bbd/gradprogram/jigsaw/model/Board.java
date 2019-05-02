package za.co.bbd.gradprogram.jigsaw.model;

import java.util.Random;

public class Board {

    private final int rows;
    private final int columns;

    private Piece[][] board;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.board = new Piece[this.rows][this.columns];
        shuffle();
        initialize();
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    private void initialize() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                this.board[r][c] = new Piece(r,c);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                swap(r, c, rand.nextInt(this.rows), rand.nextInt(this.rows));
            }
        }
    }

    public boolean complete() {

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                if (!(board[r][c]).inRightPlace(r,c))
                    return false;
            }
        }

        return true;
    }

    public void swap(int row1, int col1, int row2, int col2) {
        Piece temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }

}
