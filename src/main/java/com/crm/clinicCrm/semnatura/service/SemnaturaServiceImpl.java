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
import java.util.UUID;


@Service
@Transactional
public class SemnaturaServiceImpl implements SemnaturaService{

    private SemnaturaRepository semnaturaRepository;



    @Autowired
    public SemnaturaServiceImpl(SemnaturaRepository semnaturaRepository) {
        this.semnaturaRepository = semnaturaRepository;
    }

    public ResponseEntity<?> store(MultipartFile file, UUID chestionarEvalGenId, UUID clientId) throws IOException {
        String fileName = file.getOriginalFilename();
        SemnaturaModel semnatura = new SemnaturaModel();
        semnatura.setNumeSemnatura(fileName);
        semnatura.setData(file.getBytes());
        semnatura.setClientId(clientId);
        semnatura.setChestionarEvalGenId(chestionarEvalGenId);

        semnaturaRepository.save(semnatura);

        return new ResponseEntity<>(semnatura, HttpStatus.OK);
    }

    public SemnaturaModel getSemnaturaByChestionarEvalGenId(UUID ChestionarEvalGenId){
        return  semnaturaRepository.findByChestionarEvalGenId(ChestionarEvalGenId);
    }
}
