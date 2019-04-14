package com.springcloud.gateway.common.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @name: CustomPreFilter
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-08 17:03
 **/
public class CustomPreIpFilter extends ZuulFilter {

    public CustomPreIpFilter() {
        super();
    }

    @Autowired
//    private IpBlacklistConfig ipBlacklistConfig;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    //示否执行该过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        String remoteHost = request.getRemoteHost();
        System.out.println(remoteHost);

        System.out.println(10/0);

        /*String ip = IpUtil.getIpAdd(ctx.getRequest());
        if(StringUtils.isNotBlank(ip) && ipBlacklistConfig.ipExist(ip)){
            //不转发
            ctx.setSendZuulResponse(false);

            BeanResult beanResult = new BeanResult("fail").setMsg("非法请求", ResultCode.NO_AUTH_CODE);
            ctx.setResponseBody(JSON.toJSONString(beanResult));
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            return null;
        }*/
        return null;
    }
}