package com.crm.clinicCrm.chestionarEvalGenerala.service;

import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenDAO;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenModal;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenRepository;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ChestionarEvalGenServiceImpl implements ChestionarEvalGenService{
    private ChestionarEvalGenRepository chestionarEvalGenRepository;
    private ClientRepository clientRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public ChestionarEvalGenServiceImpl(ChestionarEvalGenRepository chestionarEvalGenRepository, ClientRepository clientRepository, ServiceHelper serviceHelper) {
        this.chestionarEvalGenRepository = chestionarEvalGenRepository;
        this.clientRepository = clientRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<ChestionarEvalGenModal> findAll() {
        return chestionarEvalGenRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addChestionrEvalGenService(ChestionarEvalGenDAO chestionarEvalGenDAO, UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);

        if (clientModelOptional.isPresent()){
            ChestionarEvalGenModal chestionar = serviceHelper.convertToChestionarEvalGenEntity(chestionarEvalGenDAO);
            chestionar.setCreateDateTime(LocalDate.now());
            chestionar.setClient(clientModelOptional.get());
            chestionarEvalGenRepository.save(chestionar);

            return new ResponseEntity<>(chestionar, HttpStatus.OK);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("add client first");
        }

    }

    @Override
    public ResponseEntity<?> findChestionarEvalGenByClientId(UUID clientId) {
       ChestionarEvalGenModal chestionarEvalGenModal = chestionarEvalGenRepository.findByClientId(clientId);
       ChestionarEvalGenDAO  chestionar= serviceHelper.convertToChestionarEvalGenDAO( chestionarEvalGenModal);
       return new ResponseEntity<>(chestionar, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateChestionarEvalGen(ChestionarEvalGenDAO chestionarEvalGenDAO, UUID chestionarEvalGenId) {
        Optional<ChestionarEvalGenModal> chestionarEvalGenModalOptional = chestionarEvalGenRepository.findById(chestionarEvalGenId);
        ChestionarEvalGenModal unmanagedChestionarEvalGen = serviceHelper.convertToChestionarEvalGenEntity(chestionarEvalGenDAO);

        if(chestionarEvalGenModalOptional.isPresent()){
            ChestionarEvalGenModal managedChestionarEvalGen = chestionarEvalGenModalOptional.get();

            managedChestionarEvalGen.setGravida(unmanagedChestionarEvalGen.isGravida());
            managedChestionarEvalGen.setNrSaptamaniSarcina(unmanagedChestionarEvalGen.getNrSaptamaniSarcina());
            managedChestionarEvalGen.setDataUltimeiMenstruatii(unmanagedChestionarEvalGen.getDataUltimeiMenstruatii());

            managedChestionarEvalGen.setAlergiiSauIntoleranta(unmanagedChestionarEvalGen.isAlergiiSauIntoleranta());
            managedChestionarEvalGen.setAlergii(unmanagedChestionarEvalGen.getAlergii());
            managedChestionarEvalGen.setIntoleranta(unmanagedChestionarEvalGen.getIntoleranta());

            managedChestionarEvalGen.setUrmatiTratament(unmanagedChestionarEvalGen.isUrmatiTratament());
            managedChestionarEvalGen.setProdus(unmanagedChestionarEvalGen.getProdus());
            managedChestionarEvalGen.setDozaTratament(unmanagedChestionarEvalGen.getDozaTratament());

            managedChestionarEvalGen.setTratamentAntibiotic(unmanagedChestionarEvalGen.isTratamentAntibiotic());
            managedChestionarEvalGen.setAntibioticul(unmanagedChestionarEvalGen.getAntibioticul());
            managedChestionarEvalGen.setDozaAntibiotic(unmanagedChestionarEvalGen.getDozaAntibiotic());
            managedChestionarEvalGen.setAfectiuneaTrata(unmanagedChestionarEvalGen.getAfectiuneaTrata());

            managedChestionarEvalGen.setAfectiuneCronica(unmanagedChestionarEvalGen.isAfectiuneCronica());
            managedChestionarEvalGen.setBoliRenale(unmanagedChestionarEvalGen.isBoliRenale());
            managedChestionarEvalGen.setInsuficientaRenala(unmanagedChestionarEvalGen.isInsuficientaRenala());
            managedChestionarEvalGen.setBoliProfesionale(unmanagedChestionarEvalGen.getBoliProfesionale());
            managedChestionarEvalGen.setAnginaPectorala(unmanagedChestionarEvalGen.isAnginaPectorala());
            managedChestionarEvalGen.setInfarctMiocardic(unmanagedChestionarEvalGen.isInfarctMiocardic());
            managedChestionarEvalGen.setValvulopatii(unmanagedChestionarEvalGen.isValvulopatii());
            managedChestionarEvalGen.setEndocardita(unmanagedChestionarEvalGen.isEndocardita());
            managedChestionarEvalGen.setDurere(unmanagedChestionarEvalGen.isDurere());
            managedChestionarEvalGen.setSufocare(unmanagedChestionarEvalGen.isSufocare());
            managedChestionarEvalGen.setAlteleBoliInima(unmanagedChestionarEvalGen.getAlteleBoliInima());
            managedChestionarEvalGen.setArteriopatii(unmanagedChestionarEvalGen.isArteriopatii());
            managedChestionarEvalGen.setVarice(unmanagedChestionarEvalGen.isVarice());
            managedChestionarEvalGen.setTromboFlebite(unmanagedChestionarEvalGen.isTromboFlebite());
            managedChestionarEvalGen.setEmbolii(unmanagedChestionarEvalGen.isEmbolii());
            managedChestionarEvalGen.setHipertensiuneArteriala(unmanagedChestionarEvalGen.isHipertensiuneArteriala());
            managedChestionarEvalGen.setHipotensiuneArteriala(unmanagedChestionarEvalGen.isHipotensiuneArteriala());
            managedChestionarEvalGen.setAlteleBoliVasculare(unmanagedChestionarEvalGen.getAlteleBoliVasculare());
            managedChestionarEvalGen.setSida(unmanagedChestionarEvalGen.isSida());
            managedChestionarEvalGen.setTBC(unmanagedChestionarEvalGen.isTBC());
            managedChestionarEvalGen.setBronsitaCronica(unmanagedChestionarEvalGen.isBronsitaCronica());
            managedChestionarEvalGen.setAstm(unmanagedChestionarEvalGen.isAstm());
            managedChestionarEvalGen.setSilicoza(unmanagedChestionarEvalGen.isSilicoza());
            managedChestionarEvalGen.setAlteleBoliPlamani(unmanagedChestionarEvalGen.getAlteleBoliPlamani());
            managedChestionarEvalGen.setGastrita(unmanagedChestionarEvalGen.isGastrita());
            managedChestionarEvalGen.setUlcer(unmanagedChestionarEvalGen.isUlcer());
            managedChestionarEvalGen.setRefluxEsofagian(unmanagedChestionarEvalGen.isRefluxEsofagian());
            managedChestionarEvalGen.setHernieHiatala(unmanagedChestionarEvalGen.isHernieHiatala());
            managedChestionarEvalGen.setAlteleBoliDigestive(unmanagedChestionarEvalGen.getAlteleBoliDigestive());
            managedChestionarEvalGen.setHepatita(unmanagedChestionarEvalGen.isHepatita());
            managedChestionarEvalGen.setCiroza(unmanagedChestionarEvalGen.isCiroza());
            managedChestionarEvalGen.setAlteleBoliHepatice(unmanagedChestionarEvalGen.getAlteleBoliHepatice());
            managedChestionarEvalGen.setDiabetZaharat(unmanagedChestionarEvalGen.isDiabetZaharat());
            managedChestionarEvalGen.setGuta(unmanagedChestionarEvalGen.isGuta());
            managedChestionarEvalGen.setAlteleBoliMetabolice(unmanagedChestionarEvalGen.getAlteleBoliMetabolice());
            managedChestionarEvalGen.setHipertiroidism(unmanagedChestionarEvalGen.isHipertiroidism());
            managedChestionarEvalGen.setFeocromocitom(unmanagedChestionarEvalGen.isFeocromocitom());
            managedChestionarEvalGen.setAlteleBoliEndocrine(unmanagedChestionarEvalGen.getAlteleBoliEndocrine());
            managedChestionarEvalGen.setEpilepsie(unmanagedChestionarEvalGen.isEpilepsie());
            managedChestionarEvalGen.setAlteleBoliNeurologice(unmanagedChestionarEvalGen.getAlteleBoliNeurologice());
            managedChestionarEvalGen.setAfectiuniColoana(unmanagedChestionarEvalGen.isAfectiuniColoana());
            managedChestionarEvalGen.setAlteleAfectiuniSchelet(unmanagedChestionarEvalGen.getAlteleAfectiuniSchelet());
            managedChestionarEvalGen.setDepresii(unmanagedChestionarEvalGen.isDepresii());
            managedChestionarEvalGen.setFobii(unmanagedChestionarEvalGen.isFobii());
            managedChestionarEvalGen.setAlteleBoliPsihice(unmanagedChestionarEvalGen.getAlteleBoliPsihice());
            managedChestionarEvalGen.setSangeratiUsor(unmanagedChestionarEvalGen.isSangeratiUsor());
            managedChestionarEvalGen.setHemofilie(unmanagedChestionarEvalGen.isHemofilie());
            managedChestionarEvalGen.setAnemie(unmanagedChestionarEvalGen.isAnemie());
            managedChestionarEvalGen.setLeucemie(unmanagedChestionarEvalGen.isLeucemie());
            managedChestionarEvalGen.setLimfom(unmanagedChestionarEvalGen.isLimfom());
            managedChestionarEvalGen.setAlteleBoliHematologice(unmanagedChestionarEvalGen.getAlteleBoliHematologice());
            managedChestionarEvalGen.setAlteBoli(unmanagedChestionarEvalGen.getAlteBoli());

            managedChestionarEvalGen.setBoliInfectioase(unmanagedChestionarEvalGen.isBoliInfectioase());
            managedChestionarEvalGen.setHepatitaB(unmanagedChestionarEvalGen.isHepatitaB());
            managedChestionarEvalGen.setHepatitaC(unmanagedChestionarEvalGen.isHepatitaC());
            managedChestionarEvalGen.setHepatitaViralaCronica(unmanagedChestionarEvalGen.isHepatitaViralaCronica());
            managedChestionarEvalGen.setHIV(unmanagedChestionarEvalGen.isHIV());
            managedChestionarEvalGen.setAlteBoliCronice(unmanagedChestionarEvalGen.getAlteBoliCronice());

            managedChestionarEvalGen.setAtiPrimitSange(unmanagedChestionarEvalGen.isAtiPrimitSange());
            managedChestionarEvalGen.setCuCeOcazie(unmanagedChestionarEvalGen.getCuCeOcazie());

            managedChestionarEvalGen.setTratamenteStomatologice(unmanagedChestionarEvalGen.isTratamenteStomatologice());
            managedChestionarEvalGen.setFaraAnestezie(unmanagedChestionarEvalGen.isFaraAnestezie());
            managedChestionarEvalGen.setCuAnestezieLocala(unmanagedChestionarEvalGen.isCuAnestezieLocala());
            managedChestionarEvalGen.setCuAnestezieLocalaSiSedareInhalatorie(unmanagedChestionarEvalGen.isCuAnestezieLocalaSiSedareInhalatorie());
            managedChestionarEvalGen.setCuAnestezieLocalaSiSedareIntravenoasa(unmanagedChestionarEvalGen.isCuAnestezieLocalaSiSedareIntravenoasa());
            managedChestionarEvalGen.setAnestezieGenerala(unmanagedChestionarEvalGen.isAnestezieGenerala());

            managedChestionarEvalGen.setAuAparutAccidenteLaStomatologie(unmanagedChestionarEvalGen.isAuAparutAccidenteLaStomatologie());
            managedChestionarEvalGen.setLesin(unmanagedChestionarEvalGen.isLesin());
            managedChestionarEvalGen.setGreata(unmanagedChestionarEvalGen.isGreata());
            managedChestionarEvalGen.setAlergiiStomatoligice(unmanagedChestionarEvalGen.isAlergiiStomatoligice());
            managedChestionarEvalGen.setAlteleStomatologice(unmanagedChestionarEvalGen.getAlteleStomatologice());

            managedChestionarEvalGen.setTratamenteChirugicale(unmanagedChestionarEvalGen.isTratamenteChirugicale());
            managedChestionarEvalGen.setInterventii(unmanagedChestionarEvalGen.getInterventii());
            managedChestionarEvalGen.setAnestezieLocoRegionala(unmanagedChestionarEvalGen.isAnestezieLocoRegionala());
            managedChestionarEvalGen.setSedareInhalatorie(unmanagedChestionarEvalGen.isSedareInhalatorie());
            managedChestionarEvalGen.setSedareIntravenoasa(unmanagedChestionarEvalGen.isSedareIntravenoasa());
            managedChestionarEvalGen.setSedareGenerala(unmanagedChestionarEvalGen.isSedareGenerala());

            managedChestionarEvalGen.setFumati(unmanagedChestionarEvalGen.isFumati());
            managedChestionarEvalGen.setCateTigari(unmanagedChestionarEvalGen.getCateTigari());
            managedChestionarEvalGen.setCatiAni(unmanagedChestionarEvalGen.getCatiAni());

            managedChestionarEvalGen.setBauturiAlcoolice(unmanagedChestionarEvalGen.isBauturiAlcoolice());
            managedChestionarEvalGen.setTipBauturi(unmanagedChestionarEvalGen.getTipBauturi());
            managedChestionarEvalGen.setCantitate(unmanagedChestionarEvalGen.getCantitate());
            managedChestionarEvalGen.setProblemeDacaIntrerupetiConsumul(unmanagedChestionarEvalGen.isProblemeDacaIntrerupetiConsumul());

            managedChestionarEvalGen.setConsumatiDroguri(unmanagedChestionarEvalGen.isConsumatiDroguri());
            managedChestionarEvalGen.setTipDroguri(unmanagedChestionarEvalGen.getTipDroguri());
            managedChestionarEvalGen.setCantitateDroguri(unmanagedChestionarEvalGen.getCantitateDroguri());
            managedChestionarEvalGen.setSuntetiDependent(unmanagedChestionarEvalGen.isSuntetiDependent());

            managedChestionarEvalGen.setMentionari(unmanagedChestionarEvalGen.getMentionari());

            chestionarEvalGenRepository.save(managedChestionarEvalGen);

            return ResponseEntity.status(HttpStatus.OK).body(managedChestionarEvalGen+ "eval gen created");


        }else{
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("chestionar "+ chestionarEvalGenId+" not found");
        }
        return null;
    }

    @Override
    public ResponseEntity<?> deleteChestionarEvalGen(UUID chestionarEvalGenId) {
        Optional<ChestionarEvalGenModal> chestionarEvalGenModal = chestionarEvalGenRepository.findById(chestionarEvalGenId);

        if(chestionarEvalGenModal.isPresent()){
            ChestionarEvalGenModal chestionar = chestionarEvalGenModal.get();
            chestionarEvalGenRepository.delete(chestionar);

            return new ResponseEntity<>(chestionar,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("no record found to delete!", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public boolean existChestionarEvalGen(UUID clientId) {
        return chestionarEvalGenRepository.existsByClientId(clientId);
    }
}
