package com.tlk.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器2s自动刷新一次
        resp.setHeader("refresh" , "2");

        //创建图片
        BufferedImage image = new BufferedImage(200 , 40 , BufferedImage.TYPE_INT_RGB);

        //得到图片
        Graphics g = (Graphics2D) image.getGraphics();
        //设置图片背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,200,40);
        //给图片写入数据
        g.setColor(Color.green);
        g.setFont(new Font(null, Font.BOLD , 40));
        g.drawString(MakeNum() , 0 , 40);
        //告诉浏览器，这个请求用图片方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires" , -1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //图片写给浏览器
        boolean write = ImageIO.write(image ,"jpg" , resp.getOutputStream());
        if(write){
            System.out.println("OK!");
        }
        else {
            System.out.println("Error...");
        }

    }

    //生成随机数
    private String MakeNum(){
        Random random = new Random();
        String num = String.valueOf(random.nextInt(99999999));
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i < 8 - num.length() ; i++){
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }
}
