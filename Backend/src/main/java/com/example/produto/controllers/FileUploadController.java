package com.example.produto.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.produto.services.storage.StorageService;
import com.example.produto.services.storage.StorageServiceImplements;

@CrossOrigin
@RestController
@RequestMapping("/produto")
public class FileUploadController{

    private final StorageService storageService;

    public FileUploadController(){
        this.storageService = new StorageServiceImplements();
    }

    @PostMapping("/files")
    public void receiverFile(@RequestParam("file") MultipartFile file){
        storageService.store(file);
    }
    @GetMapping("/files/{fileName:.+}")
	@ResponseBody
    public ResponseEntity<Resource> sendFile(@PathVariable String fileName){
            System.out.println(fileName);
            Resource file = storageService.loadAsResource(fileName);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
             "attachment; filename=\""+ file.getFilename() + "\"").body(file);
    }
   
}