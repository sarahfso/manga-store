package br.com.mangastore.mangastore.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import br.com.mangastore.mangastore.models.Comment;
import br.com.mangastore.mangastore.models.Manga;
import br.com.mangastore.mangastore.projections.MangaWithComments;

@Component
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Manga.class,Comment.class).getProjectionConfiguration()
          .addProjection(MangaWithComments.class);


    }
}