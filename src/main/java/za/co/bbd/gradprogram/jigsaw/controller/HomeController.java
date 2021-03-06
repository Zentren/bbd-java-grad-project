package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import za.co.bbd.gradprogram.jigsaw.db.TargetImage;
import za.co.bbd.gradprogram.jigsaw.db.TargetImageJdbcRepository;
import za.co.bbd.gradprogram.jigsaw.model.SessionManager;

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
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("columns") int columns, @RequestParam("rows") int rows) throws IOException {
        System.out.println(columns);
        System.out.println(rows);
        long rowId = jdbcRepository.insert(new TargetImage(file.getBytes()));
        int sessionId = SessionManager.getInstance().createSession((int) rowId, rows, columns).getSessionId();
        return "redirect:/game/" + sessionId;
    }
}
