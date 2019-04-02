package com.springcloud.service.consumer1.controller;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import com.springcloud.service.consumer1.service.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

@RestController
@RequestMapping("/consumer1")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplateOne;
    @Autowired
    private RestTemplate restTemplateTwo;
    @Autowired(required = false)
    private FeignInterface feignInterface;

//    @HystrixCommand(fallbackMethod = "defaultCallHome" )
    @GetMapping("/feign")
    public String feignCall() {
        String str = feignInterface.callHome();
        return str;
    }

    public String defaultCallHome() {
        return "fail：调用失败，执行回退";
    }

    @GetMapping("/home")
    public String callHome() {

        //直接调用服务接口
//        String url1 = "http://localhost:8001/service/home";
//        String str1 = restTemplateOne.getForObject(url1, String.class);

        //通过Eureka来调用服务接口
        String url2 = "http://sakila-service1/service/port";
        String str2 = restTemplateTwo.getForObject(url2, String.class);
        System.out.println("调用结果 " + str2);

        return "调用结果 " + str2;
    }

    @GetMapping("/remote")
    public String remoteCall() {
        //直接调用服务接口
        String url1 = "http://localhost:8001/service/ribbon";
        String url2 = "http://localhost:8002/service/ribbon";
        String str1 = restTemplateOne.getForObject(url1, String.class);
        String str2 = restTemplateOne.getForObject(url2, String.class);

        return str1 + "----------" + str2;
    }


    /**
     * ribbon 单独使用负载均衡
     *
     * @return
     */
    @GetMapping("/ribbon")
    public String ribbon() {

        ArrayList<Server> serverList = Lists.newArrayList(
                new Server("localhost", 8001),
                new Server("localhost", 8002));
        //构建负载实例
        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);

        //调用5次来测试结果
        for (int i = 0; i < 5; i++) {
            String result = LoadBalancerCommand.<String>builder()
                    .withLoadBalancer(loadBalancer)
                    .build()
                    .submit(new ServerOperation<String>() {
                        @Override
                        public Observable<String> call(Server server) {
//                            String address = "http://" + server.getHost() + ":" + server.getPort();
                            String address = "http://" + server.getHost() + ":" + server.getPort() + "/service/home";
                            System.out.println("调用地址：" + address);
                            String body = "";
                            try {
                                URL url = new URL(address);
                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                connection.connect();
                                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                    InputStream is = connection.getInputStream();
                                    StringBuffer sb = new StringBuffer();
                                    byte[] buffer = new byte[1024];
                                    int len = 0;
                                    while ((len = is.read(buffer)) != -1) {
                                        String str = new String(buffer, Charset.forName("utf-8"));
                                        sb.append(str);
                                    }
                                    body = sb.toString();
                                    is.close();
                                    connection.disconnect();
                                }
                                return Observable.just(body);
                            } catch (Exception e) {
                                return Observable.error(e);
                            }
                        }
                    }).toBlocking().first();
            System.out.println("调用结果：" + result);
        }
        return null;
    }
}
