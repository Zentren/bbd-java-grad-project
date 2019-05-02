package za.co.bbd.gradprogram.jigsaw.model;

import java.util.HashMap;

public final class SessionManager {

    private static SessionManager instance = new SessionManager();

    private int counter = 1;
    private HashMap<Integer, Puzzle> puzzles = new HashMap<>();

    public Puzzle createSession(int imageId, int rows, int columns) {
        Puzzle puzzle = new Puzzle(counter, imageId, rows, columns);
        puzzles.put(counter, puzzle);
        counter++;
        return puzzle;
    }

    public Puzzle getSession(int id) {
        if (puzzles.containsKey(id)) {
            return puzzles.get(id);
        }
        else {
            return null;
        }
    }

    public static SessionManager getInstance() {
        return instance;
    }
}
