package com;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginF extends OncePerRequestFilter{
    private String n = "王健强";
    private String p = "zhenshen";
    private String name = null;
    private String key = null;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getServletPath().equals("/register.do")) {
            n = httpServletRequest.getParameter("name");
            p = httpServletRequest.getParameter("key");
        }
        if (name == null) {
            name = httpServletRequest.getParameter("name");
        }
        if (key == null){
            key = httpServletRequest.getParameter("key");
        }
        if (name.equals(n) && key.equals(p)){

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        else{
            name = null;
            key = null;
            httpServletResponse.sendRedirect("error.do");
        }
    }
}

