package com.crm.clinicCrm.GDPR;

import com.crm.clinicCrm.GDPR.service.GdprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/gdpr")
public class GdprController {

    private GdprService gdprService;

    @Autowired
    public GdprController(GdprService gdprService) {
        this.gdprService = gdprService;
    }

    @PostMapping("/add/{clientId}")
    private ResponseEntity<?> setGdpr(@RequestBody GdprDAO gdprDAO, @PathVariable UUID clientId){
        return gdprService.addGdpr(gdprDAO,clientId);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?>getGdprByClient(@PathVariable UUID clientId){
        return new ResponseEntity<>(gdprService.findByClientId(clientId), HttpStatus.OK);
    }
}
