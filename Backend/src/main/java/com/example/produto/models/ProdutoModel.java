package com.example.produto.models;
import org.springframework.web.multipart.MultipartFile;

public class ProdutoModel{
    private int id;
    private String nome;
    private double preco;
    private String descrisao;
    private String imagem;


    public ProdutoModel() {
    }

    public ProdutoModel(String nome, double preco, String descrisao, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.descrisao = descrisao;
        this.imagem = imagem;
    }

    public ProdutoModel(int id, String nome, double preco, String descrisao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descrisao = descrisao;
        this.imagem = imagem;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescrisao() {
        return this.descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", preco='" + getPreco() + "'" +
            ", descrisao='" + getDescrisao() + "'" +
            ", imagem='" + getImagem() + "'" +
            "}";
    }
  
}