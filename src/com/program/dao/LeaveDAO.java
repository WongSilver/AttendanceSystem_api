package com.program.dao;

import com.program.entity.Leave;
import com.program.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
    public boolean addLeave(Leave leave) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into leave_tb(`student_id`,`start`,`end`,`type`,`context`) value (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, leave.getStudent_id());
            preparedStatement.setString(2, leave.getStart());
            preparedStatement.setString(3, leave.getEnd());
            preparedStatement.setString(4, leave.getType());
            preparedStatement.setString(5, leave.getContext());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return false;
    }

    public List<Leave> getLeaveList(Leave leave) {
        List<Leave> leaves = new ArrayList<>();

        String sql = "select * from leave_tb ,student_tb  where student_tb.id=leave_tb.student_id ";
        if (leave.getStudent_id() != 0) {
            sql += " and student_tb.id= ?";
        }
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (leave.getStudent_id() != 0) {
                preparedStatement.setInt(1, leave.getStudent_id());
            }
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Leave l = new Leave();
                l.setId(set.getInt("id"));
                l.setStudent_id(set.getInt("student_id"));
                l.setStart(set.getString("start"));
                l.setEnd(set.getString("end"));
                l.setType(set.getString("type"));
                l.setContext(set.getString("context"));
                l.setStatus(set.getInt("status"));
                l.setRemark(set.getString("remark"));
                l.setPs(set.getString("uName"));
                leaves.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return leaves;
    }

    public boolean updateLeave(Leave leave) {
        Connection connection = DBUtil.getConnection();
        String sql = "update leave_tb set status = ? where `id` = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, leave.getStatus());
            preparedStatement.setInt(2, leave.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return false;
    }
}
