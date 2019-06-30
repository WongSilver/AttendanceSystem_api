package com.program.dao;

import com.program.entity.Student;
import com.program.entity.Teacher;
import com.program.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
//    public boolean getStatus(Teacher teacher) {
//        Connection connection = DBUtil.getConnection();
//        String sql = "select * from teacher_tb where `uNum` = ? and password = ? ";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, teacher.getuNum());
//            preparedStatement.setString(2, teacher.getPassword());
//            ResultSet set = preparedStatement.executeQuery();
//            if (set.next()) {
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭数据库
//            DBUtil.closeConnection(connection);
//        }
//        return false;
//    }

    public List<Teacher> getStudentInfo(Teacher teacher) {
        List<Teacher> list = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from teacher_tb where `uNum` = ? and password = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, teacher.getuNum());
            preparedStatement.setString(2, teacher.getPassword());
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Teacher t = new Teacher();
                t.setId(set.getInt("id"));
                t.setuNum(set.getString("uNum"));
                t.setuName(set.getString("uName"));
                t.setPassword(set.getString("password"));
                t.setClass_id(set.getInt("class_id"));
                t.setSex(set.getInt("sex"));
                t.setPhone(set.getString("phone"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return list;
    }
}
