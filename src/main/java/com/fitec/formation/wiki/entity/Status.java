package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "VALUE")
    private String status;

    public Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status + " [" + idStatus + "]";
    }
}
