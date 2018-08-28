package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoModel {

    private Long idUserInfoModel;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private AddressModel addressModel;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonUtil.DATE_PATTERN)
    private Date birthday;

    public UserInfoModel() {
    }

    public UserInfoModel(String firstname, String lastname, String email, String phone, AddressModel addressModel, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.addressModel = addressModel;
        this.birthday = birthday;
    }

    public UserInfoModel(Long idUserInfoModel, String firstname, String lastname, String email, String phone, AddressModel addressModel, Date birthday) {
        this.idUserInfoModel = idUserInfoModel;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.addressModel = addressModel;
        this.birthday = birthday;
    }

    public Long getIdUserInfoModel() {
        return idUserInfoModel;
    }

    public void setIdUserInfoModel(Long idUserInfoModel) {
        this.idUserInfoModel = idUserInfoModel;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " [" + idUserInfoModel + "]\n" +
                email + " - " + phone + " (" + birthday + ")\n" +
                addressModel;
    }
}
