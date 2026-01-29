package com.dh.ClinicaMVC.service;

import com.dh.ClinicaMVC.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    void findById() {
        Integer idPatient = 1;

        Patient pacienteTest = patientService.findById(idPatient);
        assertNotNull(pacienteTest);


    }
}