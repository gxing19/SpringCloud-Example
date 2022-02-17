package com.gxitsky.config;

/**
 * @name: HazelcastConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-05 10:02
 **/
/*
@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelcastConfig() {
        MapConfig mapConfig = new MapConfig("spring-boot-admin-event-store").setInMemoryFormat(InMemoryFormat.OBJECT)
                .setBackupCount(1)
                .setEvictionPolicy(EvictionPolicy.NONE)
                .setMergePolicyConfig(new MergePolicyConfig(PutIfAbsentMapMergePolicy.class.getName(), 100));
        return new Config().setProperty("hazelcast.jmx", "true").addMapConfig(mapConfig);
    }
}*/
