package com.program.dao;

import com.program.entity.Student;
import com.program.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public boolean getStatus(Student student) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from student_tb where `uNum` = ? and password = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getuNum());
            preparedStatement.setString(2, student.getPassword());
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


    public List<Student> getStudentInfo(Student student) {
        List<Student> list = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from student_tb where `uNum` = ? and password = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getuNum());
            preparedStatement.setString(2, student.getPassword());
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Student s = new Student();
                s.setId(set.getInt("id"));
                s.setuNum(set.getString("uNum"));
                s.setuName(set.getString("uName"));
                s.setPassword(set.getString("password"));
                s.setCalss_id(set.getInt("class_id"));
                s.setSex(set.getInt("sex"));
                s.setPhone(set.getString("phone"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return list;
    }
}
