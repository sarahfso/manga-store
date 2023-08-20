package br.com.mangastore.mangastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.mangastore.mangastore.models.User;

@CrossOrigin("http://localhost:3000")
public interface UserRepository extends JpaRepository<User, Long> {
    
}