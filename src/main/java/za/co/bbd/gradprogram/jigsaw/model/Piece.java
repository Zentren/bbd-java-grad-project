package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Data;

@Data
public class Piece {
    private final int initialRow;
    private final int initialColumn;
    private final String name;

    public Piece (int row, int column) {
        this.initialRow = row;
        this.initialColumn = column;
        this.name = String.valueOf(this.initialRow) + String.valueOf(this.initialColumn);
    }

    public boolean inRightPlace(int row, int col) {
        return ((this.initialRow == row)&&(this.initialColumn == col));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece)o;
        return (piece.getInitialRow() == this.initialRow)&&(piece.getInitialColumn() == this.initialColumn);
    }
}
