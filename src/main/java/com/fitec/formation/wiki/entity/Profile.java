package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.ProfileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFILE")
    private Long idProfile;
    @Enumerated(EnumType.STRING)
    @Column(name = "VALUE")
    private ProfileModel profile;

    @PersistenceConstructor
    public Profile(ProfileModel profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return profile + " [" + idProfile + "]";
    }
}
