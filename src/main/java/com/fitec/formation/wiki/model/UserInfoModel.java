package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoModel {

    private Long idUserInfoModel;
    private String firstname;
    private String lastname;
    private String phone;
    private AddressModel addressModel;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonUtil.DATE_PATTERN)
    private Date birthday;

    public UserInfoModel(String firstname, String lastname, String phone, AddressModel addressModel, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.addressModel = addressModel;
        this.birthday = birthday;
    }

    public UserInfoModel(Long idUserInfoModel, String firstname, String lastname, String email, String phone, AddressModel addressModel, Date birthday) {
        this.idUserInfoModel = idUserInfoModel;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.addressModel = addressModel;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " [" + idUserInfoModel + "]\n" +
                phone + " (" + birthday + ")\n" +
                addressModel;
    }
}
