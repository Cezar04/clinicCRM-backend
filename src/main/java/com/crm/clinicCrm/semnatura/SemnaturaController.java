package com.crm.clinicCrm.semnatura;

import com.crm.clinicCrm.semnatura.service.SemnaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/semnatura")
public class SemnaturaController {

    private SemnaturaServiceImpl semnaturaServiceImpl;

    @Autowired
    public SemnaturaController(SemnaturaServiceImpl semnaturaServiceImpl) {
        this.semnaturaServiceImpl = semnaturaServiceImpl;
    }


    @PostMapping("/add/{chestionarEvalGenID}/{clientId}")
    public ResponseEntity<?> addSemnatura(@RequestParam("file")MultipartFile file, @PathVariable UUID chestionarEvalGenID,@PathVariable UUID clientId) throws IOException {
        return semnaturaServiceImpl.store(file,chestionarEvalGenID,clientId);
    }
}
