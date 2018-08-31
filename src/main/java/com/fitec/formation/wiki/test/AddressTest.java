package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressTest {

    public List<Address> initAddressTestSuite() {
        List<Address> addresses = new ArrayList<>();

        final Address ad01 = new Address();
        ad01.setStreet("Boulevard of the dependence01");
        ad01.setCity("Simcity01");
        ad01.setZipcode("12341234");
        ad01.setCountry("Simcountry01");
        addresses.add(ad01);

        final Address ad02 = new Address();
        ad02.setStreet("Boulevard of the dependence02");
        ad02.setCity("Simcity02");
        ad02.setZipcode("12341234");
        ad02.setCountry("Simcountry02");
        addresses.add(ad02);

        final Address ad03 = new Address();
        ad03.setStreet("Boulevard of the dependence03");
        ad03.setCity("Simcity03");
        ad03.setZipcode("12341234");
        ad03.setCountry("Simcountry03");
        addresses.add(ad03);

        System.out.println("initAddressTestSuite() = " + !addresses.isEmpty());
        return addresses;
    }
}
