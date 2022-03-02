package com.crm.clinicCrm.chestionarFurnizareInfo;


import com.crm.clinicCrm.chestionarFurnizareInfo.service.ChestionarFurnizareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/chestionar-furnizare-info")
public class ChestionarFurnizareInfoController {

    private ChestionarFurnizareInfoService chestionarFurnizareInfoService;

    @Autowired
    public ChestionarFurnizareInfoController(ChestionarFurnizareInfoService chestionarFurnizareInfoService) {
        this.chestionarFurnizareInfoService = chestionarFurnizareInfoService;
    }

    @GetMapping("/all")
    public List<ChestionarFurnizareInfoModel> getAllChestionare(){
        return chestionarFurnizareInfoService.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?>getChestionar(@PathVariable UUID clientId) {
        return chestionarFurnizareInfoService.findChestionarFurnizareInfo(clientId);
    }

    @PostMapping("/add/{clientId}")
    private ResponseEntity<?> addChestionar(@RequestBody ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO, @PathVariable UUID clientId){
        return chestionarFurnizareInfoService.addChestionarFurnizareInfo(chestionarFurnizareInfoDAO, clientId);
    }

    @PutMapping("/edit/{chestionarId}")
    public ResponseEntity<?> updateChestionar(@RequestBody ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO, @PathVariable UUID chestionarId){
        return  chestionarFurnizareInfoService.updateChestionarFurnizareInfo(chestionarFurnizareInfoDAO, chestionarId);
    }
}
