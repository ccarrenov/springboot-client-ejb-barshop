package com.barshop.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barshop.app.models.dto.Country;
import com.barshop.app.web.client.ejb.CountryEJBClient;

@Controller
@RequestMapping(value = "/country")
public class CountryController {

    private static final Logger LOGGER = Logger.getLogger(CountryController.class);

    private static final String COUNTRY_VIEW = "country";

    @Autowired
    private CountryEJBClient countryEJBClient;
    
    CountryController(){
        
    }    

    @GetMapping(value = "")
    public String showView( Model model ) {
        LOGGER.info("init showView");
        model.addAttribute("country", new Country());
        List<Country> countries = new ArrayList<>();
        model.addAttribute("countries", countries); 

        // model.addAttribute("books", countryEJBClient.getCountryEJBRemote().findAll());

        LOGGER.info("finish showView");
        return COUNTRY_VIEW;
    }

    @PostMapping(value = "/create")
    public String create( @ModelAttribute("country") Country country, ModelMap model ) {
        LOGGER.info("init showView");
        LOGGER.info(country);
        countryEJBClient.getCountryEJBRemote().save(country);
        List<Country> countries = countryEJBClient.getCountryEJBRemote().findAll();
        model.addAttribute("countries", countries);

        LOGGER.info("finish showView");
        return COUNTRY_VIEW;
    }

}
