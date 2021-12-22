package com.crm.clinicCrm.helper;

import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.service.ClientService;
import com.crm.clinicCrm.doctor.DoctorDAO;
import com.crm.clinicCrm.doctor.DoctorModel;
import com.crm.clinicCrm.medicalRecord.RecordDAO;
import com.crm.clinicCrm.medicalRecord.RecordModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * here we do the converting from the DAO to entity and vice-versa
 */

@Component
public class ServiceHelper {
    public ClientDAO convertToClientDAO(ClientModel clientModel){
        return ClientDAO.builder()
                .id(clientModel.getId())
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
                .id(doctorModel.getId())
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

    public RecordDAO convertToRecordDAO(RecordModel recordModel){

        return RecordDAO.builder()
                .id(recordModel.getId())
                .comment(recordModel.getComment())
                .procedure(recordModel.getProcedure())
                .build();
    }

    public RecordModel convertToRecordEntity(RecordDAO recordDAO){
        return  RecordModel.builder()
                .comment(recordDAO.getComment())
                .procedure(recordDAO.getProcedure())
                .build();
    }
}
