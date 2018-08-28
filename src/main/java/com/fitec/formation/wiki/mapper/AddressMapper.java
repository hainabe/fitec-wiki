package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Address;
import com.fitec.formation.wiki.model.AddressModel;

public class AddressMapper {

    public static Address mapToAddress(AddressModel am) {
        Address a = new Address();
        a.setStreet(am.getStreet());
        a.setCity(am.getCity());
        a.setZipcode(am.getZipcode());
        a.setCountry(am.getCountry());
        return a;
    }

    public static AddressModel mapToAddressModel(Address a) {
        AddressModel am = new AddressModel();
        am.setStreet(a.getStreet());
        am.setCity(a.getCity());
        am.setZipcode(a.getZipcode());
        am.setCountry(a.getCountry());
        return am;
    }

}
