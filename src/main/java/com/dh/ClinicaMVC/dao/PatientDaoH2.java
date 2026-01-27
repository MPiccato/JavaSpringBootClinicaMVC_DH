package com.dh.ClinicaMVC.dao;

import com.dh.ClinicaMVC.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PatientDaoH2 implements  IDao<Patient>{

    private static final String SQL_INSERT_PATIENT = "INSERT INTO PATIENT " +
            "(NAME, LAST_NAME,EMAIL, CARD_IDENTITY, ADMISSION_OF_DATE, ADDRESS_ID) " +
            "VALUES(?, ?, ?, ?, ?,?)";

    private static final String SQL_SELECT_PATIENT_BY_ID = "SELECT * FROM PATIENT WHERE ID = ?";

    private static final String SQL_FIND_ALL = "SELECT * FROM PATIENT";

    private static final String SQL_FIND_EMAIL= "SELECT * FROM PATIENT WHERE EMAIL = ?";

    @Override
    public Patient save(Patient patient) {

        Connection connection = null;
        try {

            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            addressDaoH2.save(patient.getAddress());

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PATIENT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getName());
            ps.setString(2,patient.getLastName());
            ps.setString(3,patient.getEmail());
            ps.setInt(4, patient.getCardIdentity());
            ps.setString(5, patient.getAdmissionOfDate().toString()); // En el video dice Date.valueof(patient.getAdmissionOfDate())
            ps.setInt(6, patient.getAddress().getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                patient.setId(rs.getInt(1));
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return patient;

    }

    @Override
    public Patient findById(Integer id) {

        Connection connection = null;
        Patient patient = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_PATIENT_BY_ID);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                AddressDaoH2 addressDaoH2 = new AddressDaoH2();
                patient =  new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        addressDaoH2.findById(rs.getInt(7))
                );
            }


        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return patient;
    }

    @Override
    public void update(Patient patient) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE PATIENTS SET NAME = ?, LAST_NAME = ?, CARD_IDENTITY = ?, ADMISSION_OF_DATE = ?, ADDRESS_ID = ? WHERE ID = ?");

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getEmail());
            ps.setInt(4, patient.getCardIdentity());
            ps.setString(5, patient.getAdmissionOfDate().toString());
            ps.setInt(6, patient.getAddress().getId());
            ps.setInt(7, patient.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM PATIENTS WHERE ID = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
        } catch (Exception ex) {
            ex.printStackTrace();}
        }

    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        Connection connection = null;
        try {
            Patient patient;
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = ps.executeQuery();
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            while (rs.next()){
                patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        addressDaoH2.findById(rs.getInt(7))
                );
                patients.add(patient);
            }


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return patients;
    }

    @Override
    public Patient findByEmail(String value) {
        Connection connection = null;
        Patient patient = null;
        try {

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_EMAIL);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            while (rs.next()){
                patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        addressDaoH2.findById(rs.getInt(7))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return patient;
    }
}
