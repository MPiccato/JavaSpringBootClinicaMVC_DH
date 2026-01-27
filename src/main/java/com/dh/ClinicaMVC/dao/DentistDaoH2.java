package com.dh.ClinicaMVC.dao;

import com.dh.ClinicaMVC.model.Dentist;
import com.dh.ClinicaMVC.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist> {

    private static final String SQL_INSERT_DENTIST = "INSERT INTO DENTIST (REGISTRATION, NAME, LAST_NAME) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_DENTIST_BY_ID = "SELECT * FROM DENTIST WHERE ID = ?";
    private static final String SQL_UPDATE_DENTIST = "UPDATE DENTIST SET REGISTRATION = ?, NAME = ?, LAST_NAME = ? WHERE ID = ?";
    private static final String SQL_DELETE_DENTIST_BY_ID = "DELETE FROM DENTIST WHERE ID = ?";
    private static final String SQL_FIND_ALL_DENTISTS = "SELECT * FROM DENTIST";


    @Override
    public Dentist save(Dentist dentist) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_DENTIST, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dentist.getRegistration());
            ps.setString(2, dentist.getName());
            ps.setString(3, dentist.getLastName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dentist.setId(rs.getInt(1));
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {;
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return dentist;
    }

    @Override
    public Dentist findById(Integer id) {

        Connection connection = null;
        Dentist dentist = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_DENTIST_BY_ID);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                dentist =  new Dentist(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
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
        return dentist;
    }

    @Override
    public void update(Dentist dentist) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_DENTIST);

            ps.setInt(1, dentist.getRegistration());
            ps.setString(2, dentist.getName());
            ps.setString(3, dentist.getLastName());
            ps.setInt(4, dentist.getId());
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
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_DENTIST_BY_ID);
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
    public List<Dentist> findAll() {
        List<Dentist> dentists = new ArrayList<>();
        Connection connection = null;
        Dentist dentist = null;
        try {

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL_DENTISTS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                dentist = new Dentist(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
                dentists.add(dentist);
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
        return dentists;
    }

    @Override
    public Dentist findByEmail(String value) {
        return null;
    }
}
