package com.springcloud.gateway.controller;

import com.springcloud.gateway.common.bean.ResultBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @name: ErrorController
 * @desc: 重写 ErrorController，返回JSON数据
 * @author: gxing
 * @date: 2019-04-09 10:37
 **/
@RestController
public class ErrorHandlerController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @GetMapping("/error")
    public ResultBean error(HttpServletRequest request, HttpServletResponse response) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> errorAttributes =
                this.errorAttributes.getErrorAttributes((WebRequest) requestAttributes, true);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if (StringUtils.isNotBlank(trace)) {
            message += String.format(" and trace %s", trace);
        }

        return new ResultBean().setFailCodeAndState().setMsg(message);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}