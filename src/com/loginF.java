package com;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class loginF extends OncePerRequestFilter{
    private String name = null;
    private String key = null;
    private UserDao userDao=new UserDao();
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getServletPath().equals("/register.do")) {
             User user=new User();
             name=httpServletRequest.getParameter("name");
             key=httpServletRequest.getParameter("key");
             List<User> users = userDao.findAll();
             for (User i :users){
                 if (i.getUsername().equals(name)){
                     httpServletResponse.sendRedirect("error2.do");
                     break;
                 }
             }
             user.setUsername(name);
             user.setKey_value(key);
             userDao.saveUser(user);
             filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        else{
            boolean connected=false;
            if (httpServletRequest.getParameter("name")!=null) {
                name = httpServletRequest.getParameter("name");
            }
            if (httpServletRequest.getParameter("key")!=null){
                key = httpServletRequest.getParameter("key");
            }
            List<User> users= userDao.findAll();
            //users.stream().forEach(x -> {
            for (User x : users) {
                if (name.equals(x.getUsername()) && key.equals(x.getKey_value())) {
                    connected = true;
                    break;
                }
            }
            if (!connected) {
                name = null;
                key = null;
                httpServletResponse.sendRedirect("error.do");
            } else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }
    }
}

