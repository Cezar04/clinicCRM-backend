package com.crm.clinicCrm.GDPR.service;

import com.crm.clinicCrm.GDPR.GdprDAO;
import com.crm.clinicCrm.GDPR.GdprModel;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface GdprService {
    ResponseEntity<?> addGdpr(GdprDAO gdprDAO, UUID clientId);
    GdprModel findByClientId(UUID clientId);
}
