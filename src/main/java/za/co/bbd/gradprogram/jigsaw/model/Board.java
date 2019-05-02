package za.co.bbd.gradprogram.jigsaw.model;


public class Board {

    private final int rows;
    private final int columns;

    private Piece[][] board;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.board = new Piece[this.rows][this.columns];
        initialize();
    }

    private void initialize() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                int pieceNumber = (r * this.columns) + c;
                this.board[r][c] = new Piece(pieceNumber);
            }
        }
    }

}
