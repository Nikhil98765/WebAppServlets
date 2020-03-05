package com.java.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ConverterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            filterChain.doFilter(servletRequest, servletResponse);


            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;

            String content = req.getHeader("Accept");
            Object info = servletRequest.getAttribute("info");
            PrintWriter out = res.getWriter();

            switch (content) {
                case "application/json":
                    ObjectMapper ob = new ObjectMapper();
                    Object json = ob.writeValueAsString(info);
                    res.setContentType(content);
                    out.print(json);
                    break;
                case "application/xml":
                    XmlMapper xmlOb = new XmlMapper();
                    Object xml = xmlOb.writeValueAsString(info);
                    res.setContentType(content);
                    out.print(xml);
                    break;
                default:
                    out.print(info);

            }



    }

    @Override
    public void destroy() {

    }
}
