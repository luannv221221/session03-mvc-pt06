package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.util.ConnectDB;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO{
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        connection = ConnectDB.open();
        try {
            String sql = "SELECT * FROM cagegories";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.close(connection);
        }
        return categories;
    }

    @Override
    public Boolean create(Category category) {
        Connection connection = null;

        try {
            // tạo đối tượng kết nối
            connection = ConnectDB.open();
            // Tạo đối tượng PreparedStatement
            String sql = "insert into cagegories(name,status) value(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            // set các giá trị của tham số trong sql của prepareStatement
            statement.setString(1,category.getCategoryName());
            statement.setBoolean(2,category.isCategoryStatus());
            //thực thi câu truy vấn
            statement.executeUpdate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectDB.close(connection);
        }

        return false;
    }
}
