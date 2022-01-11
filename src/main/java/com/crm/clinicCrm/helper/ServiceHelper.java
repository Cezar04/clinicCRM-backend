package com.crm.clinicCrm.helper;

import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenDAO;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenModal;
import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.service.ClientService;
import com.crm.clinicCrm.doctor.DoctorDAO;
import com.crm.clinicCrm.doctor.DoctorModel;
import com.crm.clinicCrm.medicalRecord.RecordDAO;
import com.crm.clinicCrm.medicalRecord.RecordModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * here we do the converting from the DAO to entity and vice-versa
 */

@Component
public class ServiceHelper {
    public ClientDAO convertToClientDAO(ClientModel clientModel){
        return ClientDAO.builder()
                .id(clientModel.getId())
                .firstName(clientModel.getFirstName())
                .lastName(clientModel.getLastName())
                .email(clientModel.getEmail())
                .phoneNumber(clientModel.getPhoneNumber())
                .sex(clientModel.getSex())
                .age(clientModel.getAge())
                .CNP(clientModel.getCNP())
                .address(clientModel.getAddress())
                .occupation(clientModel.getOccupation())
                .isGDPR(clientModel.isGDPR())
                .build();
    }

    public ClientModel convertToClientEntity (ClientDAO clientDAO){
        return ClientModel.builder()
                .firstName(clientDAO.getFirstName())
                .lastName(clientDAO.getLastName())
                .email(clientDAO.getEmail())
                .phoneNumber(clientDAO.getPhoneNumber())
                .sex(clientDAO.getSex())
                .age(clientDAO.getAge())
                .CNP(clientDAO.getCNP())
                .address(clientDAO.getAddress())
                .occupation(clientDAO.getOccupation())
                .isGDPR(clientDAO.isGDPR())
                .build();
    }

    public DoctorDAO convertToDoctorDAO(DoctorModel doctorModel){
        return DoctorDAO.builder()
                .id(doctorModel.getId())
                .firstName(doctorModel.getFirstName())
                .lastName(doctorModel.getLastName())
                .email(doctorModel.getEmail())
                .phoneNumber(doctorModel.getPhoneNumber())
                .build();
    }

    public DoctorModel convertToDoctorEntity(DoctorDAO doctorDAO){
        return DoctorModel.builder()
                .firstName(doctorDAO.getFirstName())
                .lastName(doctorDAO.getLastName())
                .email(doctorDAO.getEmail())
                .phoneNumber(doctorDAO.getPhoneNumber())
                .build();
    }

    public RecordDAO convertToRecordDAO(RecordModel recordModel){

        return RecordDAO.builder()
                .id(recordModel.getId())
                .comment(recordModel.getComment())
                .procedure(recordModel.getProcedure())
                .isConfirmed(recordModel.isConfirmed())
                .build();
    }

    public RecordModel convertToRecordEntity(RecordDAO recordDAO){
        return  RecordModel.builder()
                .comment(recordDAO.getComment())
                .procedure(recordDAO.getProcedure())
                .isConfirmed(recordDAO.isConfirmed())
                .build();
    }

