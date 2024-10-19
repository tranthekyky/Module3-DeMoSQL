package com.waggy.javacasestudy.service;

import com.waggy.javacasestudy.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService <Product> {
    private Connection connection = ConnectSQL.getConnectData();
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               products.add(new Product(
                       resultSet.getInt(1),
                       resultSet.getString(2),
                       resultSet.getDouble(3),
                       resultSet.getInt(4) ,
                       resultSet.getString(5),
                       resultSet.getString(6) ,
                       resultSet.getInt(7)
               ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products ;
    }

    @Override
    public Product getById(int id) {
        String sql = "SELECT * FROM product WHERE idProduct = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4) ,
                        resultSet.getString(5),
                        resultSet.getString(6) ,
                        resultSet.getInt(7)
                );
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Product> getProductByPrice(double minPrice , double maxPrice) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE priceProduct between ? and ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4) ,
                        resultSet.getString(5),
                        resultSet.getString(6) ,
                        resultSet.getInt(7)
                );
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Product product) {

    }

    public List<Product> getProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE categoryId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4) ,
                        resultSet.getString(5),
                        resultSet.getString(6) ,
                        resultSet.getInt(7)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> products = productService.getProductByPrice(5 , 20);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
