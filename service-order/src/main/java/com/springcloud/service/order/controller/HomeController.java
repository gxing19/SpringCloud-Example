package com.springcloud.service.order.controller;

/**
 * @desc:
 * @author: gxing
 * @date: 2019/2/27 8:36
 * @param:
 * @return:
 **/
/*@RestController
@RequestMapping("/service")
public class HomeController {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment environment;


    @GetMapping("/home")
    public String home() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("sakila-service2", false);
        String hostName = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        String appName = instanceInfo.getAppName();
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();

        *//*List<ServiceInstance> instances = discoveryClient.getInstances("eureka-server");
        String property1 = environment.getProperty("spring.cloud.client.hostname");
        String property2 = environment.getProperty("spring.application.instance_id");
        String[] activeProfiles = environment.getActiveProfiles();
        String string = property1 + property2;*//*


        return hostName + port + appName;
    }

    @GetMapping("/ribbon")
    public String ribbon(){
        return "service2 ribbon";
    }
}*/
