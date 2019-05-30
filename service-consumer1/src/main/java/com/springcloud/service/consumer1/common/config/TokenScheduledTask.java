package com.springcloud.service.consumer1.common.config;

/**
 * @name: TokenScheduledTask
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-28 09:53
 **/
/*
@Component
public class TokenScheduledTask {

    private static Logger logger = LogManager.getLogger(TokenScheduledTask.class);

    //20小时
    private final static long ONE_MINTUE = 60 * 1000 * 60 * 20;

    @Autowired
    private AuthService authService;

    @Scheduled(fixedDelay = ONE_MINTUE)
    public void reloadApiToken() {

        String token = this.getToken();
        while (StringUtils.isBlank(token)) {
            try {
                Thread.sleep(1000);
                token = getToken();
            } catch (InterruptedException e) {
                logger.info("thread sleep error", e);
                e.printStackTrace();
            }
        }
        System.setProperty("${spring.application.name}.auth.token", token);

    }

    private String getToken() {
        AuthQuery authQuery = new AuthQuery("ABCDEFGHIJKLMN", "abcdefghijklmn");
        String token = authService.getToken(authQuery);
        return token;
    }
}*/
