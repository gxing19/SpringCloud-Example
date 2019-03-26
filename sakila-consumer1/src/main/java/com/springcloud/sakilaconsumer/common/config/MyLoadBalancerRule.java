package com.springcloud.sakilaconsumer.common.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyLoadBalancerRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    @Override
    public Server choose(Object key) {
        List<Server> serverList = iLoadBalancer.getAllServers();
        for (Server server : serverList) {
            //定义选择服务策略
            //...............

            System.out.println(server.getHostPort());
        }
        return serverList.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
