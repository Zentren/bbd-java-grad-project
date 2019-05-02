package za.co.bbd.gradprogram.jigsaw.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

public class ResourceController {

    @RequestMapping(value = "images/{id}")
    @ResponseBody
    public byte[] getJigsawImage(@PathVariable(value = "id") String id) throws IOException {
        return null; // FIXME: DB access
    }
}
