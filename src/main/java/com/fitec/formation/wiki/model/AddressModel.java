package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "\t[" + idAddressModel + "]\n\t" +
                street + "\n\t" +
                zipcode + " - " + city + "\n\t" +
                country;
    }

}
