package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Dentist;
import com.dh.ClinicaMVC.service.DentistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class DentistRestController {

    private DentistService dentistService;

    public DentistRestController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/{id}")
    public Dentist getDentistById(@PathVariable Integer id){
        return dentistService.findByIdDentist(id);

    }


}
