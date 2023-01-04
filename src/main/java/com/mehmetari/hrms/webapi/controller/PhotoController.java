package com.mehmetari.hrms.webapi.controller;

import com.mehmetari.hrms.business.abstracts.PhotoService;
import com.mehmetari.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    private PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping ("/addPhoto")
    public Result addPhoto(@RequestBody MultipartFile file,@RequestParam("id") Integer id) throws IOException {
        return photoService.addPhoto(file, id);
    }


}
