package com.crm.clinicCrm.chestionarFurnizareInfo.service;


import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoDAO;
import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoModel;
import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoRepository;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ChestionarFurnizareInfoServiceImpl implements ChestionarFurnizareInfoService{
    private ChestionarFurnizareInfoRepository chestionarFurnizareInfoRepository;
    private ClientRepository clientRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public ChestionarFurnizareInfoServiceImpl(ChestionarFurnizareInfoRepository chestionarFurnizareInfoRepository, ClientRepository clientRepository, ServiceHelper serviceHelper) {
        this.chestionarFurnizareInfoRepository = chestionarFurnizareInfoRepository;
        this.clientRepository = clientRepository;
        this.serviceHelper = serviceHelper;
    }


    @Override
    public List<ChestionarFurnizareInfoModel> findAll() {
        return chestionarFurnizareInfoRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addChestionarFurnizareInfo(ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO, UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if(clientModelOptional.isPresent()){
            ChestionarFurnizareInfoModel chestionar = serviceHelper.convertToChestionarFurnizareInfoEntity(chestionarFurnizareInfoDAO);
            chestionar.setCreatedDateTime(LocalDate.now());
            chestionar.setClient(clientModelOptional.get());

            chestionarFurnizareInfoRepository.save(chestionar);

            return new ResponseEntity<>(chestionar, HttpStatus.OK);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("add client first");
        }
    }

    @Override
    public ResponseEntity<?> findChestionarFurnizareInfo(UUID clientId) {
        ChestionarFurnizareInfoModel chestionarFurnizareInfoModel = chestionarFurnizareInfoRepository.findByClientId(clientId);
        ChestionarFurnizareInfoDAO chestionar = serviceHelper.convertToChestionarFurnizareInfoDAO(chestionarFurnizareInfoModel);
        return new ResponseEntity<>(chestionar,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateChestionarFurnizareInfo(ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO, UUID chestionarFurnizareInfoId) {
        Optional<ChestionarFurnizareInfoModel> chestionarFurnizareInfoModelOptional =chestionarFurnizareInfoRepository.findById(chestionarFurnizareInfoId);
        ChestionarFurnizareInfoModel unmanagedChestionar = serviceHelper.convertToChestionarFurnizareInfoEntity(chestionarFurnizareInfoDAO);

        if(chestionarFurnizareInfoModelOptional.isPresent()){
            ChestionarFurnizareInfoModel managedChestionar = serviceHelper.convertToChestionarFurnizareInfoEntity(chestionarFurnizareInfoDAO);

            managedChestionar.setAlternativeViabile(unmanagedChestionar.isAlternativeViabile());
            managedChestionar.setBeneficiileSiConsecintele(unmanagedChestionar.isBeneficiileSiConsecintele());
            managedChestionar.setDreptulLaADouaOpinie(unmanagedChestionar.isDreptulLaADouaOpinie());
            managedChestionar.setInformatiiDespreReguli(unmanagedChestionar.isInformatiiDespreReguli());
            managedChestionar.setMentiuni(unmanagedChestionar.getMentiuni());
            managedChestionar.setInformatiiDespreIdendtitateaPersonalului(unmanagedChestionar.isInformatiiDespreIdendtitateaPersonalului());
            managedChestionar.setInformatiiDespreServiciileMedicale(unmanagedChestionar.isInformatiiDespreServiciileMedicale());
            managedChestionar.setMediaInformatiilor(unmanagedChestionar.getMediaInformatiilor());
            managedChestionar.setPrognostic(unmanagedChestionar.isPrognostic());
            managedChestionar.setNumeSiPrenume(unmanagedChestionar.getNumeSiPrenume());
            managedChestionar.setInterventiileSiStrategie(unmanagedChestionar.isInterventiileSiStrategie());
            managedChestionar.setNaturaSiScopulActuluiMedical(unmanagedChestionar.isNaturaSiScopulActuluiMedical());
            managedChestionar.setRiscurileNeefectuarii(unmanagedChestionar.isRiscurileNeefectuarii());
            managedChestionar.setSituatiiNeprevazute(unmanagedChestionar.isSituatiiNeprevazute());
            managedChestionar.setSupozitiiDiagnostic(unmanagedChestionar.isSupozitiiDiagnostic());
            managedChestionar.setPotRefuzaProcesulEducational(unmanagedChestionar.isPotRefuzaProcesulEducational());
            managedChestionar.setRiscurilePotentiale(unmanagedChestionar.isRiscurilePotentiale());
            managedChestionar.setRescurileNerespectaiiRecomandarilor(unmanagedChestionar.isRescurileNerespectaiiRecomandarilor());

            chestionarFurnizareInfoRepository.save(managedChestionar);
            return ResponseEntity.status(HttpStatus.OK).body(managedChestionar+"chestionar updated");
        }else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("chestionar "+ chestionarFurnizareInfoId+" not found");
        }

        return null;
    }

    @Override
    public boolean existsChestionarFurnizareInfo(UUID clientId) {
        return chestionarFurnizareInfoRepository.existsByClientId(clientId);
    }
}
