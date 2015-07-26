package com.catalog.client;

import com.catalog.model.Country;
import com.catalog.servcie.CountryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 17.07.2015.
 */
public class AddCountryAppHelper {

    CountryService countryService = new CountryService();

    public Country createCountry(String counrtyName, String countryCode){
        Country country = new Country();

        country.setName(counrtyName);
        country.setCode(countryCode);
        return country;
    }

    public boolean persist(Country country) {
        try {
            return countryService.insert(country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List <Country> show () {
        try {
            return countryService.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}
