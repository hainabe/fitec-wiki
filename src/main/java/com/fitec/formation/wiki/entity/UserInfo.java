package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "T_USER_INFORMATION")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final Long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_USER_INFORMATION")
//    private Long idUserInfo;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE")
    private String phone;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Embedded
    @Column(name = "ADDRESS")
    private Address address;

    public UserInfo(String firstname, String lastname, String phone, Date birthday, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " [" + /*idUserInfo + */"]\n" +
                phone + " (" + birthday + ")\n" +
                address;
    }
}
