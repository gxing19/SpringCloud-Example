package com.springcloud.service.user.component.filter;

import com.alibaba.fastjson.JSON;
import com.springcloud.service.user.common.util.JWTUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: HttpBasicAuthFilter
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 17:23
 **/
public class HttpBasicAuthFilter implements Filter {

    JWTUtils jwtUtils = JWTUtils.getInstance();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader("Authorization");

        Map<String, String> resultMap = new HashMap<>();
        PrintWriter printWriter = response.getWriter();
        //Toke验证
        if (StringUtils.isBlank(token)) {
            resultMap.put("state", "fail");
            resultMap.put("code", "400");
            printWriter.write(JSON.toJSONString(printWriter));

            return;
        }

        JWTUtils.JWTResult jwtResult = jwtUtils.checkToken(token);
        if (!jwtResult.isStatus()) {
            resultMap.put("state", "fail");
            resultMap.put("code", "400");
            resultMap.put("msg", jwtResult.getMsg());
            printWriter.write(JSON.toJSONString(printWriter));
            return;
        }
        filterChain.doFilter(request, response);
    }
}