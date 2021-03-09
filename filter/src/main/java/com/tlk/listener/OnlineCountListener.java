package com.tlk.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

//统计网站在线人数 ： 统计Session
public class OnlineCountListener implements HttpSessionListener {

    //创建session监听
    //一旦创建session就会触发这个事件
    public void sessionCreated(HttpSessionEvent se){
        ServletContext ctx = se.getSession().getServletContext();

        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }

        ctx.setAttribute("OnlineCount" , onlineCount);
    }

    //销毁session监听
    //一旦销毁session就会触发这个事件
    public void sessionDestroyer(HttpSessionEvent se){

        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }

        ctx.setAttribute("OnlineCount" , onlineCount);
    }
}
