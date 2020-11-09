package com.SIFILM.SIFILM.controller;


import com.SIFILM.SIFILM.model.FilmModel;
import com.SIFILM.SIFILM.model.PerusahaanModel;
import com.SIFILM.SIFILM.service.FilmService;
import com.SIFILM.SIFILM.service.PerusahaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmController {

    @Autowired
    PerusahaanService perusahaanService;

    @Autowired
    FilmService filmService;

    @GetMapping("/film/tambah/{idPerusahaan}")
    public String addFilmFormPage(@PathVariable Long idPerusahaan, Model model){
        PerusahaanModel perusahaan = perusahaanService.getPerusahaanById(idPerusahaan).get();
        FilmModel film =  new FilmModel();
        film.setPerusahaan(perusahaan);
        model.addAttribute("perusahaan",perusahaan);
        model.addAttribute("film",film);
        return "form-add-film";
    }

    @PostMapping("/film/tambah")
    public String addFilmSubmit(@ModelAttribute FilmModel film , Model model){
        filmService.addFilm(film);
        model.addAttribute("film",film);
        return "add-film";
    }
}
