package com.amisk.chatback.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class User {
    @Id
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private Date date;
    private String password;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @NotNull
    @Size(max=254)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotNull
    @Size(max=50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @NotNull
    @Size(max=50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @NotBlank
    @DateTimeFormat
    public Date getDate() {
        return date;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public User(String nom, String prenom, String email, String password) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("L'email fourni n'est pas valide.");
        }
        if (!isStrongPassword(password)) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères, dont au moins une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial.");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.date = new Date();
    }
    private boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
