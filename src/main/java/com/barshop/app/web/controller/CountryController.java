package com.barshop.app.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barshop.app.models.dto.Country;
import com.barshop.app.web.service.CountryEJBService;

@Controller
@RequestMapping(value = "/country")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private static final String COUNTRY_VIEW = "country";

    private static final String COUNTRY_MODEL = "country";

    private static final String COUNTRIES_MODEL = "countries";

    private static final String LIST_COUNTRY = "country->{}";

    @Autowired
    private CountryEJBService countryEJBService;

    @GetMapping(value = "")
    public String showView( Model model ) {
        LOGGER.info("init showView");
        model.addAttribute(COUNTRY_MODEL, new Country());
        List<Country> countries = this.countryEJBService.findAll();
        model.addAttribute(COUNTRIES_MODEL, countries);
        LOGGER.info("finish showView");
        return COUNTRY_VIEW;
    }

    @PostMapping(value = "")
    public String create( @ModelAttribute("country") Country country, ModelMap model ) {
        LOGGER.info("init create");
        LOGGER.info(LIST_COUNTRY, country);
        countryEJBService.save(country);
        List<Country> countries = this.countryEJBService.findAll();
        model.addAttribute(COUNTRIES_MODEL, countries);
        LOGGER.info("finish create");
        return COUNTRY_VIEW;
    }

    @DeleteMapping(value = "")
    public String delete( @ModelAttribute("country") Country country, ModelMap model ) {
        LOGGER.info("init delete");
        LOGGER.info(LIST_COUNTRY, country);
        countryEJBService.deleteById(country.getId());
        List<Country> countries = this.countryEJBService.findAll();
        model.addAttribute(COUNTRIES_MODEL, countries);
        LOGGER.info("finish delete");
        return COUNTRY_VIEW;
    }

    @PutMapping(value = "")
    public String update( @ModelAttribute("country") Country country, ModelMap model ) {
        LOGGER.info("init update");
        LOGGER.info(LIST_COUNTRY, country);
        countryEJBService.deleteById(country.getId());
        List<Country> countries = this.countryEJBService.findAll();
        model.addAttribute(COUNTRIES_MODEL, countries);
        LOGGER.info("finish update");
        return COUNTRY_VIEW;
    }

}
