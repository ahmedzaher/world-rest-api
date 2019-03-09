package com.world.rest.service;

import com.world.rest.dao.CountryDao;
import com.world.rest.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country getCountryByCode(String code) {
        return countryDao.findCountryByCode(code);
    }
}
