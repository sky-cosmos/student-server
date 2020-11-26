package com.kaiyu.web.filter;

import com.alibaba.fastjson.JSON;
import com.kaiyu.mbg.domain.UmsAdmin;
import com.kaiyu.web.service.UmsAdminService;
import com.kaiyu.web.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author riversky
 * @date 2020/11/25
 **/
@Component
public class TokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    @Autowired
    private UmsAdminService userDetailsService;
    @Autowired
    private JwtTokenUtils jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("checking username:{}", username);
            if (username != null) {
                UmsAdmin adminByUsername = userDetailsService.getAdminByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, adminByUsername)) {
                    LOGGER.info("authenticated user:{}", username);
                    request.setAttribute("umsAdmin", adminByUsername);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
