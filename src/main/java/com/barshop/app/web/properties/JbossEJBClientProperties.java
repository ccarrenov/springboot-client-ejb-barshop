package com.barshop.app.web.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;


@Getter
public class JbossEJBClientProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(JbossEJBClientProperties.class);

    private Properties prop;

    public JbossEJBClientProperties() {
        LOGGER.info("init JbossEJBClientProperties");
        String jbossEJBClientFile = "jboss-ejb-client.properties";
        this.prop = new Properties();
        try (InputStream jbossEJBClient = this.getClass().getClassLoader().getResourceAsStream(jbossEJBClientFile)){
            prop.load(jbossEJBClient);
        } catch (IOException e) {
            String error = "Error load " + jbossEJBClientFile;
            LOGGER.warn(error);
        }
        
        LOGGER.info("finish JbossEJBClientProperties");        
    }
    

}
