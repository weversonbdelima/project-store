package com.example.produto.services.storage;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.example.produto.services.storage.StoragePropertiesService;
public class StorageServiceImplements implements StorageService{

        private final Path rootLocation;

        public StorageServiceImplements(){
            StoragePropertiesService storagePropertiesService = new StoragePropertiesService();
            this.rootLocation = Paths.get(storagePropertiesService.getLocation());
        }

        public void store(MultipartFile file){
            //Resolvendo o diretório root com o nome do arquivo
            Path destinationFile = this.rootLocation.resolve(
                Paths.get(file.getOriginalFilename()))
                .normalize()
                .toAbsolutePath();

            //Escrevendo o arquivo no sistema de arquivos
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println(e);
            }
        }

        public Path load(String fileName){
            return this.rootLocation.resolve(fileName);
        }

        public Resource loadAsResource(String fileName){

            try{
                Path file = load(fileName);
                Resource resource = new UrlResource(file.toUri());

                if(resource.exists() || resource.isReadable()){
                    return resource;
                }else{
                //lança exceção
                
                }
            }catch(MalformedURLException e){
                //Exeção
            }
            return null;
    
        }
}