package com.fekri.joueurs.entities;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Joueur {	
	@javax.persistence.Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idJoueur;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomJoueur;
	
	
	private String  prenomJoueur;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date jourdesignature;
	
	private String posteJoueur ;
	
	@Min(value = 18)
	 @Max(value = 35)
	private int age;
	
	
	@ManyToOne
	private Equipe equipe;
	
	
	public Joueur() {
		super();
	}
	
	
	public Joueur(String nomJoueur, String  prenomJoueur, Date jourdesignature,String posteJoueur,int age) {
		super();
		this.nomJoueur = nomJoueur;
		this.prenomJoueur = prenomJoueur;
		this.jourdesignature = jourdesignature;
		this.posteJoueur=posteJoueur;
		this.age=age ;
	}


	


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Long getIdJoueur() {
		return idJoueur;
	}


	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}


	public String getNomJoueur() {
		return nomJoueur;
	}


	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}


	public String getPrenomJoueur() {
		return prenomJoueur;
	}


	public void setPrenomJoueur(String prenomJoueur) {
		this.prenomJoueur = prenomJoueur;
	}


	public Date getjourdesignature() {
		return jourdesignature;
	}


	public void setjourdesignature(Date jourdesignature) {
		this.jourdesignature = jourdesignature;
	}


	public String getPosteJoueur() {
		return posteJoueur;
	}


	public void setPosteJoueur(String posteJoueur) {
		this.posteJoueur = posteJoueur;
	}


	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", prenomJoueur=" + prenomJoueur
				+ ", jourdesignature=" + jourdesignature + ", posteJoueur=" + posteJoueur + ", age=" + age + "]";
	}


	

	
	
	

}
