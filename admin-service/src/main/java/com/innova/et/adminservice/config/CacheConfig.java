package com.innova.et.adminservice.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() throws Exception {
        return new JCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public JCacheManagerFactoryBean ehCacheCacheManager() throws Exception {
        JCacheManagerFactoryBean cmfb = new JCacheManagerFactoryBean();
        cmfb.setCacheManagerUri(new ClassPathResource("ehcache.xml").getURI());
//        cmfb.setShared(true);
        return cmfb;
    }
}
