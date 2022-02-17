package com.gxitsky.controller;

import com.gxitsky.common.bean.ResultBean;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

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

    private static Logger logger = LogManager.getLogger(ErrorHandlerController.class);


    @Autowired
    private ErrorAttributes errorAttributes;

    @GetMapping("/error")
    public ResultBean error(HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入 /error 控制器............................");

        ServletWebRequest servletWebRequest = new ServletWebRequest(request);

        Map<String, Object> errorAttributes =
                this.errorAttributes.getErrorAttributes(servletWebRequest, true);

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
