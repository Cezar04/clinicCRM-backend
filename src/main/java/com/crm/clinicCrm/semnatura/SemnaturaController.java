package com.crm.clinicCrm.semnatura;

import com.crm.clinicCrm.semnatura.service.SemnaturaService;
import com.crm.clinicCrm.semnatura.service.SemnaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/semnatura")
public class SemnaturaController {

    private SemnaturaService semnaturaServiceImpl;

    @Autowired
    public SemnaturaController(SemnaturaServiceImpl semnaturaServiceImpl) {
        this.semnaturaServiceImpl = semnaturaServiceImpl;
    }


    @PostMapping("/add/{chestionarEvalGenID}/{clientId}")
    public ResponseEntity<?> addSemnatura(@RequestBody String file, @PathVariable UUID chestionarEvalGenID,@PathVariable UUID clientId) throws IOException {
        if (semnaturaServiceImpl.existsSemnatura(chestionarEvalGenID)){
            return  ResponseEntity.badRequest().body("Semnatura already exists");
        }
        return semnaturaServiceImpl.store(file,chestionarEvalGenID,clientId);
    }

    @GetMapping("/{chestionarEvalGenId}")
    public ResponseEntity<?> getSemnaturaByChestionarId(@PathVariable UUID chestionarEvalGenId){
        return new ResponseEntity<>(semnaturaServiceImpl.getSemnaturaByChestionarEvalGenId(chestionarEvalGenId), HttpStatus.OK);
    }

}
