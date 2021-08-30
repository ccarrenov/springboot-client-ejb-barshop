package com.barshop.app.web.client.ejb;

import java.text.MessageFormat;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barshop.app.web.properties.JbossEJBClientProperties;

public class WildflyEJBContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(WildflyEJBContext.class);

    public Context context( JbossEJBClientProperties ejbProperties ) throws NamingException {
        LOGGER.info("init context");
        LOGGER.info("jboosEJBClientProperties: {}", ejbProperties);

        String host = ejbProperties.getEnv().getProperty("remote.connections");
        String port = ejbProperties.getEnv().getProperty("remote.connection.default.port");
        String user = ejbProperties.getEnv().getProperty("remote.connection.default.username");
        String pass = ejbProperties.getEnv().getProperty("remote.connection.default.password");
        LOGGER.info("remote.connections: {}", host);
        LOGGER.info("remote.connection.default.port: {}", port);
        LOGGER.info("remote.connection.default.username: {}", user);

        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
        jndiProperties.put(Context.SECURITY_PRINCIPAL, user);
        jndiProperties.put(Context.SECURITY_CREDENTIALS, pass);
        jndiProperties.put("jboss.naming.client.ejb.context", false);
        LOGGER.info("finish context");
        return new InitialContext(jndiProperties);
    }

    public <X, Y> String getFullName( Class<X> classRemoteType, Class<Y> classBeanType ) {
        LOGGER.info("init getFullName");
        StringBuilder fullName = new StringBuilder();
        String namespace = "ejb:";
        String appName = "";
        String moduleName = "wildfly-ejb-remote-barshop";
        final String distinctName = "";
        String beanName = classBeanType.getSimpleName();
        String viewClassName = classRemoteType.getName();
        fullName.append(namespace).append(appName).append("/").append(moduleName).append("/").append(distinctName).append("/").append(beanName).append("!").append(viewClassName);
        LOGGER.info("finish getFullName");
        String message = MessageFormat.format("fullName -> {0}", fullName);
        LOGGER.info(message);
        return fullName.toString();
    }
}
