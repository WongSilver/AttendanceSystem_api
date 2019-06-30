package com.program.dao;

import com.program.entity.Admin;
import com.program.entity.Student;
import com.program.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public boolean getStatus(Admin admin) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from admin_tb where `name` = ? and password = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return false;
    }

    public List<Admin> getStudentInfo(Admin admin) {
        List<Admin> list = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from admin_tb where `name` = ? and password = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Admin a = new Admin();
                a.setId(set.getInt("id"));
                a.setName(set.getString("name"));
                a.setPassword(set.getString("password"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return list;
    }
}
