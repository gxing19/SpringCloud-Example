package com.gxitsky.component.filter;

import com.alibaba.fastjson.JSON;
import com.gxitsky.util.JavaJwtUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: HttpTokenAuthFilter
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 17:23
 **/
public class HttpTokenAuthFilter implements Filter {

    private static Logger logger = LogManager.getLogger(HttpTokenAuthFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        String jwtId = request.getHeader("JwtId");
        String token = request.getHeader("Authorization");

        logger.info("认证过滤器,jwtId:{},token:{}", jwtId, token);

        //不合法，返回错误信息
        if (StringUtils.isBlank(token) || StringUtils.isBlank(jwtId) || !JavaJwtUtil.verifyTokenByRSA512(token, jwtId)) {
            PrintWriter printWriter = response.getWriter();
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("state", "fail");
            resultMap.put("code", "400");
            resultMap.put("msg", "认证失败");

            String resultStr = JSON.toJSONString(resultMap);
            printWriter.write(resultStr);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}