package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Getter;

import java.util.Random;

@Getter
public class Board {

    private final int rows;
    private final int columns;

    private Piece[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.grid = new Piece[this.rows][this.columns];

        initialize();
        shuffle();
    }

    public Piece getPiece(int row, int col) {
        return grid[row][col];
    }

    private void initialize() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                this.grid[r][c] = new Piece(r, c);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                swap(grid[r][c], grid[rand.nextInt(this.rows)][rand.nextInt(this.columns)]);
            }
        }
    }

    public boolean complete() {

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                if (!(grid[r][c]).isCorrectlyPlaced())
                    return false;
            }
        }

        return true;
    }

    public void swap(Piece a, Piece b) {
        grid[a.getRow()][a.getColumn()] = new Piece(b, a.getRow(), a.getColumn());
        grid[b.getRow()][b.getColumn()] = new Piece(a, b.getRow(), b.getColumn());
    }

    // For Not js
    public void swap(int x1, int y1, int x2, int y2) {
        swap(grid[x1][y1], grid[x2][y2]);
    }

}
