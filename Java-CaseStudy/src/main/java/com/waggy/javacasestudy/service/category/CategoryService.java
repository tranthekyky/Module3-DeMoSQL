package com.waggy.javacasestudy.service;

import com.waggy.javacasestudy.model.CategoryProduct;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements IService<CategoryProduct> {
    private Connection connection = ConnectSQL.getConnectData() ;

    @Override
    public List<CategoryProduct> getAll() {
        String sql = "select * from category";
        List<CategoryProduct> categoryProducts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryProduct cate = new CategoryProduct(resultSet.getInt(1), resultSet.getString(2));
                categoryProducts.add(cate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryProducts;
    }

    @Override
    public CategoryProduct getById(int id) {
        String sql = "select * from category where idC = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryProduct cate = new CategoryProduct(resultSet.getInt(1), resultSet.getString(2));
                return cate;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(CategoryProduct categoryProduct) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, CategoryProduct categoryProduct) {

    }

    public static void main(String[] args) {
         CategoryService categoryService = new CategoryService();
        System.out.println(categoryService.getById(2));
    }
}
