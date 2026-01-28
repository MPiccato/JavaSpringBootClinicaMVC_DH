package com.dh.ClinicaMVC.controller;

import com.dh.ClinicaMVC.model.Dentist;
import com.dh.ClinicaMVC.service.DentistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class DentistRestController {

    private DentistService dentistService;

    public DentistRestController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/{id}")
    public Dentist getDentistById(@PathVariable Integer id){
        return dentistService.findByIdDentist(id);

    }

    //Guardar un nuevo dentista en la base de datos
    @PostMapping("/guardar")
    public Dentist guardarDentista(@RequestBody Dentist dentist) {
        return dentistService.saveDentist(dentist);
    }

    //Modificar un dentista existente
    @PutMapping("/actualizar")
    public void actualizarDentista(@RequestBody Dentist dentist) {
        dentistService.updateDentist(dentist);
    }

    //Borrar un dentista por su ID
    @DeleteMapping("/borrar/{id}")
    public void borrarDentista(@PathVariable Integer id) {
        dentistService.deleteDentist(id);
    }

    //Listar todos los dentistas
    @GetMapping("/listar")
    public List<Dentist> listarDentistas() {
        return dentistService.findAllDentist();
    }


}
