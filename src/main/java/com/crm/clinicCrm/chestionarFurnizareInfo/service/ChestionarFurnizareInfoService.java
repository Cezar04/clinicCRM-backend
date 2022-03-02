package com.crm.clinicCrm.chestionarFurnizareInfo.service;

import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoDAO;
import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ChestionarFurnizareInfoService {
    List<ChestionarFurnizareInfoModel> findAll();
    ResponseEntity<?> addChestionarFurnizareInfo(ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO, UUID clientId);
    ResponseEntity<?> findChestionarFurnizareInfo(UUID clientId);
    ResponseEntity<?> updateChestionarFurnizareInfo(ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO, UUID chestionarFurnizareInfoId);
    boolean existsChestionarFurnizareInfo(UUID clientId);
}
