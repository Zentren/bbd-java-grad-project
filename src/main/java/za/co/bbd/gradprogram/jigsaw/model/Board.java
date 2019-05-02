package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Getter;

import java.util.Random;

@Getter
public class Board {

    private final int rows;
    private final int columns;

    private Piece[][] board;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.board = new Piece[this.rows][this.columns];

        initialize();
        shuffle();
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    private void initialize() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                this.board[r][c] = new Piece(r, c);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                swap(board[r][c], board[rand.nextInt(this.rows)][rand.nextInt(this.columns)]);
            }
        }
    }

    public boolean complete() {

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                if (!(board[r][c]).isCorrectlyPlaced())
                    return false;
            }
        }

        return true;
    }

    public void swap(Piece a, Piece b) {
        board[a.getRow()][a.getColumn()] = new Piece(b, a.getRow(), a.getColumn());
        board[b.getRow()][b.getColumn()] = new Piece(a, b.getRow(), b.getColumn());
    }

}
