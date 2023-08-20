package br.com.mangastore.mangastore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String username;

    private String email;

    private String provider;

    private String password;

    private String resetPasswordToken;

    private String confirmationToken;

    private Boolean confirmed;

    private Boolean blocked;
}
