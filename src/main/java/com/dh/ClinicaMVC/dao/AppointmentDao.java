package com.dh.ClinicaMVC.dao;

import com.dh.ClinicaMVC.model.Appoinment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentDao implements  IDao<Appoinment> {

    private List<Appoinment> appoinments;

    public AppointmentDao() {
        appoinments = new ArrayList<>();
    }


    @Override
    public Appoinment save(Appoinment appoinment) {

        //Guardamos en la lista el turno que recibimos por parámetro
        appoinments.add(appoinment);
        return appoinment;
    }

    @Override
    public Appoinment findById(Integer id) {

        // Recorremos la lista para encontrar el turno que se pretende buscar
        for (Appoinment appoinment : appoinments) {
            if (appoinment.getId() == id) {
                return appoinment;
            }
        }
        return null;
    }

    @Override
    public void update(Appoinment appoinment) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Appoinment> findAll() {
        return appoinments;
    }

    @Override
    public Appoinment findByEmail(String value) {
        return null;
    }
}
