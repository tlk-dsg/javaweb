package com.tlk.servlet;

import com.tlk.pojo.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //得到Session
        HttpSession session = req.getSession();

        //Session中存入东西
        session.setAttribute("name",new Person("tlk" ,22));

        //获取Session的Id
        String sessionId = session.getId();

        //判断Session是否新创建
        if( session.isNew() ){
            resp.getWriter().write("Session is created,ID:" + sessionId);
        }else{
            resp.getWriter().write("Session has been existed,ID:" + sessionId);
        }


    }
}
