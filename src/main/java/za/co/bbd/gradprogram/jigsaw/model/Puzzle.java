package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Getter;

@Getter
public class Puzzle {

    private int sessionId;
    private int imageId;
    private Board board;
    private boolean isComplete;

    public Puzzle(int sessionId, int imageId, int rows, int columns) {
        this.sessionId = sessionId;
        this.imageId = imageId;
        board = new Board(rows, columns);
        isComplete = false;
    }

    public void swap(int x1, int y1, int x2, int y2) {
        board.swap(x1, y1, x2, y2);
        isComplete = board.complete();
    }
}
