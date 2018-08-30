package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {

    private Long idMessageModel;
    @NonNull
    private String message;

    public MessageModel(String message) {
        this.message = message;
    }
}
