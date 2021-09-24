package com.barshop.app.web.client.ejb;

import javax.naming.Context;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barshop.app.ejb.remote.CountryEJBRemote;
import com.barshop.app.ejb.remote.beans.CountryEJBBean;
import com.barshop.app.web.properties.JbossEJBClientProperties;

import lombok.Getter;

@Getter
public class EJBClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EJBClient.class);

    private static EJBClient instance;

    private CountryEJBRemote countryEJBRemote;

    private EJBClient(JbossEJBClientProperties ejbProperties) {
        LOGGER.info("init CountryEJBClient");
        WildflyEJBContext wildflyEJBContext = new WildflyEJBContext();
        Context context;
        try {
            context = wildflyEJBContext.context(ejbProperties);
            this.countryEJBRemote = (CountryEJBRemote) context.lookup(wildflyEJBContext.getFullName(CountryEJBRemote.class, CountryEJBBean.class));
        } catch (NamingException e) {
            LOGGER.error("Error Conexion CountryEJBRemote", e);
        }
    }

    public static EJBClient getInstance( JbossEJBClientProperties ejbProperties ) {
        if (instance == null) {
            instance = new EJBClient(ejbProperties);
        }
        return instance;
    }
    
    public static EJBClient getInstace() {
        return null;
    }

}
