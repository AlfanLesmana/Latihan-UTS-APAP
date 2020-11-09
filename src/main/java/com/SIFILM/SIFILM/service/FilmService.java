package com.SIFILM.SIFILM.service;

import com.SIFILM.SIFILM.model.FilmModel;
import com.SIFILM.SIFILM.model.PerusahaanModel;

import java.util.List;

public interface FilmService {
    void addFilm(FilmModel film);
    List<FilmModel> getAllFilmByPerusahaan(PerusahaanModel perusahaan);
}
