package com.SIFILM.SIFILM.repository;

import com.SIFILM.SIFILM.model.PerusahaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerusahaanDb extends JpaRepository<PerusahaanModel,Long> {
    Optional<PerusahaanModel> findByIdPerusahaan(Long idPerusahaan);
}
