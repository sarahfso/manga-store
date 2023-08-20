package br.com.mangastore.mangastore.projections;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import br.com.mangastore.mangastore.models.Manga;
import br.com.mangastore.mangastore.models.Comment;

@Projection(name = "MangaWithComments", types = { Manga.class }) 
public interface MangaWithComments {
    Long getId();

    String getTitle();

    Number getNumber();

    String getCover();

    Number getPrice();

    List<Comment> getComments();

    String getSummary();
}
