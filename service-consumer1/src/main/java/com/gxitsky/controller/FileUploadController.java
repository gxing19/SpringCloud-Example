package com.gxitsky.controller;

import com.gxitsky.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public String uploadFile(User user){
        String fileName = user.getFile().getName();
        long size = user.getFile().getSize();
        return fileName + " : " + size;
    }
}
