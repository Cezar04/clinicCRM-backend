package com.crm.clinicCrm.helper;

import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.doctor.DoctorDAO;
import com.crm.clinicCrm.doctor.DoctorModel;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * here we do the converting from the DAO to entity and vice-versa
 */

@Component
public class ServiceHelper {
    public ClientDAO convertToClientDAO(ClientModel clientModel){
        return ClientDAO.builder()
                .firstName(clientModel.getFirstName())
                .lastName(clientModel.getLastName())
                .email(clientModel.getEmail())
                .isCONSENT(clientModel.isCONSENT())
                .isGDPR(clientModel.isGDPR())
                .phoneNumber(clientModel.getPhoneNumber())
                .build();
    }

    public ClientModel convertToClientEntity (ClientDAO clientDAO){
        return ClientModel.builder()
                .firstName(clientDAO.getFirstName())
                .lastName(clientDAO.getLastName())
                .phoneNumber(clientDAO.getPhoneNumber())
                .email(clientDAO.getEmail())
                .isCONSENT(clientDAO.isCONSENT())
                .isGDPR(clientDAO.isGDPR())
                .build();
    }

    public DoctorDAO convertToDoctorDAO(DoctorModel doctorModel){
        return DoctorDAO.builder()
                .firstName(doctorModel.getFirstName())
                .lastName(doctorModel.getLastName())
                .email(doctorModel.getEmail())
                .phoneNumber(doctorModel.getPhoneNumber())
                .build();
    }

    public DoctorModel convertToDoctorEntity(DoctorDAO doctorDAO){
        return DoctorModel.builder()
                .firstName(doctorDAO.getFirstName())
                .lastName(doctorDAO.getLastName())
                .email(doctorDAO.getEmail())
                .phoneNumber(doctorDAO.getPhoneNumber())
                .build();
    }
}
