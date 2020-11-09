package com.SIFILM.SIFILM.service;

import com.SIFILM.SIFILM.model.FilmModel;
import com.SIFILM.SIFILM.model.PerusahaanModel;
import com.SIFILM.SIFILM.repository.FilmDb;
import com.SIFILM.SIFILM.repository.PerusahaanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmDb filmDb;

    @Autowired
    PerusahaanService perusahaanService;

    @Override
    public void addFilm(FilmModel film) {
        perusahaanService.addPendapatan(film.getPerusahaan(),film.getGenreFilm());
        filmDb.save(film);
    }

    @Override
    public List<FilmModel> getAllFilmByPerusahaan(PerusahaanModel perusahaan) {
        return filmDb.findByPerusahaan(perusahaan);
    }
}
