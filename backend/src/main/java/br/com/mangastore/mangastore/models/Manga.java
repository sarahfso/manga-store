package br.com.mangastore.mangastore.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Manga {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;

    private Number number;

    private String cover;

    private Number price;

    @OneToMany(mappedBy="manga")
    private List<Comment> comments;

    private String summary;
}
