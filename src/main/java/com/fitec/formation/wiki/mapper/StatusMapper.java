package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.model.StatusModel;

public class StatusMapper {

    public static Status mapToStatus(StatusModel value) {
        Status s = new Status();
        s.setStatus(value.toString());
        return s;
    }

    public static StatusModel mapToStatusModel(Status s) {
        String value = s.getStatus();
        return Enum.valueOf(StatusModel.class, value);
    }

}
