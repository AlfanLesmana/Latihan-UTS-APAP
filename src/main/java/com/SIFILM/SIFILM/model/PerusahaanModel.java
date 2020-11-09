package com.SIFILM.SIFILM.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "perusahaan")
public class PerusahaanModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerusahaan;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_perusahaan",nullable = false)
    private String namaPerusahaan;

    @NotNull
    @Size(max = 30)
    @Column(name = "no_telepon_perusahaan",nullable = false)
    private String noTeleponPerusahaan;

    @NotNull
    @Column(name = "pendapatan",nullable = false, columnDefinition = "integer default 0")
    private Long pendapatan;

    @OneToMany(mappedBy = "perusahaan",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<FilmModel> listFilm;

    public Long getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(Long idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNoTeleponPerusahaan() {
        return noTeleponPerusahaan;
    }

    public void setNoTeleponPerusahaan(String noTeleponPerusahaan) {
        this.noTeleponPerusahaan = noTeleponPerusahaan;
    }

    public List<FilmModel> getListFilm() {
        return listFilm;
    }

    public void setListFilm(List<FilmModel> listFilm) {
        this.listFilm = listFilm;
    }

    public Long getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(Long pendapatan) {
        this.pendapatan = pendapatan;
    }
}
