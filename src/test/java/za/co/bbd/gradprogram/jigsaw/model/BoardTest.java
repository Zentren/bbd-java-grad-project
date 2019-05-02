package za.co.bbd.gradprogram.jigsaw.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BoardTest {

    @Test
    public void shuffle() {
        Board board = new Board(3,3);
        board.shuffle();
        assertFalse(board.complete());
    }

    @Test
    public void complete() {
        Board board = new Board(3,3);
        assertTrue(board.complete());
    }

    @Test
    public void swap() {
        Board board = new Board(3,3);
        board.swap(1,1,2,2);
        assertTrue(board.getPiece(1,1).getInitialRow() == 2);
        assertTrue(board.getPiece(1,1).getInitialColumn() == 2);
        assertTrue(board.getPiece(2,2).getInitialRow() == 1);
        assertTrue(board.getPiece(2,2).getInitialColumn() == 1);
    }
}
