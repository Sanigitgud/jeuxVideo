package com.crud.jeuxVideo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genre implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Genre_Id;
    private String Genre_Titre;
    private String Genre_Description;

    public Genre() {
        
    }

    public Long getGenre_Id() {
        return Genre_Id;
    }

    public void setGenre_Id(Long genre_Id) {
        Genre_Id = genre_Id;
    }

    public String getGenre_Titre() {
        return Genre_Titre;
    }

    public void setGenre_Titre(String genre_Titre) {
        Genre_Titre = genre_Titre;
    }

    public String getGenre_Description() {
        return Genre_Description;
    }

    public void setGenre_Description(String genre_Description) {
        Genre_Description = genre_Description;
    }
}
