package com.tlk.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {


        PrintWriter out = resp.getWriter();

        //cookie 服务器端丛客户端获取
        Cookie[] cookies = req.getCookies();

        //判断cookie是否存在
        if (cookies.length != 0) {
            out.write("Time of your last come is :");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastlogintime")) {
                    long lastlogintime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastlogintime);
                    out.write(date.toString());
                }
            }
        } else {
            out.write("This is your first come");
        }

        //服务端给客户端相应一个cookie

        Cookie cookie = new Cookie("lastlogintime", System.currentTimeMillis() + "");
        //有效期为1天
        cookie.setMaxAge(24 * 60 * 60);

        resp.addCookie(cookie);
    }
}
