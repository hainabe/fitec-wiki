package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.MessageUtil;
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

    private String firstname;
    private String lastname;
    private String phone;
    private AddressModel addressModel;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MessageUtil.DATE_PATTERN)
    private Date birthday;

    @Override
    public String toString() {
        return firstname + " " + lastname + " []\n" +
                phone + " (" + birthday + ")\n" +
                addressModel;
    }
}
