package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.UPloadDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadFileApi {
    @Autowired
    private ServletContext app ;

    @PostMapping("/images")
    public String saveImage(@ModelAttribute UPloadDTO uploadDTO) {
        uploadDTO = saveImageFile(uploadDTO);
        return uploadDTO.getName();
    }


    public UPloadDTO  saveImageFile(UPloadDTO uploadDTO) {
        MultipartFile multipartFile = uploadDTO.getMultipartFile();
        String originName = multipartFile.getOriginalFilename();

        String dir = app.getRealPath("/image");
        System.out.println(originName);
        File file = new File(dir,originName);
        try {
             multipartFile.transferTo(file);
             uploadDTO.setName(originName);

        } catch (IOException e) {
            e.printStackTrace();
            file.delete();
        } finally {
            file.delete();
        }
        return uploadDTO;
    }


}