package br.com.mangastore.mangastore.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import br.com.mangastore.mangastore.models.Manga;
import br.com.mangastore.mangastore.repository.MangaRepository;
import br.com.mangastore.mangastore.utils.FileUploadUtil;

@CrossOrigin("http://localhost:3000")
@Controller
public class MangaController {
    @Autowired
    private MangaRepository repository;

    
    @PostMapping("/mangas/save")
    public RedirectView saveManga(
    @RequestParam("files") MultipartFile multipartFile,
    @RequestParam("title") String title,
    @RequestParam("number") Integer number,
    @RequestParam("price") Double price) throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Manga manga = new Manga();
        manga.setTitle(title);
        manga.setPrice(price);
        manga.setNumber(number);
        manga.setCover("/img/" +fileName);
        repository.save(manga);
        String uploadDir = "public/img/";
        FileUploadUtil.saveFile(uploadDir,fileName, multipartFile);
        return new RedirectView("/mangas", true);
    }

    @PutMapping("mangas/{id}/update")
    public ResponseEntity updateManga(
    @PathVariable("id") long id,
    @RequestParam(name = "files", required = false) MultipartFile multipartFile,
    @RequestParam("title") String title,
    @RequestParam("number") Integer number,
    @RequestParam("price") Double price) throws IOException{
        Manga manga = repository.getReferenceById(id);

        if(multipartFile!=null){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            manga.setCover("/img/" +fileName);
            String uploadDir = "public/img/";
            FileUploadUtil.saveFile(uploadDir,fileName, multipartFile);
        }
        
        manga.setTitle(title);
        manga.setPrice(price);
        manga.setNumber(number);
        manga.setCover(manga.getCover());
        repository.save(manga);
        
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}