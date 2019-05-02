package za.co.bbd.gradprogram.jigsaw.model;

import lombok.Getter;

import java.util.Random;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

@Getter
public class Board {

    private final int rows;
    private final int columns;

    private ArrayList<BufferedImage> pieces = new ArrayList<>();
    private BufferedImage targetImage;

    private Piece[][] board;

    public Board(int rows, int columns, BufferedImage targetImage) {
        this.rows = rows;
        this.columns = columns;
        this.targetImage = targetImage;

        this.board = new Piece[this.rows][this.columns];

        initialize();
        shuffle();
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    private void initialize() {
        cutMyImageIntoPieces();
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                BufferedImage pieceImage = pieces.get(r + c);
                this.board[r][c] = new Piece(r, c, pieceImage);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                swap(r, c, rand.nextInt(this.rows), rand.nextInt(this.columns));
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


    private void cutMyImageIntoPieces() {
        int chunkWidth = targetImage.getWidth() / columns;
        int chunkHeight = targetImage.getHeight() / rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                BufferedImage newChunk = new BufferedImage(chunkWidth, chunkHeight, targetImage.getType());
                pieces.add(newChunk);
            }
        }
    }

}
