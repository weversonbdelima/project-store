package com.example.produto.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.example.produto.services.database.DatabaseService;
import com.example.produto.services.database.DatabaseServiceImplements;
import com.example.produto.models.ProdutoModel;

@CrossOrigin
@RestController
@RequestMapping("/produto")
public class ProdutoController{

    @PostMapping
    public void create(@RequestBody ProdutoModel produtoModel){
        System.out.println(produtoModel);
        //Create
        DatabaseService databaseService = new DatabaseServiceImplements();
        databaseService.create(produtoModel);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProdutoModel produtoModel){
        DatabaseService databaseService = new DatabaseServiceImplements();
        databaseService.update(id, produtoModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        DatabaseService databaseService = new DatabaseServiceImplements();
        databaseService.delete(id);
    }

    @GetMapping
    @ResponseBody
    public List<ProdutoModel> list(){
        DatabaseService databaseService = new DatabaseServiceImplements();
        return databaseService.list();
    }

   
}