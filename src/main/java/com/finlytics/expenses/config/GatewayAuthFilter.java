package com.finlytics.expenses.config;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GatewayAuthFilter implements Filter{

    private static final String INTERNAL_KEY = "super-secret-123";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String headerKey = httpServletRequest.getHeader("X-Internal-Key");

        if(!INTERNAL_KEY.equals(headerKey)){
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write("Unauthorized – Request not from API Gateway");
            return;
        }

        chain.doFilter(request,response);
    }

}
