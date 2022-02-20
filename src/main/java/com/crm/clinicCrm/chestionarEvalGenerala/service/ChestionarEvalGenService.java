package com.crm.clinicCrm.chestionarEvalGenerala.service;

import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenDAO;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenModal;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ChestionarEvalGenService {
    List<ChestionarEvalGenModal> findAll();
    ResponseEntity<?> addChestionrEvalGenService(ChestionarEvalGenDAO chestionarEvalGenDAO, UUID clientId);
    ResponseEntity<?> findChestionarEvalGenByClientId(UUID clientId);
    ResponseEntity<?> updateChestionarEvalGen(ChestionarEvalGenDAO chestionarEvalGenDAO, UUID chestionarEvalGenId);
    ResponseEntity<?> deleteChestionarEvalGen(UUID chestionarEvalGenId);
    boolean existChestionarEvalGen(UUID clientId);
}
