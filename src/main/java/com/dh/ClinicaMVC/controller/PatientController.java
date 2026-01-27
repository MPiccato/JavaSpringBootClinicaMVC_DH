package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Patient;
import com.dh.ClinicaMVC.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    //Constructor del Controller
    public PatientController() {
        this.patientService = new PatientService();
    }

    @GetMapping
    public String findPatientByEmail(Model model, @RequestParam("email") String email) {

        Patient patient = patientService.findByEmail(email);

        model.addAttribute("name", patient.getName());
        model.addAttribute("lastName", patient.getLastName());

        return "index";


    }


}
