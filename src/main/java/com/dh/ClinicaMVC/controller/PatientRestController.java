package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Patient;
import com.dh.ClinicaMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientRestController {

    private PatientService patientService;

    @Autowired
    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient guardarPaciente(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PutMapping
    public void  actualizarPaciente(@RequestBody Patient patient) {
        patientService.update(patient);
    }
}
