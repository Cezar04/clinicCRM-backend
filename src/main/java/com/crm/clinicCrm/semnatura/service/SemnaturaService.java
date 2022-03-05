package com.crm.clinicCrm.semnatura.service;

import com.crm.clinicCrm.semnatura.SemnaturaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface SemnaturaService {
    ResponseEntity<?> store(String file, UUID chestionarEvalGenId, UUID clientId) throws IOException;
    ResponseEntity<?> addSignature(String file, UUID clientId, String numeChestionar);
    SemnaturaModel getSemnaturaByChestionarId(UUID ChestionarId);
    SemnaturaModel getSemnaturaByNumeChestionarAndClientId(UUID clientId, String numeChestionar);
    Boolean existsSemnatura(UUID chestionarId);
    Boolean existsSemnaturaByNumeChestionarAndClientId(String numeChestionar, UUID clientid);
}
