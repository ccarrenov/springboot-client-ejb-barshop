package com.barshop.app.web.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barshop.app.ejb.remote.CountryEJBRemote;
import com.barshop.app.models.dto.Country;
import com.barshop.app.web.client.ejb.EJBClient;
import com.barshop.app.web.properties.JbossEJBClientProperties;

@Service
public class CountryEJBService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryEJBService.class);

    @Autowired
    private JbossEJBClientProperties ejbProperties;

    private CountryEJBRemote countryRemote;

    public void connect() {
        this.countryRemote = EJBClient.getInstance(ejbProperties).getCountryEJBRemote();
    }

    public List<Country> findAll() {
        LOGGER.info("findAll");
        try {
            connect();
            return countryRemote.findAll();
        } catch (Exception ex) {
            LOGGER.error("Error findAll", ex);
            return new ArrayList<>();
        }
    }

    public void save( Country country ) {
        LOGGER.info("findAll");
        try {
            connect();
            countryRemote.createOrUpdate(country);
        } catch (Exception ex) {
            LOGGER.error("Error findAll", ex);
        }
    }
    
    public void update( Country country ) {
        LOGGER.info("update");
        try {
            connect();
            countryRemote.createOrUpdate(country);
        } catch (Exception ex) {
            LOGGER.error("Error update", ex);
        }
    }    

    public void deleteById( long id ) {
        LOGGER.info("delete");
        try {
            connect();
            countryRemote.deleteById(id);
        } catch (Exception ex) {
            LOGGER.error("Error delete", ex);
        }
    }

}
