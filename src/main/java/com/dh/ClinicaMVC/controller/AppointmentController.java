package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Appoinment;
import com.dh.ClinicaMVC.service.AppointmentService;
import com.dh.ClinicaMVC.service.DentistService;
import com.dh.ClinicaMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/turnos")
public class AppointmentController {

    private AppointmentService appointmentService;

    private DentistService dentistService;

    private PatientService patientService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appoinment>>  findAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppoinments());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Appoinment> saveAppointment(@RequestBody Appoinment appoinment) {
        ResponseEntity<Appoinment> response = null;
       if (dentistService.findByIdDentist(appoinment.getDentist().getId()) != null &&
               patientService.findById(appoinment.getPatient().getId()) != null) {
           response = ResponseEntity.ok(appointmentService.saveAppoinment(appoinment));
       } else {
           response = ResponseEntity.badRequest().build();
       }
       return response;

    }

}
