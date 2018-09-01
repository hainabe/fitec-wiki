package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.ProfileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "T_USER_LOGGER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogger implements Serializable {

    private static final Long serialVersionUID = 1L;

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @Column(name = "ID_USER_LOGGER")
    //    private Long idUserLogger;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    //    @JoinTable(name = "USER_LOGGER_PROFILE", joinColumns = {
    //            @JoinColumn(name = "ID_USER_LOGGER")}, inverseJoinColumns = {
    //            @JoinColumn(name = "ID_PROFILE")})
    //-------------------------------------------------------------------------
    //    @ManyToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "USER_LOGGER_PROFILE", referencedColumnName = "VALUE")
    //-------------------------------------------------------------------------
    @Enumerated(EnumType.STRING)
    @Column(name = "PROFILE")
    private ProfileModel profile;

    public UserLogger(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ProfileModel getProfile() {
        return ProfileModel.getProfile(this.profile.getId());
    }

    public void setProfile(ProfileModel pm) {
        if (pm == null) {
            this.profile = null;
        } else {
            this.profile = pm;
        }
    }

    @Override
    public String toString() {
        return username + " " + password + " [" + /*idUserLogger + */"] " + profile + " (" + creationDate + ")";
    }
}
