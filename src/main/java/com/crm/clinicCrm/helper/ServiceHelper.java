package com.crm.clinicCrm.helper;

import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.ClientModel;
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
}
