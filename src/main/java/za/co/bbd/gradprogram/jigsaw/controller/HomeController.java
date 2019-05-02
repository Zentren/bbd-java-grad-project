package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import za.co.bbd.gradprogram.jigsaw.db.TargetImage;
import za.co.bbd.gradprogram.jigsaw.db.TargetImageJdbcRepository;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private TargetImageJdbcRepository jdbcRepository;

    @GetMapping("/")
    public String displayHome() {
        return "home";
    }

    @PostMapping("/")
    public String uploadFile(@RequestParam("file") MultipartFile file)throws IOException {
        long rowId = jdbcRepository.insert(new TargetImage(0L, file.getBytes()));
        return "redirect:/game?id=" + rowId;
    }
}
