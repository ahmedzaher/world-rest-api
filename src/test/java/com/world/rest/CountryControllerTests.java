package com.world.rest;

import com.world.rest.controller.CountryController;
import com.world.rest.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
public class CountryControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void invalidCodeTest() {
        try {
            // simulate service response in case of invalid code
            when(countryService.getCountryByCode("invalidCode")).thenReturn(null);

            mvc.perform(get("/invalidCode"))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().string("INVALID_COUNTRY_CODE"))
            ;
        } catch (Exception e) {

        }

    }

    @Test
    public void databaseDownTest() {
        try {
            // simulate service response in case of database down
            when(countryService.getCountryByCode(anyString()))
                    .thenThrow(new DataAccessResourceFailureException("INTERNAL_ERROR"));

            mvc.perform(get("/BHR"))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().string("INTERNAL_ERROR"))
            ;
        } catch (Exception e) {

        }

    }

}
