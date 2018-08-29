package com.fitec.formation.wiki.model;

        import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum StatusModel {
    STATUS_ARTICLE_APPROVED,
    STATUS_ARTICLE_UNAPPROVED,
    STATUS_ARTICLE_SUBMITTED,
    STATUS_ARTICLE_DISABLED,

    STATUS_USER_CONNECTED,
    STATUS_USER_DISCONNECTED,
    STATUS_USER_BANNED,
    STATUS_USER_DISABLED,

    STATUS_COMMENT_ENABLED,
    STATUS_COMMENT_DISABLED
}
