package com.crud.jeuxVideo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity

public class Jeux implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Jeux_Id;

	private String Jeux_Titre;

	private String Jeux_Description;

	private double Jeux_Prix;

	@Column(name = "Jeux_DateSortie")
	private Date Jeux_DateSortie;
	
	@Column(name = "Jeux_PaysOrigine")
	private String Jeux_PaysOrigine;

	private String Jeux_Connexion;

	private String Jeux_Mode;

	private Long Genre_Id;
	/**
	 * 
	 */
	public Jeux() {
	}
	public Long getJeux_Id() {
		return Jeux_Id;
	}
	public void setJeux_Id(Long jeux_Id) {
		Jeux_Id = jeux_Id;
	}
	public String getJeux_Titre() {
		return Jeux_Titre;
	}
	public void setJeux_Titre(String jeux_Titre) {
		Jeux_Titre = jeux_Titre;
	}
	public String getJeux_Description() {
		return Jeux_Description;
	}
	public void setJeux_Description(String jeux_Description) {
		Jeux_Description = jeux_Description;
	}
	public double getJeux_Prix() {
		return Jeux_Prix;
	}
	public void setJeux_Prix(double jeux_Prix) {
		Jeux_Prix = jeux_Prix;
	}
	public Date getJeux_DateSortie() {
		return Jeux_DateSortie;
	}
	public void setJeux_DateSortie(Date jeux_DateSortie) {
		Jeux_DateSortie = jeux_DateSortie;
	}
	public String getJeux_PaysOrigine() {
		return Jeux_PaysOrigine;
	}
	public void setJeux_PaysOrigine(String jeux_PaysOrigine) {
		Jeux_PaysOrigine = jeux_PaysOrigine;
	}
	public String getJeux_Connexion() {
		return Jeux_Connexion;
	}
	public void setJeux_Connexion(String jeux_Connexion) {
		Jeux_Connexion = jeux_Connexion;
	}
	public String getJeux_Mode() {
		return Jeux_Mode;
	}
	public void setJeux_Mode(String jeux_Mode) {
		Jeux_Mode = jeux_Mode;
	}
	public Long getGenre_Id() {
		return Genre_Id;
	}
	public void setGenre_Id(Long genre_Id) {
		Genre_Id = genre_Id;
	}
	// @Override
	// public String toString() {
	// 	return  Jeux_Titre;
	// }


}
