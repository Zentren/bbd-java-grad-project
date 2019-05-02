package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Data;

@Data
public class Piece {
    private final int row;
    private final int column;

    public boolean inRightPlace(int row, int col) {
        return ((this.row == row)&&(this.column == col));
    }

    //TODO: Change to bit stream or whatever
    public String tileFace() {
        return String.valueOf(this.row) + String.valueOf(this.column);
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
        return (piece.getRow() == this.row)&&(piece.getColumn() == this.column);
    }
}
