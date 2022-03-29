package com.crm.clinicCrm.semnatura.service;

import com.crm.clinicCrm.semnatura.SemnaturaModel;
import com.crm.clinicCrm.semnatura.SemnaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;


@Service
@Transactional
public class SemnaturaServiceImpl implements SemnaturaService{

    private final SemnaturaRepository semnaturaRepository;



    @Autowired
    public SemnaturaServiceImpl(SemnaturaRepository semnaturaRepository) {
        this.semnaturaRepository = semnaturaRepository;
    }

    public ResponseEntity<?> store(String file, UUID chestionarId, UUID clientId) throws IOException {

        SemnaturaModel semnatura = new SemnaturaModel();

        semnatura.setData(file);
        semnatura.setClientId(clientId);
        semnatura.setChestionarId(chestionarId);
        semnatura.setCreateDateTime(LocalDate.now());

        semnaturaRepository.save(semnatura);

        return new ResponseEntity<>(semnatura, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addSignature(String file, UUID clientId, String numeChestionar) {
        SemnaturaModel semnaturaModel = new SemnaturaModel();
        semnaturaModel.setData(file);
        semnaturaModel.setClientId(clientId);
        semnaturaModel.setNumeChestionar(numeChestionar);
        semnaturaModel.setCreateDateTime(LocalDate.now());

        semnaturaRepository.save(semnaturaModel);

        return new ResponseEntity<>(semnaturaModel, HttpStatus.OK);
    }

    public SemnaturaModel getSemnaturaByChestionarId(UUID ChestionarId){
        return  semnaturaRepository.findByChestionarId(ChestionarId);
    }

    @Override
    public SemnaturaModel getSemnaturaByNumeChestionarAndClientId(UUID clientId, String numeChestionar) {
        SemnaturaModel result = semnaturaRepository.findFirstByClientIdAndNumeChestionar (clientId,numeChestionar);
        return result;
    }

    @Override
    public Boolean existsSemnatura(UUID chestionarId) {
        return semnaturaRepository.existsByChestionarId(chestionarId);
    }

    @Override
    public Boolean existsSemnaturaByNumeChestionarAndClientId(String numeChestionar, UUID clientid) {
        return semnaturaRepository.existsByNumeChestionarAndAndClientId(numeChestionar,clientid);
    }
}
