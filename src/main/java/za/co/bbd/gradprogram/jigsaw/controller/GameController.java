package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

    @GetMapping("/game/{id}")
    public String displayGame(Model model, @PathVariable(name = "id") String sessionId) {
        model.addAttribute("id", sessionId);
        return "game";
    }
}
