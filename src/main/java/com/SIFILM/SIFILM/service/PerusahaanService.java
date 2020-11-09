package com.SIFILM.SIFILM.service;

import com.SIFILM.SIFILM.model.PerusahaanModel;
import java.util.List;
import java.util.Optional;

public interface PerusahaanService {
    List<PerusahaanModel> getPerusahaanList();
    Optional<PerusahaanModel> getPerusahaanById(Long idPerushaan);
    void deletePerusahaan(PerusahaanModel perusahaan);
    void addPerusahaan(PerusahaanModel perusahaan);
    PerusahaanModel updatePerusahaan(Long idPerusahaan,String namaPerusahaan, String nomorTelepon);
}
