/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Karim
 */
public class RendezVous {
    
    private int id;
    private int idUser;
    private int idPediatre;
    private Date dateRendezVous;
    private String nom;
    private String prenom;
    private Time heure;

    public RendezVous() {
    }

    public RendezVous(int id, int idUser, int idPediatre, Date dateRendezVous, String nom, String prenom,Time heure) {
        this.id = id;
        this.idUser = idUser;
        this.idPediatre = idPediatre;
        this.dateRendezVous = dateRendezVous;
        this.nom = nom;
        this.prenom = prenom;
        this.heure = heure;    }

    public RendezVous(int idUser, int idPediatre, Date dateRendezVous, String nom, String prenom,Time heure) {
        this.idUser = idUser;
        this.idPediatre = idPediatre;
        this.dateRendezVous = dateRendezVous;
        this.nom = nom;
        this.prenom = prenom;
        this.heure = heure;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPediatre() {
        return idPediatre;
    }

    public void setIdPediatre(int idPediatre) {
        this.idPediatre = idPediatre;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "id=" + id + ", idUser=" + idUser + ", idPediatre=" + idPediatre + ", dateRendezVous=" + dateRendezVous + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    
    
    
    
}
