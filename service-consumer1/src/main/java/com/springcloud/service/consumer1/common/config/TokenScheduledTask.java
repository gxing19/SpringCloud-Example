package com.springcloud.service.consumer1.common.config;

import com.springcloud.commons.bean.JwtToken;
import com.springcloud.commons.bean.ResultBean;
import com.springcloud.service.consumer1.entity.query.AuthQuery;
import com.springcloud.service.consumer1.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @name: TokenScheduledTask
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-28 09:53
 **/
@Component
public class TokenScheduledTask {

    @Autowired
    private AuthQuery authQuery;
    private static Logger logger = LogManager.getLogger(TokenScheduledTask.class);

    //20小时,token默认有效期是24小时
    private final static long DELAY = 1000 * 60 * 60 * 20;

    @Autowired(required = false)
    private AuthService authService;

    @Scheduled(fixedDelay = DELAY)
    public void reloadAuthToken() {
        JwtToken jwtToken = this.getToken();
        while (null == jwtToken) {
            try {
                Thread.sleep(1000);
                jwtToken = getToken();
            } catch (InterruptedException e) {
                logger.info("thread sleep error", e);
                e.printStackTrace();
            }
        }
        System.setProperty("jwtId", jwtToken.getJwtId());
        System.setProperty("token", jwtToken.getToken());

    }

    private JwtToken getToken() {
        ResultBean result = authService.getToken(authQuery);
        LinkedHashMap<String, String> resultDate = (LinkedHashMap<String, String>) result.getDate();
        if (null == resultDate) {
            return null;
        }
        return new JwtToken(resultDate.get("jwtId"), resultDate.get("token"));
    }
}
