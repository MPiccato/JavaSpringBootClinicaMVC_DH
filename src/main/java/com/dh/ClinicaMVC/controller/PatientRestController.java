package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Patient;
import com.dh.ClinicaMVC.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientRestController {

    private PatientService patientService;

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
