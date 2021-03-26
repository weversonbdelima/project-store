package com.example.produto.services.database;

import java.util.List;
import com.example.produto.models.ProdutoModel;
public interface DatabaseService{
    public void create(ProdutoModel produtoModel);
    public void update(int id, ProdutoModel produtoModel);
    public void delete(int id);
    public List<ProdutoModel> list();
}