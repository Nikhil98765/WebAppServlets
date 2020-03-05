package com.java.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class RollNumberFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String rollNumber = servletRequest.getParameter("rollNo");
        String searchRollNumber = servletRequest.getParameter("SearchRollNo");


        if((searchRollNumber == null && !isValid(rollNumber)) || (rollNumber == null && !isValid(searchRollNumber))){
            PrintWriter out = servletResponse.getWriter();
            out.print("not valid roll number");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }

    private boolean isValid(String number) {
        char[] numbers = number.toCharArray();
        if((numbers[0] == 'R' || numbers[0] == 'r') && (numbers[1] == 'N' || numbers[1] == 'n')){
            for(int i =2; i<numbers.length; i++){
                if(!Character.isDigit(numbers[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
