package com.program.util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JSONUtil {
    public static JSONObject getJson(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        return JSONObject.fromObject(s);
    }
}
