package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.web.bind.annotation.*;
import za.co.bbd.gradprogram.jigsaw.model.Puzzle;
import za.co.bbd.gradprogram.jigsaw.model.SessionManager;
import za.co.bbd.gradprogram.jigsaw.pojo.PuzzleMove;

@RestController
public class SessionController {

    @RequestMapping(value = "/session/{id}", method = RequestMethod.GET)
    public Puzzle getGamestate(@PathVariable(name = "id") String sessionId, @RequestParam(name = "img", required = false) String imageId) {
        SessionManager sessionManager = SessionManager.getInstance();

        Puzzle puzzle = sessionManager.getSession(Integer.parseInt(sessionId));
        if (puzzle == null) {
            puzzle = sessionManager.createSession(0, 3, 3);
        }
        return puzzle;
    }

    @RequestMapping(value = "/session/{id}", method = RequestMethod.POST)
    public void postMove(@RequestBody PuzzleMove puzzleMove, @PathVariable(name = "id") String sessionId) {
        Puzzle puzzle = SessionManager.getInstance().getSession(Integer.parseInt(sessionId));
        puzzle.swap(puzzleMove.getX1(), puzzleMove.getY1(),puzzleMove.getX2(), puzzleMove.getY2());
    }
}
