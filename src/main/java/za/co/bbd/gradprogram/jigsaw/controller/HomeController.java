package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHome() {
        return "home";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(MultipartFile file) throws IOException {
        // FIXME: Grab file and display.
        System.out.println(file.getBytes().length);
        return "home"; // FIXME: GOTO game screen.
    }
}
