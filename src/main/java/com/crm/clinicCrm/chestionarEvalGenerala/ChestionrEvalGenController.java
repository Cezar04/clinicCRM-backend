package com.crm.clinicCrm.chestionarEvalGenerala;


import com.crm.clinicCrm.chestionarEvalGenerala.service.ChestionarEvalGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/chestionar-evaluare-generala")
public class ChestionrEvalGenController {

    private ChestionarEvalGenService chestionarEvalGenService;

    @Autowired
    public ChestionrEvalGenController(ChestionarEvalGenService chestionarEvalGenService) {
        this.chestionarEvalGenService = chestionarEvalGenService;
    }


    @GetMapping("/all-chestionare-evaluare")
    public List<ChestionarEvalGenModal> getAllChestionareEvalGen(){
        return chestionarEvalGenService.findAll();
    }

    @PostMapping("/add/{clientId}")
    private ResponseEntity<?> addChestionarEvalGen(@RequestBody ChestionarEvalGenDAO chestionarEvalGenDAO, @PathVariable UUID clientId){
        if(chestionarEvalGenService.existChestionarEvalGen(clientId)){
            return ResponseEntity.badRequest().body("Chestionar Already exists");
        }
        return chestionarEvalGenService.addChestionrEvalGenService(chestionarEvalGenDAO, clientId);
    }
}
