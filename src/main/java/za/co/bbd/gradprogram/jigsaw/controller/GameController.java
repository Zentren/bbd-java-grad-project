package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @GetMapping("/game")
    public String displayGame(@RequestParam(name = "id") String imageId, Model model) {
        model.addAttribute("imageId", imageId);
        return "game";
    }
}
