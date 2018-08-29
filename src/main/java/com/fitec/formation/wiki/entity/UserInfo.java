package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "T_USER_INFORMATION")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER_INFORMATION")
    private Long idUserInfo;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE")
    private String phone;
    @Embedded
    @Column(name = "ADDRESS")
    private Address address;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    public UserInfo(String firstname, String lastname, String phone, Address address, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " [" + idUserInfo + "]\n" +
                phone + " (" + birthday + ")\n" +
                address;
    }
}
