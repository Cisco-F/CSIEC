package com.example.csiec.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.csiec.pojo.Result;
import com.example.csiec.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter {
    public void doFilter(ServletRequest servletRequest, ServletRequest servletResponse, FilterChain filterChain) throws IOException, ServletException{
        log.info("登录检查过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        log.info("请求的url为：{}", url);

        if(url.contains("login")){
            log.info("登录操作，直接放行");
            filterChain.doFilter(request, response);
            return;
        } else if (url.contains("register")) {
            log.info("注册操作，直接放行");
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("token为空！！");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(error.toString());
            return;
        }

        try{
            JwtUtils.parseJwt(jwt);
        } catch (Exception e){
            e.printStackTrace();
            log.info("令牌无效");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        log.info("令牌有效");
        filterChain.doFilter(request, response);
    }
}
