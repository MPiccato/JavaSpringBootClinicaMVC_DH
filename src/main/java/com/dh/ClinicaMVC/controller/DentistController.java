package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Dentist;
import com.dh.ClinicaMVC.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dentist")
public class DentistController {

    private DentistService dentistService;

    @Autowired

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping
    public String findDentistById(Model model, @RequestParam("id") Integer id) {

      Dentist dentist = dentistService.findByIdDentist(id);

      model.addAttribute("nameDentist", dentist.getName());
      model.addAttribute("lastNameDentist", dentist.getLastName());
      model.addAttribute("addRegistration", dentist.getRegistration());

      return "index";
    }
}
