package com.SIFILM.SIFILM.service;

import com.SIFILM.SIFILM.model.PerusahaanModel;
import com.SIFILM.SIFILM.repository.PerusahaanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PerusahaanServiceImpl implements PerusahaanService {

    @Autowired
    PerusahaanDb perusahaanDb;

    @Override
    public List<PerusahaanModel> getPerusahaanList() {
        return perusahaanDb.findAll();
    }

    @Override
    public Optional<PerusahaanModel> getPerusahaanById(Long idPerusahaan) {
        return perusahaanDb.findByIdPerusahaan(idPerusahaan);
    }

    @Override
    public void deletePerusahaan(PerusahaanModel perusahaan) {
        perusahaanDb.delete(perusahaan);
    }

    @Override
    public void addPerusahaan(PerusahaanModel perusahaan) {
        perusahaanDb.save(perusahaan);
    }

    @Override
    public PerusahaanModel updatePerusahaan(Long idPerusahaan, String namaPerusahaan, String nomorTelepon) {
        PerusahaanModel targetPerusahaan = perusahaanDb.findByIdPerusahaan(idPerusahaan).get();
        try{
            targetPerusahaan.setNamaPerusahaan(namaPerusahaan);
            targetPerusahaan.setNoTeleponPerusahaan(nomorTelepon);
            perusahaanDb.save(targetPerusahaan);
            return targetPerusahaan;
        }catch (NullPointerException nullPointerException){
            return null;
        }
    }

    @Override
    public void addPendapatan(PerusahaanModel perusahaan, String genre) {
        Long pendapatan = perusahaan.getPendapatan();
        if(genre.equals("Comedy")){
            pendapatan = pendapatan + 150000000;
        }
        else if(genre.equals("Action")){
            pendapatan = pendapatan + 300000000;
        }
        else if(genre.equals("Horror")){
            pendapatan = pendapatan + 100000000;
        }
        perusahaan.setPendapatan(pendapatan);
    }
}
