package com.springcloud.service.consumer1.controller;

import com.google.common.collect.Lists;
import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RetryHandler;
import com.netflix.loadbalancer.*;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.aspectj.weaver.ast.Var;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * @name: RibbonController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-11 11:16
 **/
@RestController
@RequestMapping("/ribbon")
public class LoadBalanceController {

    private ILoadBalancer loadBalancer;

    private final RetryHandler retryHandler = new DefaultLoadBalancerRetryHandler(0, 1, true);

    /**
     * @desc: Ribbon 原生负载均衡
     * @author: gxing
     * @date: 2019/3/11 11:20
     * @param: []
     * @return: void
     **/
    @RequestMapping("/loadbalance")
    public void ribbonNativeLoadBalance() {

        ArrayList<Server> serverList = Lists.newArrayList(
                new Server("www.taobao.com", 80),
                new Server("www.baidu.com", 80),
                new Server("www.jd.com", 80));

        loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
        for (int i = 0; i < 6; i++) {
            String str = this.call("/");
            System.out.println(str);
        }

        LoadBalancerStats loadBalancerStats = ((BaseLoadBalancer) loadBalancer).getLoadBalancerStats();
        System.out.println("=== Load balancer stats ===");
        System.out.println(loadBalancerStats);

    }

    public String call(final String path) {
        return LoadBalancerCommand.<String>builder()
                .withLoadBalancer(loadBalancer)
                .build()
                .submit(new ServerOperation<String>() {
                    @Override
                    public Observable<String> call(Server server) {
                        URL url;
                        try {
                            url = new URL("http://" + server.getHost() + ":" + server.getPort() + path);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            return Observable.just(conn.getResponseMessage());
                        } catch (Exception e) {
                            return Observable.error(e);
                        }
                    }
                }).toBlocking().first();
    }
}
