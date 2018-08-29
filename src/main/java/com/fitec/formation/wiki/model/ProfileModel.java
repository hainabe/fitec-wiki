package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum ProfileModel {
    ADMIN,
    MOD,
    USER
}
