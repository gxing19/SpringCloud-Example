package com.gxitsky.common.config;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent canceledEvent){
        System.out.println("服务下线：" + canceledEvent.getServerId() + "\t" + canceledEvent.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent registeredEvent){
        InstanceInfo instanceInfo = registeredEvent.getInstanceInfo();
        System.out.println("进行注册：" + instanceInfo.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent renewedEvent){
        System.out.println("服务续约：" + renewedEvent.getServerId() + "\t" + renewedEvent.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent availableEvent){
        System.out.println("注册中心启动：");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent startedEvent){
        System.out.println("Eureka Server 启动");
    }

}