    public ChestionarEvalGenModal convertToChestionarEvalGenEntity(ChestionarEvalGenDAO chestionarEvalGenDAO){
        return ChestionarEvalGenModal.builder()
                .afectiuneaTrata(chestionarEvalGenDAO.getAfectiuneaTrata())
                .afectiuniColoana(chestionarEvalGenDAO.isAfectiuniColoana())
                .afectiuneCronica(chestionarEvalGenDAO.isBronsitaCronica())
                .alergii(chestionarEvalGenDAO.getAlergii())
                .alergiiStomatoligice(chestionarEvalGenDAO.isAlergiiStomatoligice())
                .alteBoli(chestionarEvalGenDAO.getAlteBoli())
                .alteBoliCronice(chestionarEvalGenDAO.getAlteBoliCronice())
                .alteleAfectiuniSchelet(chestionarEvalGenDAO.isAlteleAfectiuniSchelet())
                .alteleBoliDigestive(chestionarEvalGenDAO.isAlteleBoliDigestive())
                .alteleBoliEndocrine(chestionarEvalGenDAO.isAlteleBoliEndocrine())
                .alteleBoliHematologice(chestionarEvalGenDAO.isAlteleBoliHematologice())
                .alteleBoliHepatice(chestionarEvalGenDAO.isAlteleBoliHepatice())
                .alteleBoliInima(chestionarEvalGenDAO.isAlteleBoliInima())
                .alteleBoliMetabolice(chestionarEvalGenDAO.isAlteleBoliMetabolice())
                .alteleBoliNeurologice(chestionarEvalGenDAO.isAlteleBoliNeurologice())
                .alteleBoliPlamani(chestionarEvalGenDAO.isAlteleBoliPlamani())
                .alteleBoliPsihice(chestionarEvalGenDAO.isAlteleBoliPsihice())
                .alteleBoliVasculare(chestionarEvalGenDAO.isAlteleBoliVasculare())
                .alteleStomatologice(chestionarEvalGenDAO.isAlteleStomatologice())
                .anemie(chestionarEvalGenDAO.isAnemie())
                .anestezieGenerala(chestionarEvalGenDAO.isAnestezieGenerala())
                .anestezieLocoRegionala(chestionarEvalGenDAO.isAnestezieLocoRegionala())
                .anginaPectorala(chestionarEvalGenDAO.isAnginaPectorala())
                .antibioticul(chestionarEvalGenDAO.getAntibioticul())
                .arteriopatii(chestionarEvalGenDAO.isArteriopatii())
                .astm(chestionarEvalGenDAO.isAstm())
                .atiPrimitSange(chestionarEvalGenDAO.isAtiPrimitSange())
                .auAparutAccidenteLaStomatologie(chestionarEvalGenDAO.isAuAparutAccidenteLaStomatologie())
                .bauturiAlcoolice(chestionarEvalGenDAO.isBauturiAlcoolice())
                .boliInfectioase(chestionarEvalGenDAO.isBoliInfectioase())
                .boliProfesionale(chestionarEvalGenDAO.getBoliProfesionale())
                .bronsitaCronica(chestionarEvalGenDAO.isBronsitaCronica())
                .cantitate(chestionarEvalGenDAO.getCantitate())
                .cantitateDroguri(chestionarEvalGenDAO.getCantitateDroguri())
                .cateTigari(chestionarEvalGenDAO.getCateTigari())
                .catiAni(chestionarEvalGenDAO.getCatiAni())
                .ciroza(chestionarEvalGenDAO.isCiroza())
                .consumatiDroguri(chestionarEvalGenDAO.isConsumatiDroguri())
                .cuAnestezieLocala(chestionarEvalGenDAO.isCuAnestezieLocala())
                .cuAnestezieLocalaSiSedareInhalatorie(chestionarEvalGenDAO.isCuAnestezieLocalaSiSedareInhalatorie())
//                aici e ceva dubios
                .createDateTime(new Date())
                .cuAnestezieLocalaSiSedareIntravenoasa(chestionarEvalGenDAO.isCuAnestezieLocalaSiSedareIntravenoasa())
                .cuCeOcazie(chestionarEvalGenDAO.getCuCeOcazie())
                .dataUltimeiMenstruatii(chestionarEvalGenDAO.getDataUltimeiMenstruatii())
                .depresii(chestionarEvalGenDAO.isDepresii())
                .diabetZaharat(chestionarEvalGenDAO.isDiabetZaharat())
                .dozaAntibiotic(chestionarEvalGenDAO.getDozaAntibiotic())
                .dozaTratament(chestionarEvalGenDAO.getDozaTratament())
                .durere(chestionarEvalGenDAO.isDurere())
                .embolii(chestionarEvalGenDAO.isEmbolii())
                .endocardita(chestionarEvalGenDAO.isEndocardita())
                .epilepsie(chestionarEvalGenDAO.isEpilepsie())
                .faraAnestezie(chestionarEvalGenDAO.isFaraAnestezie())
                .feocromocitom(chestionarEvalGenDAO.isFeocromocitom())
                .fobii(chestionarEvalGenDAO.isFobii())
                .fumati(chestionarEvalGenDAO.isFumati())
                .gastrita(chestionarEvalGenDAO.isGastrita())
                .greata(chestionarEvalGenDAO.isGreata())
                .guta(chestionarEvalGenDAO.isGuta())
                .hemofilie(chestionarEvalGenDAO.isHemofilie())
                .hepatita(chestionarEvalGenDAO.isHepatita())
                .hepatitaB(chestionarEvalGenDAO.isHepatitaB())
                .hepatitaC(chestionarEvalGenDAO.isHepatitaC())
                .hernieHiatala(chestionarEvalGenDAO.isHernieHiatala())
                .hipertensiuneArteriala(chestionarEvalGenDAO.isHipertensiuneArteriala())
                .hipertiroidism(chestionarEvalGenDAO.isHipertiroidism())
                .HIV(chestionarEvalGenDAO.isHIV())
                .id(chestionarEvalGenDAO.getId())
                .infarctMiocardic(chestionarEvalGenDAO.isInfarctMiocardic())
                .interventii(chestionarEvalGenDAO.getInterventii())
                .intoleranta(chestionarEvalGenDAO.getIntoleranta())
                .isAlergiiSauIntoleranta(chestionarEvalGenDAO.isAlergiiSauIntoleranta())
                .isGravida(chestionarEvalGenDAO.isGravida())
                .lesin(chestionarEvalGenDAO.isLesin())
                .leucemie(chestionarEvalGenDAO.isLeucemie())
                .limfom(chestionarEvalGenDAO.isLimfom())
                .mentionari(chestionarEvalGenDAO.getMentionari())
                .nrSaptamaniSarcina(chestionarEvalGenDAO.getNrSaptamaniSarcina())
                .problemeDacaIntrerupetiConsumul(chestionarEvalGenDAO.isProblemeDacaIntrerupetiConsumul())
                .produs(chestionarEvalGenDAO.getProdus())
                .refluxEsofagian(chestionarEvalGenDAO.isRefluxEsofagian())
                .sangeratiUsor(chestionarEvalGenDAO.isSangeratiUsor())
                .sedareGenerala(chestionarEvalGenDAO.isSedareGenerala())
                .sedareInhalatorie(chestionarEvalGenDAO.isSedareInhalatorie())
                .sedareIntravenoasa(chestionarEvalGenDAO.isSedareIntravenoasa())
                .silicoza(chestionarEvalGenDAO.isSilicoza())
                .sufocare(chestionarEvalGenDAO.isSufocare())
                .suntetiDependent(chestionarEvalGenDAO.isSuntetiDependent())
                .TBC(chestionarEvalGenDAO.isTBC())
                .tipBauturi(chestionarEvalGenDAO.getTipBauturi())
                .tipDroguri(chestionarEvalGenDAO.getTipDroguri())
                .tratamentAntibiotic(chestionarEvalGenDAO.isTratamentAntibiotic())
                .tratamenteChirugicale(chestionarEvalGenDAO.isTratamenteChirugicale())
                .tratamenteStomatologice(chestionarEvalGenDAO.isTratamenteStomatologice())
                .tromboFlebite(chestionarEvalGenDAO.isTromboFlebite())
                .ulcer(chestionarEvalGenDAO.isUlcer())
                .urmatiTratament(chestionarEvalGenDAO.isUrmatiTratament())
                .valvulopatii(chestionarEvalGenDAO.isValvulopatii())
                .varice(chestionarEvalGenDAO.isVarice())
                .build();
    }

//    TODO fa si convert to DAO
}
