package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ProfileModel {
    ADMIN(1),
    MOD(2),
    USER(3);

    private int idProfileModel;

    @JsonValue
    public static ProfileModel getProfile(Integer id) {
        if (id == null) {
            return null;
        }

        for (ProfileModel pm : ProfileModel.values()) {
            if (id.equals(pm.getId())) {
                return pm;
            }
        }
        throw new IllegalArgumentException("### No matching PROFILE for ID: " + id);
    }

    public int getId() {
        return idProfileModel;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(ProfileModel.getProfile(idProfileModel));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("### No matching PROFILE for ID: " + idProfileModel);
    }
}