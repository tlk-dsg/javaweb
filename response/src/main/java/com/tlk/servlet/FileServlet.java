package com.tlk.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取下载文件路径

        String realPath = "/Users/taoliankuan/Desktop/javaweb/response/target/classes/test.png";
        System.out.println("Path: " + realPath );
        //2、下载文件名
        String filename = realPath.substring(realPath.lastIndexOf("//") + 1);
        //3、让浏览器支持下载需要的东西
        resp.setHeader("Content-Disposition","attachment;filename=" + filename);
        //4、获取下载问价输入流
        FileInputStream in = new FileInputStream(realPath);
        //5、创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6、获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7、fileoutputstream流写入到缓冲区
        while(( len = in.read(buffer)) > 0){
            out.write(buffer , 0 , len);
        }
        in.close();
        out.close();
        //8、使用OutputStream将缓冲区中的数据输出到客户端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}