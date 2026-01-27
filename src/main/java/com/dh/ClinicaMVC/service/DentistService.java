package com.dh.ClinicaMVC.service;

import com.dh.ClinicaMVC.dao.DentistDaoH2;
import com.dh.ClinicaMVC.dao.IDao;
import com.dh.ClinicaMVC.model.Dentist;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DentistService {

    private IDao<Dentist> dentistIDao;

    public DentistService() {
        this.dentistIDao = new DentistDaoH2();
    }

    public Dentist saveDentist(Dentist dentist){
        return dentistIDao.save(dentist);
    }
    public Dentist findByIdDentist(Integer id){
        return dentistIDao.findById(id);
    }
    public void updateDentist(Dentist dentist){
        dentistIDao.update(dentist);
    }
    public void deleteDentist(Integer id){
        dentistIDao.delete(id);
    }

    public List<Dentist> findAllDentist(){
        return dentistIDao.findAll();
    }

    public Dentist findByEmailDentist(String email){
        return dentistIDao.findByEmail(email);
    }

}
