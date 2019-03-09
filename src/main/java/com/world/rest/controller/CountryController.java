package com.world.rest.controller;

import com.world.rest.entity.Country;
import com.world.rest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * Get country information according to its code
     * @param code counry code can be ( EGY / BHR / ... )
     * @return
     */
    @GetMapping("{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {

        // getting country using service layer
        Country country = countryService.getCountryByCode(code);

        // handle invalid codes
        if (country == null) {
            return new ResponseEntity("INVALID_COUNTRY_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(country, HttpStatus.OK);
    }

    @GetMapping
    public Object index() {

        return "API RUNNING !";
    }
}
