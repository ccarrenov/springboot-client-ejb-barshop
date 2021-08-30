package com.barshop.app.web.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Configuration
@Component
@PropertySource("classpath:jboss-ejb-client.properties")
@Getter
public class JbossEJBClientProperties {

    @Autowired
    private Environment env;

}
