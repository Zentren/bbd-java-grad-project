package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.bbd.gradprogram.jigsaw.db.TargetImage;
import za.co.bbd.gradprogram.jigsaw.db.TargetImageJdbcRepository;

import java.io.IOException;

@Controller
public class ResourceController {

    @Autowired
    private TargetImageJdbcRepository jdbcRepository;

    @RequestMapping(value = "/images/{id}")
    @ResponseBody
    public byte[] getJigsawImage(@PathVariable(value = "id") String id) throws IOException {
        TargetImage targetImage = jdbcRepository.findById(Long.parseLong(id)); // FIXME: error handling
        return targetImage.getImage();
    }
}
