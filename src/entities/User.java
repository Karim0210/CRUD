/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Slim
 */
public class User {
    
    private int id;
    private String Username;
    private String CanonicalUsername;
    private String Email;
    private String CanonicalEmail;
    private int Enabled;
    private Date LastLogin;
    private String Role;
    private int nbJetons;
    private String Addresse;
    private String Nom;
    private String Prenom;
    private String Password;

    public User() {
    }

    public User(int id, String Username, String CanonicalUsername, String Email, String CanonicalEmail, int Enabled, Date LastLogin, String Role, int nbJetons, String Addresse, String Nom, String Prenom, String Password) {
        this.id = id;
        this.Username = Username;
        this.CanonicalUsername = CanonicalUsername;
        this.Email = Email;
        this.CanonicalEmail = CanonicalEmail;
        this.Enabled = Enabled;
        this.LastLogin = LastLogin;
        this.Role = Role;
        this.nbJetons = nbJetons;
        this.Addresse = Addresse;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getCanonicalUsername() {
        return CanonicalUsername;
    }

    public void setCanonicalUsername(String CanonicalUsername) {
        this.CanonicalUsername = CanonicalUsername;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCanonicalEmail() {
        return CanonicalEmail;
    }

    public void setCanonicalEmail(String CanonicalEmail) {
        this.CanonicalEmail = CanonicalEmail;
    }

    public int getEnabled() {
        return Enabled;
    }

    public void setEnabled(int Enabled) {
        this.Enabled = Enabled;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date LastLogin) {
        this.LastLogin = LastLogin;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getNbJetons() {
        return nbJetons;
    }

    public void setNbJetons(int nbJetons) {
        this.nbJetons = nbJetons;
    }

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String Addresse) {
        this.Addresse = Addresse;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.Enabled != other.Enabled) {
            return false;
        }
        if (this.nbJetons != other.nbJetons) {
            return false;
        }
        if (!Objects.equals(this.Username, other.Username)) {
            return false;
        }
        if (!Objects.equals(this.CanonicalUsername, other.CanonicalUsername)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.CanonicalEmail, other.CanonicalEmail)) {
            return false;
        }
        if (!Objects.equals(this.Role, other.Role)) {
            return false;
        }
        if (!Objects.equals(this.Addresse, other.Addresse)) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Prenom, other.Prenom)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        if (!Objects.equals(this.LastLogin, other.LastLogin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", Username=" + Username + ", CanonicalUsername=" + CanonicalUsername + ", Email=" + Email + ", CanonicalEmail=" + CanonicalEmail + ", Enabled=" + Enabled + ", LastLogin=" + LastLogin + ", Role=" + Role + ", nbJetons=" + nbJetons + ", Addresse=" + Addresse + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Password=" + Password + '}';
    }

    

    
   
    
    
}
