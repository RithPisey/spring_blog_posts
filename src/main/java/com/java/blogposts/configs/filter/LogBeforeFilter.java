package com.java.blogposts.configs.filter;

import com.java.blogposts.constants.SecurityConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogBeforeFilter extends OncePerRequestFilter {

    private final Logger LOG =
            Logger.getLogger(LogBeforeFilter.class.getName());


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LOG.info(request.getHeader(SecurityConstants.JWT_HEADER) + " <<< before validator");
        filterChain.doFilter(request, response);
    }
}
