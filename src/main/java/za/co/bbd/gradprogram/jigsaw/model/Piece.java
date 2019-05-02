package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Getter;

@Getter
public class Piece {

    private final int row;
    private final int column;
    private final int initialRow;
    private final int initialColumn;

    public Piece(int row, int column) {
        this.row = row;
        this.column = column;
        this.initialRow = row;
        this.initialColumn = column;
    }

    public Piece(Piece piece, int row, int column) {
        this.row = row;
        this.column = column;
        this.initialRow = piece.initialRow;
        this.initialColumn = piece.initialColumn;
    }

    public boolean isCorrectlyPlaced() {
        if (this.row == this.initialRow && this.column == this.initialColumn) {
            return true;
        }
        return false;
    }
}
