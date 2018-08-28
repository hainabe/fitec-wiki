package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.UserInfo;
import com.fitec.formation.wiki.model.UserInfoModel;

public class UserInfoMapper {

    public static UserInfo mapToUserInfo(UserInfoModel uim) {
        UserInfo ui = new UserInfo();
        ui.setFirstname(uim.getFirstname());
        ui.setLastname(uim.getLastname());
        ui.setEmail(uim.getEmail());
        ui.setPhone(uim.getPhone());
        ui.setAddress(AddressMapper.mapToAddress(uim.getAddressModel()));
        ui.setBirthday(uim.getBirthday());
        return ui;
    }

    public static UserInfoModel mapToUserInfoModel(UserInfo ui) {
        UserInfoModel uim = new UserInfoModel();
        uim.setFirstname(ui.getFirstname());
        uim.setLastname(ui.getLastname());
        uim.setEmail(ui.getEmail());
        uim.setPhone(ui.getPhone());
        uim.setAddressModel(AddressMapper.mapToAddressModel(ui.getAddress()));
        uim.setBirthday(ui.getBirthday());
        return uim;
    }
}
