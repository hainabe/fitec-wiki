package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
@Table(name = "T_ADDRESS")
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {

    private static final Long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_ADDRESS")
//    private Long idAddress;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIP_CODE")
    private String zipcode;
    @Column(name = "COUNTRY")
    private String country;

    public Address(String street, String city, String zipcode, String country) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "\t[" + /*idAddress + */"]\n\t" +
                street + "\n\t" +
                zipcode + " - " + city + "\n\t" +
                country;
    }
}
