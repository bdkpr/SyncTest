package com.custom;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wavemaker.runtime.security.WMAuthentication;
import com.wavemaker.runtime.security.authority.SimpleGrantedAuthority;
import com.wavemaker.runtime.security.handler.WMAuthenticationSuccessHandler;

public class CustomSuccessHandler implements WMAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(CustomSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, WMAuthentication wmAuthentication) throws IOException, ServletException {
        Collection<SimpleGrantedAuthority> authorities = wmAuthentication.getAuthorities();
        logger.info("adding cutom admin role for user {}", wmAuthentication.getUserId());
        authorities.add(new SimpleGrantedAuthority("custom_admin"));
    }
}
