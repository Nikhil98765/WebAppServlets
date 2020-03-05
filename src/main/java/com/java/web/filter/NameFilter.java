package com.java.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class NameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(((HttpServletRequest)servletRequest).getMethod().equals("POST")){
            String studentName = servletRequest.getParameter("name").toLowerCase();
            if (!isValidName(studentName)) {
                PrintWriter out = servletResponse.getWriter();
                out.print("not valid name");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }

    private boolean isValidName(String name){
        for(int i = 0; i<name.length(); i++){
            if(!Character.isLetter(name.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
