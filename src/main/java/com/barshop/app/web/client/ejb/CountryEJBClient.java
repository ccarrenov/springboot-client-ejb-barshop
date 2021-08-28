package com.barshop.app.web.client.ejb;

import java.text.MessageFormat;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.barshop.app.ejb.remote.CountryEJBRemote;
import com.barshop.app.ejb.remote.ejb.CountryEJBBean;
import com.barshop.app.web.properties.JbossEJBClientProperties;

@Service
public class CountryEJBClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryEJBClient.class);

    private CountryEJBRemote countryEJBRemote;

    private JbossEJBClientProperties jboosEJBClientProperties;

    public CountryEJBClient() throws NamingException {
        this.jboosEJBClientProperties = new JbossEJBClientProperties();        
        Context context = context();
        this.countryEJBRemote = countryEJBRemote(context);
    }

    public CountryEJBRemote getCountryEJBRemote() {
        return countryEJBRemote;
    }

    @Bean
    public Context context() throws NamingException {
        LOGGER.info("init context");
        String host = jboosEJBClientProperties.getProp().getProperty("remote.connection.default.host");
        String port = jboosEJBClientProperties.getProp().getProperty("remote.connection.default.port");
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
        jndiProperties.put(Context.SECURITY_PRINCIPAL, jboosEJBClientProperties.getProp().getProperty("remote.connection.default.username"));
        jndiProperties.put(Context.SECURITY_CREDENTIALS, jboosEJBClientProperties.getProp().getProperty("remote.connection.default.password"));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        LOGGER.info("finish context");
        return new InitialContext(jndiProperties);
    }

    private <X, Y> String getFullName( Class<X> classRemoteType, Class<Y> classBeanType ) {
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

    @Bean
    public CountryEJBRemote countryEJBRemote( Context context ) throws NamingException {
        LOGGER.info("countryEJBRemote");
        return (CountryEJBRemote) context.lookup(this.getFullName(CountryEJBRemote.class, CountryEJBBean.class));
    }
}
