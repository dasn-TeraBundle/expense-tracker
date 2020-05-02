package com.innova.et.adminservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.core.DelegatingEntityLinks;
import org.springframework.plugin.core.support.PluginRegistryFactoryBean;

@Configuration
public class HateoasConfig {

    @Bean
    @Primary
    PluginRegistryFactoryBean<EntityLinks, Class<?>> discovers() {
        PluginRegistryFactoryBean<EntityLinks, Class<?>> registry = new PluginRegistryFactoryBean();
        registry.setType(EntityLinks.class);
        registry.setExclusions(new Class[]{DelegatingEntityLinks.class});
        return registry;
    }

}
