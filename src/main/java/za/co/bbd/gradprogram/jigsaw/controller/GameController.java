package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.bbd.gradprogram.jigsaw.model.Board;

@Controller
public class GameController {

    private Board board = new Board(5,3);

    @GetMapping("/game")
    public String displayGame(Model model) {
//        model.addAttribute("imageId", imageId);
        model.addAttribute("board", board);
        return "game";
    }
}
