package com.gxitsky.common.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.commons.util.JavaJwtUtil;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @name: TokenAuthPreFilter
 * @desc: 统一身份认证
 * @author: gxing
 * @date: 2019-05-31 17:12
 **/
public class TokenAuthPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String jwtId = request.getHeader("JwtId");
        String authorization = request.getHeader("Authorization");
        System.out.println("JwtId : " + jwtId);
        System.out.println("Authorization : " + authorization);
        try {
            JavaJwtUtil.verifyTokenByRSA512(authorization, jwtId);
        } catch (Exception e) {
            //必须抛出或打印出错误,才不会路由到下游服务
//            throw e;
            Throwable throwable = context.getThrowable();
            throwable.printStackTrace();
        }
        return null;
    }
}
