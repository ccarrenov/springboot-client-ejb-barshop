package com.barshop.app.web.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.barshop.app.web.service.CountryEJBService;

import lombok.Getter;

@Import(CountryEJBService.class) /* add this line to aggrgate java configuration classes*/
@Configuration
@Component
@PropertySource("classpath:application.properties")
@Getter
public class ApplicationProperties {

    @Autowired
    private Environment env;

}
