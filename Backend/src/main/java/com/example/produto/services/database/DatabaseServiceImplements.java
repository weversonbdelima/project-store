package com.example.produto.services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.example.produto.models.ProdutoModel;
public class DatabaseServiceImplements implements DatabaseService{

    //Configuração banco de dados
    final private String DATABASE_URL = "jdbc:oracle:thin:@192.168.1.10:1521:orcl";
    final private String USER = "produto";
    final private String PASSWORD = "produto_password";

    public void create(ProdutoModel produtoModel){
        //Instrução DML
        final String sql = "insert into produtos(nome, preco, descrisao, imagem) values ('"+produtoModel.getNome()+
                            "', "+produtoModel.getPreco()+
                            ", '"+produtoModel.getDescrisao()+
                            "', '"+produtoModel.getImagem()+"')";
        try (
            Connection connection = DriverManager.getConnection(
                this.DATABASE_URL, this.USER, this.PASSWORD);
            Statement statement = connection.createStatement();
        ) {
            //Executando instrução  DML
            statement.execute(sql);
        } catch (SQLException sqlException) {
            //TODO: handle exception
            sqlException.printStackTrace();
        }
    }

    public void update(int id, ProdutoModel produtoModel){
        //Instrução DML
        final String sql = "update produtos set nome = '"+produtoModel.getNome()+"',"+
                            "preco = "+produtoModel.getPreco()+","+
                            "descrisao = '"+produtoModel.getDescrisao()+"',"+
                            "imagem = '"+produtoModel.getImagem()+"'"+
                            "where produto_id = "+ id;

                System.out.println(sql);            
        try (
            Connection connection = DriverManager.getConnection(
                this.DATABASE_URL, this.USER, this.PASSWORD);
            Statement statement = connection.createStatement();
        ) {
            //Executando instrução  DML
            statement.execute(sql);
        } catch (SQLException sqlException) {
            //TODO: handle exception
            sqlException.printStackTrace();
        }
    }

    public void delete(int id){
        //Instrução DML
        final String sql = "delete from produtos "+
                            "where produto_id = "+ id;
        try (
            Connection connection = DriverManager.getConnection(
                this.DATABASE_URL, this.USER, this.PASSWORD);
            Statement statement = connection.createStatement();
        ) {
            //Executando instrução  DML
            statement.execute(sql);
        } catch (SQLException sqlException) {
            //TODO: handle exception
            sqlException.printStackTrace();
        }
    }

    public List<ProdutoModel> list(){
        //Instrução DML
        final String sql = "select * from produtos";
        try (
            Connection connection = DriverManager.getConnection(
                this.DATABASE_URL, this.USER, this.PASSWORD);
            Statement statement = connection.createStatement();
        ) {
            //Executando instrução  DML
            ResultSet resultSet = statement.executeQuery(sql);


            //Lista para armazenar a consulta
            List<ProdutoModel> listProdutoModel = new ArrayList<>();     
            while(resultSet.next()){
                ProdutoModel produtoModel = new ProdutoModel(Integer.parseInt(resultSet.getObject(1).toString()),
                                                            resultSet.getObject(2).toString(),
                                                            Double.parseDouble(resultSet.getObject(3).toString()),
                                                            resultSet.getObject(4).toString(),
                                                            resultSet.getObject(5).toString()
                                                        );
                listProdutoModel.add(produtoModel);
            }
            return listProdutoModel;
        } catch (SQLException sqlException) {
            //TODO: handle exception
            sqlException.printStackTrace();
        }
        return null;
    }
}