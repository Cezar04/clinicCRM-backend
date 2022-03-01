package com.crm.clinicCrm.semnatura.service;

import com.crm.clinicCrm.semnatura.SemnaturaModel;
import com.crm.clinicCrm.semnatura.SemnaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class SemnaturaServiceImpl implements SemnaturaService{

    private SemnaturaRepository semnaturaRepository;



    @Autowired
    public SemnaturaServiceImpl(SemnaturaRepository semnaturaRepository) {
        this.semnaturaRepository = semnaturaRepository;
    }

    public ResponseEntity<?> store(String file, UUID chestionarEvalGenId, UUID clientId) throws IOException {

        String fileName = "semnatura";
        SemnaturaModel semnatura = new SemnaturaModel();
        semnatura.setNumeSemnatura(fileName);
        semnatura.setData(file);
        semnatura.setClientId(clientId);
        semnatura.setChestionarEvalGenId(chestionarEvalGenId);
        semnatura.setCreateDateTime(LocalDate.now());

        semnaturaRepository.save(semnatura);

        return new ResponseEntity<>(semnatura, HttpStatus.OK);
    }

    public SemnaturaModel getSemnaturaByChestionarEvalGenId(UUID ChestionarEvalGenId){
        return  semnaturaRepository.findByChestionarEvalGenId(ChestionarEvalGenId);
    }

    @Override
    public Boolean existsSemnatura(UUID chestionarEvalGenId) {
        return semnaturaRepository.existsByChestionarEvalGenId(chestionarEvalGenId);
    }
}
