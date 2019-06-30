package com.program.servlet;

import com.program.dao.AdminDAO;
import com.program.entity.Admin;
import com.program.entity.Student;
import com.program.util.JSONUtil;
import com.program.util.WriteUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAdminStatus(req, resp);
    }

    private void getAdminStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("utf-8");
        JSONObject jsonObject = JSONUtil.getJson(req);

        String name = String.valueOf(jsonObject.get("name"));
        String pwd = String.valueOf(jsonObject.get("password"));

        //生成管理员对象
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(pwd);

        AdminDAO dao = new AdminDAO();
        List<Admin> list = dao.getStudentInfo(admin);

        Map<String, Object> map = new HashMap<>();
        if (list.size() != 0) {
            map.put("status", "s");
        } else {
            map.put("status", "f");
        }
        map.put("info", list);
        WriteUtil.writeJSON(resp, map);
    }
}
