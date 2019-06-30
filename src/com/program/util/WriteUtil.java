package com.program.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteUtil {
    public static void writeTorF(HttpServletResponse resp, boolean status) {
        JSONObject object = new JSONObject();
        resp.setCharacterEncoding("utf-8");
        try {
            object.put("status", status);
//            System.out.println(object.toString());
            resp.getWriter().write(object.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJSON(HttpServletResponse resp, List<?> list) {
        resp.setCharacterEncoding("utf-8");
        JSONArray jsonArray = JSONArray.fromObject(list);
        try {
            resp.getWriter().write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJSON(HttpServletResponse resp, Map<String, Object> map) {
        resp.setCharacterEncoding("utf-8");
        JSONObject jsonObject = JSONObject.fromObject(map);
        try {
            resp.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
