package com.world.rest.dao;

import com.world.rest.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.net.ConnectException;

@Repository
public interface CountryDao extends CrudRepository<Country, Long> {
    Country findCountryByCode(String code);
}
