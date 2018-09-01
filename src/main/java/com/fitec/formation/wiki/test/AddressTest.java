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
        ad01.setStreet("street01");
        ad01.setCity("city01");
        ad01.setZipcode("zc01");
        ad01.setCountry("country01");
        addresses.add(ad01);

        final Address ad02 = new Address();
        ad02.setStreet("street02");
        ad02.setCity("city02");
        ad02.setZipcode("zc02");
        ad02.setCountry("country02");
        addresses.add(ad02);

        final Address ad03 = new Address();
        ad03.setStreet("street03");
        ad03.setCity("city03");
        ad03.setZipcode("zc03");
        ad03.setCountry("country03");
        addresses.add(ad03);

        System.out.println("initAddressTestSuite() = " + !addresses.isEmpty());
        return addresses;
    }
}
