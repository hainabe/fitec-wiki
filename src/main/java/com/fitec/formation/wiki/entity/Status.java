package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.StatusModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_STATUS")
@Getter
@Setter
@NoArgsConstructor
public class Status implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS")
    private Long idStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "VALUE")
    private StatusModel status;

    public Status(StatusModel status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status + " [" + idStatus + "]";
    }
}

//enum StatusEnum {
//    STATUS_ARTICLE_APPROVED,
//    STATUS_ARTICLE_UNAPPROVED,
//    STATUS_ARTICLE_SUBMITTED,
//    STATUS_ARTICLE_DISABLED,
//
//    STATUS_USER_CONNECTED,
//    STATUS_USER_DISCONNECTED,
//    STATUS_USER_BANNED,
//    STATUS_USER_DISABLED,
//
//    STATUS_COMMENT_ENABLED,
//    STATUS_COMMENT_DISABLED
//}
