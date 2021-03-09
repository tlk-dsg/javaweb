package com.tlk.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws jakarta.servlet.ServletException {
        System.out.println("Init");
    }

    @Override
    public void doFilter(jakarta.servlet.ServletRequest servletRequest, jakarta.servlet.ServletResponse servletResponse, jakarta.servlet.FilterChain filterChain) throws IOException, jakarta.servlet.ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("CharacterEncodingFilter 执行后");

    }
    @Override
    public void destroy() {
        System.out.println("Destroy");

    }
}
