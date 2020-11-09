package com.SIFILM.SIFILM.repository;

import com.SIFILM.SIFILM.model.FilmModel;
import com.SIFILM.SIFILM.model.PerusahaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDb extends JpaRepository<FilmModel,Long> {
    List<FilmModel> findByPerusahaan(PerusahaanModel perusahaan);
}
