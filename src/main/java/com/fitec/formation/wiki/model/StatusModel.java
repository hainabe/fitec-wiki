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
public enum StatusModel {
    STATUS_ARTICLE_APPROVED(11),
    STATUS_ARTICLE_UNAPPROVED(12),
    STATUS_ARTICLE_SUBMITTED(13),
    STATUS_ARTICLE_DISABLED(14),

    STATUS_USER_CONNECTED(21),
    STATUS_USER_DISCONNECTED(22),
    STATUS_USER_BANNED(23),
    STATUS_USER_DISABLED(24),

    STATUS_COMMENT_ENABLED(31),
    STATUS_COMMENT_DISABLED(32);

    private int idStatusModel;

    @JsonValue
    public static StatusModel getStatus(Integer id) {
        if (id == null) {
            return null;
        }

        for (StatusModel sm : StatusModel.values()) {
            if (id.equals(sm.getId())) {
                return sm;
            }
        }

        throw new IllegalArgumentException("### No matching PROFILE for ID: " + id);
    }

    public int getId() {
        return idStatusModel;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(StatusModel.getStatus(idStatusModel));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("### No matching PROFILE for ID: " + idStatusModel);
    }
}
