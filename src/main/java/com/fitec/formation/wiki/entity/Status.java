package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.StatusModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_STATUS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS")
    private Long idStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "VALUE")
    private StatusModel status;

    @PersistenceConstructor
    public Status(StatusModel status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status + " [" + idStatus + "]";
    }
}
