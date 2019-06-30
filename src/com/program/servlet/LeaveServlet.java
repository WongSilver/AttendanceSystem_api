package com.program.servlet;

import com.program.dao.LeaveDAO;
import com.program.entity.Leave;
import com.program.util.JSONUtil;
import com.program.util.WriteUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LeaveServlet")
public class LeaveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("AddLeave".equals(method)) {
            addLeave(req, resp);
        } else if ("showLeaveList".equals(method)) {
            showLeaveList(req, resp);
        } else if ("updateLeave".equals(method)) {
            updateLeave(req, resp);
        }
    }

    private void updateLeave(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = JSONUtil.getJson(req);
//        System.out.println(json);
        LeaveDAO dao = new LeaveDAO();
        Leave leave = new Leave();
        leave.setId(json.getInt("id"));
        leave.setStatus(json.getInt("status"));
        boolean b = dao.updateLeave(leave);
        WriteUtil.writeTorF(resp, b);

    }

    private void showLeaveList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = JSONUtil.getJson(req);
        Leave leave = new Leave();
        leave.setStudent_id(json.getInt("student_id"));

        LeaveDAO dao = new LeaveDAO();
        List<Leave> leaveList = dao.getLeaveList(leave);
        WriteUtil.writeJSON(resp, leaveList);
    }

    private void addLeave(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = JSONUtil.getJson(req);
        Leave leave = new Leave();
//        System.out.println(json);
        leave.setStudent_id(json.getInt("student_id"));
        leave.setStart(json.getString("start"));
        leave.setEnd(json.getString("end"));
        leave.setStatus(json.getInt("status"));
        leave.setType(json.getString("type"));
        leave.setContext(json.getString("context"));

        LeaveDAO dao = new LeaveDAO();
        boolean b = dao.addLeave(leave);
        WriteUtil.writeTorF(resp, b);
    }
}
