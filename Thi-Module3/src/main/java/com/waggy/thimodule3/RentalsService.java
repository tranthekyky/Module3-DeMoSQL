package com.waggy.thimodule3;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalsService {
    Connection connection = ConnectDB.getConnectData();
    public List<InfoRentals> getAllInfo () {
        String sql = "SELECT * FROM rentals ;";
        List<InfoRentals> infoRentals = new ArrayList<InfoRentals>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String date = resultSet.getString(4);
                String checkout = resultSet.getString(5);
                String notes = resultSet.getString(6);
                InfoRentals info =  new InfoRentals(id , name , phone , date , checkout , notes) ;
                infoRentals.add(info);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return infoRentals;
    }
    public void addNewInfo (InfoRentals info) {
        String sql = "insert into rentals (name, phone, date, checkOut, note) values (? ,? ,?,?,?) ;" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, info.getName());
            preparedStatement.setString(2, info.getPhone());
            preparedStatement.setString(3, info.getDate());
            preparedStatement.setString(4,info.getPayment());
            preparedStatement.setString(5,info.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        RentalsService rentalsService = new RentalsService();
        InfoRentals info = new InfoRentals("user6" , "0987876543" , "2024-10-18" ,"Monthly" , "not nate") ;
        rentalsService.addNewInfo(info);

    }
}
