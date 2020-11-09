package com.SIFILM.SIFILM.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "film")
public class FilmModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_film",nullable = false)
    private String namaFilm;

    @NotNull
    @Column(name = "durasi_film",nullable = false)
    private Long durasiFilm;

    @NotNull
    @Size(max = 30)
    @Column(name = "genre_film",nullable = false)
    private String genreFilm;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "tanggal_dibuat",nullable = false)
    private LocalDate tanggalDibuat;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_produser",nullable = false)
    private String namaProduser;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "perusahaanId", referencedColumnName = "idPerusahaan",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PerusahaanModel perusahaan;

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public Long getDurasiFilm() {
        return durasiFilm;
    }

    public void setDurasiFilm(Long durasiFilm) {
        this.durasiFilm = durasiFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    public LocalDate getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(LocalDate tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public String getNamaProduser() {
        return namaProduser;
    }

    public void setNamaProduser(String namaProduser) {
        this.namaProduser = namaProduser;
    }

    public PerusahaanModel getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(PerusahaanModel perusahaan) {
        this.perusahaan = perusahaan;
    }
}
