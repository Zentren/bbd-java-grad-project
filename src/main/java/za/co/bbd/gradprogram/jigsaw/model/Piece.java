package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Data;

@Data
public class Piece {
    private final int initialRow;
    private final int initialColumn;

    public boolean inRightPlace(int row, int col) {
        return ((this.initialRow == row)&&(this.initialColumn == col));
    }

    //TODO: Change to bit stream or whatever
    public String tileFace() {
        return String.valueOf(this.initialRow) + String.valueOf(this.initialColumn);
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
