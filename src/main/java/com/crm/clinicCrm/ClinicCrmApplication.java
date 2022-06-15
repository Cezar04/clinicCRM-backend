package com.crm.clinicCrm;

import com.crm.clinicCrm.files.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ClinicCrmApplication implements CommandLineRunner {

    @Resource
    FilesStorageService storageService;
    public static void main(String[] args) {
        SpringApplication.run(ClinicCrmApplication.class, args);
    }

    @Override
    public void run(String...arg) throws Exception {
//        storageService.deleteAll();
        storageService.init();
    }
}
