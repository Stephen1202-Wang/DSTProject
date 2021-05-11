package com;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginF extends OncePerRequestFilter{
    private String n;
    private String p;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        n = "王健强";
        p = "zhenshen";
        String name = httpServletRequest.getParameter("name");
        String key = httpServletRequest.getParameter("key");
        if (name.equals(n) && key.equals(p)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        else{
            httpServletResponse.sendRedirect("error.do");
        }
    }
}

