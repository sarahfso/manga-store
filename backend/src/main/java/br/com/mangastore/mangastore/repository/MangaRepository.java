package br.com.mangastore.mangastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.mangastore.mangastore.models.Manga;

@CrossOrigin("http://localhost:3000")
public interface MangaRepository extends JpaRepository<Manga, Long> {
    
}
