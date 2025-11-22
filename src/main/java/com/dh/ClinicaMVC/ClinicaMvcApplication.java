package com.dh.ClinicaMVC;

import com.dh.ClinicaMVC.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaMvcApplication {

	public static void main(String[] args) {

        DB.createTables();

        SpringApplication.run(ClinicaMvcApplication.class, args);
	}

}
