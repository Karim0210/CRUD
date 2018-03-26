/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Karim
 */
public class Article {
    
    
    private int id;
    private String nom;
    private String autheur;
    private int vues;
    private String text;
    private int likes;
    private String image;
    private String video;
    private String type;
    private int rating;

    public Article(int id, String nom, String autheur, int vues, String text, int likes, String image, String video, String type, int rating) {
        this.id = id;
        this.nom = nom;
        this.autheur = autheur;
        this.vues = vues;
        this.text = text;
        this.likes = likes;
        this.image = image;
        this.video = video;
        this.type = type;
        this.rating = rating;
    }

    public Article(String nom, String autheur, int vues, String text, int likes,String image, String video, String type, int rating) {
        this.nom = nom;
        this.autheur = autheur;
        this.vues = vues;
        this.text = text;
        this.likes = likes;
        this.image = image;
        this.video = video;
        this.type = type;
        this.rating = rating;
    }

    public Article() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAutheur() {
        return autheur;
    }

    public void setAutheur(String autheur) {
        this.autheur = autheur;
    }

    public int getVues() {
        return vues;
    }

    public void setVues(int vues) {
        this.vues = vues;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", nom=" + nom + ", autheur=" + autheur + ", vues=" + vues + ", text=" + text + ", likes=" + likes + ", image=" + image + ", video=" + video + ", type=" + type + ", rating=" + rating + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.vues != other.vues) {
            return false;
        }
        if (this.likes != other.likes) {
            return false;
        }
        if (this.rating != other.rating) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.autheur, other.autheur)) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
   
    
    
    
}
