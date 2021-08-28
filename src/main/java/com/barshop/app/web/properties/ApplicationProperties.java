package com.barshop.app.web.properties;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
public class ApplicationProperties {

    @Autowired
    private Properties prop;    
    

}
