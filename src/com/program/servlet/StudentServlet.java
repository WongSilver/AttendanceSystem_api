package com.program.servlet;

import com.program.dao.StudentDAO;
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

@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("login".equals(method)) {
            getStatus(req, resp);
        }

    }

    private void getStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = JSONUtil.getJson(req);
        String uNum = (String) json.get("name");
        String password = (String) json.get("password");

        //生成学生对象
        Student student = new Student();
        student.setuNum(uNum);
        student.setPassword(password);

        //获取学生信息
        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.getStudentInfo(student);

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
