package com.crm.clinicCrm.chestionarEvalGenerala;


import com.crm.clinicCrm.chestionarEvalGenerala.service.ChestionarEvalGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/chestionar-evaluare-generala")
public class ChestionrEvalGenController {

    private ChestionarEvalGenService chestionarEvalGenService;

    @Autowired
    public ChestionrEvalGenController(ChestionarEvalGenService chestionarEvalGenService) {
        this.chestionarEvalGenService = chestionarEvalGenService;
    }


    @GetMapping("/all")
    public List<ChestionarEvalGenModal> getAllChestionareEvalGen(){
        return chestionarEvalGenService.findAll();
    }

    @GetMapping("/{clientId}")
     public ResponseEntity<?> getChestionarEvalGenByClient(@PathVariable UUID clientId){
        return chestionarEvalGenService.findChestionarEvalGenByClientId(clientId);
    }

    @PostMapping("/add/{clientId}")
    private ResponseEntity<?> addChestionarEvalGen(@RequestBody ChestionarEvalGenDAO chestionarEvalGenDAO, @PathVariable UUID clientId){
        if(chestionarEvalGenService.existChestionarEvalGen(clientId)){
            return ResponseEntity.badRequest().body("Chestionar Already exists");
        }
        return chestionarEvalGenService.addChestionrEvalGenService(chestionarEvalGenDAO, clientId);
    }
    @PutMapping("edit/{chestionarId}")
    public ResponseEntity<?> updateChestionarEvalGen(@RequestBody ChestionarEvalGenDAO chestionarEvalGenDAO, @PathVariable UUID chestionarId){
        return chestionarEvalGenService.updateChestionarEvalGen(chestionarEvalGenDAO,chestionarId);
    }

    @DeleteMapping("/delete/{chestionarEvalGenId}")
    public ResponseEntity<?> deleteChestionarEvalGen(@PathVariable UUID chestionarEvalGenId){
        return chestionarEvalGenService.deleteChestionarEvalGen(chestionarEvalGenId);
    }
}
