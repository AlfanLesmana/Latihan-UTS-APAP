package com.SIFILM.SIFILM.controller;

import com.SIFILM.SIFILM.model.FilmModel;
import com.SIFILM.SIFILM.model.PerusahaanModel;
import com.SIFILM.SIFILM.service.FilmService;
import com.SIFILM.SIFILM.service.PerusahaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PerusahaanController {

    @Autowired
    PerusahaanService perusahaanService;

    @Autowired
    FilmService filmService;

    @GetMapping("/perusahaan/")
    public String viewAllPerusahaan(Model model){
        model.addAttribute("listPerusahaan",perusahaanService.getPerusahaanList());
        return "view-all-perusahaan";
    }

    @GetMapping("/perusahaan/tambah")
    public String addPerusahaanFormPage(Model model){
        model.addAttribute("perusahaan",new PerusahaanModel());
        return "form-add-perusahaan";
    }

    @PostMapping("/perusahaan/tambah")
    public String addPerusahaanSubmit(@ModelAttribute PerusahaanModel perusahaan, Model model){
         perusahaanService.addPerusahaan(perusahaan);
         model.addAttribute("perusahaan",perusahaan);
         return "add-perusahaan";
    }

    @GetMapping(value = "/perusahaan/ubah/")
    private String updatePerusahaanForm(@RequestParam(value= "idPerusahaan") Long idPerusahaan,Model model){
        PerusahaanModel targetPerusahaan = perusahaanService.getPerusahaanById(idPerusahaan).get();
        model.addAttribute("perusahaan",targetPerusahaan);
        return "form-update-perusahaan";
    }

    @GetMapping(value = "/perusahaan/view/")
    private String ViewPerusahaan(@RequestParam(value= "idPerusahaan") Long idPerusahaan,Model model){
        PerusahaanModel targetPerusahaan = perusahaanService.getPerusahaanById(idPerusahaan).get();
        List<FilmModel> listFilm = filmService.getAllFilmByPerusahaan(targetPerusahaan);
        model.addAttribute("listFilm",listFilm);
        model.addAttribute("perusahaan",targetPerusahaan);
        return "view-perusahaan";
    }

    @RequestMapping(value = "/perusahaan/ubah")
    private String submitUpdatePerusahaan(
            @RequestParam(value= "idPerusahaan") Long idPerusahaan,
            @RequestParam(value= "namaPerusahaan") String namaPerusahaan,
            @RequestParam(value= "noTeleponPerusahaan") String noTelepon,
            Model model){
        PerusahaanModel perusahaanUpdated = perusahaanService.updatePerusahaan(idPerusahaan,namaPerusahaan,noTelepon);
        model.addAttribute("perusahaan",perusahaanUpdated);
        return "update-perusahaan";
    }

    @PostMapping(value = "perusahaan/hapus/{idPerusahaan}")
    private String deletePerusahaanSubmit(@PathVariable(value = "idPerusahaan") Long idPerusahaan , Model model){
        PerusahaanModel perusahaanDelete = perusahaanService.getPerusahaanById(idPerusahaan).get();
        if(perusahaanDelete.getListFilm().size()>0){
            return "error-delete-perusahaan";
        }
        perusahaanService.deletePerusahaan(perusahaanDelete);
        model.addAttribute("perusahaan",perusahaanDelete);
        return "delete-perusahaan";
    }

}
