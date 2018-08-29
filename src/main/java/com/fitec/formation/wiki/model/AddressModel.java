package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class AddressModel {

    private Long idAddressModel;
    private String street;
    private String city;
    private String zipcode;
    private String country;

    public AddressModel(String street, String city, String zipcode, String country) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public AddressModel(Long idAddressModel, String street, String city, String zipcode, String country) {
        this.idAddressModel = idAddressModel;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "\t[" + idAddressModel + "]\n\t" +
                street + "\n\t" +
                zipcode + " - " + city + "\n\t" +
                country;
    }

}
