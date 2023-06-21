package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // return ResponseEntity.ok("working");

        try{
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must contain a file");
            }
            if(!file.getContentType().equals("image/jpg")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpg file must be uploaded");
            }
            
            //file upload

            Boolean f=fileUploadHelper.uploadFile(file);
            if(f){
                return ResponseEntity.ok("File Uploaded successfully");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong,try again");
    }
}
