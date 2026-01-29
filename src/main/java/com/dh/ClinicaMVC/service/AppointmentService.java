package com.dh.ClinicaMVC.service;

import com.dh.ClinicaMVC.dao.AppointmentDao;
import com.dh.ClinicaMVC.dao.IDao;
import com.dh.ClinicaMVC.model.Appoinment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentService {

    private IDao<Appoinment> appoinmentIDao;

    @Autowired
    public AppointmentService(AppointmentDao appoinmentIDao) {
        this.appoinmentIDao = appoinmentIDao;
    }
    public Appoinment saveAppoinment(Appoinment appoinment) {
        return appoinmentIDao.save(appoinment);
    }
    public Appoinment getAppoinmentById(Integer id) {
        return appoinmentIDao.findById(id);
    }
   public List<Appoinment> getAllAppoinments() {
        return appoinmentIDao.findAll();
   }
}
