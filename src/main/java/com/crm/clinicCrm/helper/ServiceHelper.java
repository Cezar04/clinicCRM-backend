package com.crm.clinicCrm.helper;

import com.crm.clinicCrm.appointments.AppointmentDAO;
import com.crm.clinicCrm.appointments.AppointmentModel;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenDAO;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenModal;
import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoDAO;
import com.crm.clinicCrm.chestionarFurnizareInfo.ChestionarFurnizareInfoModel;
import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.service.ClientService;
import com.crm.clinicCrm.comments.CommentDAO;
import com.crm.clinicCrm.comments.CommentModel;
import com.crm.clinicCrm.doctor.DoctorDAO;
import com.crm.clinicCrm.doctor.DoctorModel;
import com.crm.clinicCrm.medicalRecord.RecordDAO;
import com.crm.clinicCrm.medicalRecord.RecordModel;
import org.springframework.stereotype.Component;


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
                .birthDate(clientModel.getBirthDate())
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
                .birthDate(clientDAO.getBirthDate())
                .build();
    }

    public DoctorDAO convertToDoctorDAO(DoctorModel doctorModel){
        return DoctorDAO.builder()
                .id(doctorModel.getId())
                .name(doctorModel.getName())
                .domain(doctorModel.getDomain())
                .email(doctorModel.getEmail())
                .phoneNumber(doctorModel.getPhoneNumber())
                .build();
    }

    public DoctorModel convertToDoctorEntity(DoctorDAO doctorDAO){
        return DoctorModel.builder()
                .id(doctorDAO.getId())
                .name(doctorDAO.getName())
                .domain(doctorDAO.getDomain())
                .email(doctorDAO.getEmail())
                .phoneNumber(doctorDAO.getPhoneNumber())
                .build();
    }

    public AppointmentDAO convertToAppointmentDAO(AppointmentModel appointmentModel) {
        return AppointmentDAO.builder()
//                .id(appointmentModel.getId())
                .doctorId(appointmentModel.getDoctorId())
                .doctorName(appointmentModel.getDoctorName())
                .clientFirstName(appointmentModel.getClientFirstName())
                .clientLastName(appointmentModel.getClientLastName())
                .start(appointmentModel.getStartDate())
                .end(appointmentModel.getEndDate())
                .procedure(appointmentModel.getProcedure())
                .build();

    }

    public AppointmentModel convertToAppointmentEntity(AppointmentDAO appointmentDAO) {
        return AppointmentModel.builder()
//                .id(appointmentDAO.getId())
                .doctorId(appointmentDAO.getDoctorId())
                .doctorName(appointmentDAO.getDoctorName())
                .clientFirstName(appointmentDAO.getClientFirstName())
                .clientLastName(appointmentDAO.getClientLastName())
                .startDate(appointmentDAO.getStart())
                .endDate(appointmentDAO.getEnd())
                .procedure(appointmentDAO.getProcedure())
                .build();

    }

    public CommentDAO convertToCommentEntity(CommentModel commentModel) {
        return CommentDAO.builder()
                .content(commentModel.getContent())
                .id(commentModel.getId())
                .build();
    }

    public CommentModel convertToCommentEntity(CommentDAO commentDAO) {
        return CommentModel.builder()
                .content(commentDAO.getContent())
                .id(commentDAO.getId())
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

    public ChestionarFurnizareInfoModel convertToChestionarFurnizareInfoEntity(ChestionarFurnizareInfoDAO chestionarFurnizareInfoDAO){
        return ChestionarFurnizareInfoModel.builder()
                .id(chestionarFurnizareInfoDAO.getId())
                .alternativeViabile(chestionarFurnizareInfoDAO.isAlternativeViabile())
                .beneficiileSiConsecintele(chestionarFurnizareInfoDAO.isBeneficiileSiConsecintele())
                .dreptulLaADouaOpinie(chestionarFurnizareInfoDAO.isDreptulLaADouaOpinie())
                .informatiiDespreIdendtitateaPersonalului(chestionarFurnizareInfoDAO.isInformatiiDespreIdendtitateaPersonalului())
                .informatiiDespreReguli(chestionarFurnizareInfoDAO.isInformatiiDespreReguli())
                .informatiiDespreServiciileMedicale(chestionarFurnizareInfoDAO.isInformatiiDespreServiciileMedicale())
                .interventiileSiStrategie(chestionarFurnizareInfoDAO.isInterventiileSiStrategie())
                .mediaInformatiilor(chestionarFurnizareInfoDAO.getMediaInformatiilor())
                .mentiuni(chestionarFurnizareInfoDAO.getMentiuni())
                .naturaSiScopulActuluiMedical(chestionarFurnizareInfoDAO.isNaturaSiScopulActuluiMedical())
                .numeSiPrenume(chestionarFurnizareInfoDAO.getNumeSiPrenume())
                .potRefuzaProcesulEducational(chestionarFurnizareInfoDAO.isPotRefuzaProcesulEducational())
                .prognostic(chestionarFurnizareInfoDAO.isPrognostic())
                .rescurileNerespectaiiRecomandarilor(chestionarFurnizareInfoDAO.isRescurileNerespectaiiRecomandarilor())
                .riscurileNeefectuarii(chestionarFurnizareInfoDAO.isRiscurileNeefectuarii())
                .riscurilePotentiale(chestionarFurnizareInfoDAO.isRiscurilePotentiale())
                .situatiiNeprevazute(chestionarFurnizareInfoDAO.isSituatiiNeprevazute())
                .supozitiiDiagnostic(chestionarFurnizareInfoDAO.isSupozitiiDiagnostic())
                .build();
    }

    public ChestionarFurnizareInfoDAO convertToChestionarFurnizareInfoDAO(ChestionarFurnizareInfoModel chestionarFurnizareInfoModel){
        return ChestionarFurnizareInfoDAO.builder()
                .alternativeViabile(chestionarFurnizareInfoModel.isAlternativeViabile())
                .beneficiileSiConsecintele(chestionarFurnizareInfoModel.isBeneficiileSiConsecintele())
                .dreptulLaADouaOpinie(chestionarFurnizareInfoModel.isDreptulLaADouaOpinie())
                .id(chestionarFurnizareInfoModel.getId())
                .informatiiDespreIdendtitateaPersonalului(chestionarFurnizareInfoModel.isInformatiiDespreIdendtitateaPersonalului())
                .informatiiDespreReguli(chestionarFurnizareInfoModel.isInformatiiDespreReguli())
                .informatiiDespreServiciileMedicale(chestionarFurnizareInfoModel.isInformatiiDespreServiciileMedicale())
                .interventiileSiStrategie(chestionarFurnizareInfoModel.isInterventiileSiStrategie())
                .mediaInformatiilor(chestionarFurnizareInfoModel.getMediaInformatiilor())
                .mentiuni(chestionarFurnizareInfoModel.getMentiuni())
                .supozitiiDiagnostic(chestionarFurnizareInfoModel.isSupozitiiDiagnostic())
                .naturaSiScopulActuluiMedical(chestionarFurnizareInfoModel.isNaturaSiScopulActuluiMedical())
                .numeSiPrenume(chestionarFurnizareInfoModel.getNumeSiPrenume())
                .potRefuzaProcesulEducational(chestionarFurnizareInfoModel.isPotRefuzaProcesulEducational())
                .prognostic(chestionarFurnizareInfoModel.isPrognostic())
                .rescurileNerespectaiiRecomandarilor(chestionarFurnizareInfoModel.isRescurileNerespectaiiRecomandarilor())
                .riscurileNeefectuarii(chestionarFurnizareInfoModel.isRiscurileNeefectuarii())
                .riscurilePotentiale(chestionarFurnizareInfoModel.isRiscurilePotentiale())
                .situatiiNeprevazute(chestionarFurnizareInfoModel.isSituatiiNeprevazute())
                .build();
    }

    public ChestionarEvalGenDAO convertToChestionarEvalGenDAO(ChestionarEvalGenModal chestionarEvalGenModal){
        return ChestionarEvalGenDAO.builder()
                .id(chestionarEvalGenModal.getId())
                .createDateTime(chestionarEvalGenModal.getCreateDateTime())
                .afectiuneaTrata(chestionarEvalGenModal.getAfectiuneaTrata())
                .alergii(chestionarEvalGenModal.getAlergii())
                .afectiuneCronica(chestionarEvalGenModal.isAfectiuneCronica())
                .afectiuniColoana(chestionarEvalGenModal.isAfectiuniColoana())
                .alergiiStomatoligice(chestionarEvalGenModal.isAlergiiStomatoligice())
                .alteBoli(chestionarEvalGenModal.getAlteBoli())
                .alteBoliCronice(chestionarEvalGenModal.getAlteBoliCronice())
                .alteleAfectiuniSchelet(chestionarEvalGenModal.getAlteleAfectiuniSchelet())
                .alteleBoliDigestive(chestionarEvalGenModal.getAlteleBoliDigestive())
                .alteleBoliEndocrine(chestionarEvalGenModal.getAlteleBoliEndocrine())
                .alteleBoliHematologice(chestionarEvalGenModal.getAlteleBoliHematologice())
                .alteleBoliHepatice(chestionarEvalGenModal.getAlteleBoliHepatice())
                .alteleBoliInima(chestionarEvalGenModal.getAlteleBoliInima())
                .alteleBoliMetabolice(chestionarEvalGenModal.getAlteleBoliMetabolice())
                .alteleBoliNeurologice(chestionarEvalGenModal.getAlteleBoliNeurologice())
                .alteleBoliPlamani(chestionarEvalGenModal.getAlteleBoliPlamani())
                .alteleBoliPsihice(chestionarEvalGenModal.getAlteleBoliPsihice())
                .alteleBoliVasculare(chestionarEvalGenModal.getAlteleBoliVasculare())
                .alteleStomatologice(chestionarEvalGenModal.getAlteleStomatologice())
                .anemie(chestionarEvalGenModal.isAnemie())
                .anestezieGenerala(chestionarEvalGenModal.isAnestezieGenerala())
                .anestezieLocoRegionala(chestionarEvalGenModal.isAnestezieLocoRegionala())
                .anginaPectorala(chestionarEvalGenModal.isAnginaPectorala())
                .antibioticul(chestionarEvalGenModal.getAntibioticul())
                .arteriopatii(chestionarEvalGenModal.isArteriopatii())
                .astm(chestionarEvalGenModal.isAstm())
                .atiPrimitSange(chestionarEvalGenModal.isAtiPrimitSange())
                .auAparutAccidenteLaStomatologie(chestionarEvalGenModal.isAuAparutAccidenteLaStomatologie())
                .bauturiAlcoolice(chestionarEvalGenModal.isBauturiAlcoolice())
                .boliInfectioase(chestionarEvalGenModal.isBoliInfectioase())
                .boliProfesionale(chestionarEvalGenModal.getBoliProfesionale())
                .bronsitaCronica(chestionarEvalGenModal.isBronsitaCronica())
                .cantitate(chestionarEvalGenModal.getCantitate())
                .cantitateDroguri(chestionarEvalGenModal.getCantitateDroguri())
                .cateTigari(chestionarEvalGenModal.getCateTigari())
                .catiAni(chestionarEvalGenModal.getCatiAni())
                .ciroza(chestionarEvalGenModal.isCiroza())
                .consumatiDroguri(chestionarEvalGenModal.isConsumatiDroguri())
                .cuAnestezieLocala(chestionarEvalGenModal.isCuAnestezieLocala())
                .cuAnestezieLocalaSiSedareInhalatorie(chestionarEvalGenModal.isCuAnestezieLocalaSiSedareInhalatorie())
                .cuAnestezieLocalaSiSedareIntravenoasa(chestionarEvalGenModal.isCuAnestezieLocalaSiSedareIntravenoasa())
                .cuCeOcazie(chestionarEvalGenModal.getCuCeOcazie())
                .dataUltimeiMenstruatii(chestionarEvalGenModal.getDataUltimeiMenstruatii())
                .depresii(chestionarEvalGenModal.isDepresii())
                .diabetZaharat(chestionarEvalGenModal.isDiabetZaharat())
                .dozaAntibiotic(chestionarEvalGenModal.getDozaAntibiotic())
                .dozaTratament(chestionarEvalGenModal.getDozaTratament())
                .durere(chestionarEvalGenModal.isDurere())
                .embolii(chestionarEvalGenModal.isEmbolii())
                .endocardita(chestionarEvalGenModal.isEndocardita())
                .epilepsie(chestionarEvalGenModal.isEpilepsie())
                .faraAnestezie(chestionarEvalGenModal.isFaraAnestezie())
                .feocromocitom(chestionarEvalGenModal.isFeocromocitom())
                .fobii(chestionarEvalGenModal.isFobii())
                .fumati(chestionarEvalGenModal.isFumati())
                .gastrita(chestionarEvalGenModal.isGastrita())
                .greata(chestionarEvalGenModal.isGreata())
                .guta(chestionarEvalGenModal.isGuta())
                .hemofilie(chestionarEvalGenModal.isHemofilie())
                .hepatita(chestionarEvalGenModal.isHepatita())
                .hepatitaB(chestionarEvalGenModal.isHepatitaB())
                .hepatitaC(chestionarEvalGenModal.isHepatitaC())
                .hernieHiatala(chestionarEvalGenModal.isHernieHiatala())
                .hipertensiuneArteriala(chestionarEvalGenModal.isHipertensiuneArteriala())
                .hipotensiuneArteriala(chestionarEvalGenModal.isHipotensiuneArteriala())
                .boliRenale(chestionarEvalGenModal.isBoliRenale())
                .insuficientaRenala(chestionarEvalGenModal.isInsuficientaRenala())
                .hipertiroidism(chestionarEvalGenModal.isHipertiroidism())
                .HIV(chestionarEvalGenModal.isHIV())
                .id(chestionarEvalGenModal.getId())
                .infarctMiocardic(chestionarEvalGenModal.isInfarctMiocardic())
                .interventii(chestionarEvalGenModal.getInterventii())
                .intoleranta(chestionarEvalGenModal.getIntoleranta())
                .isAlergiiSauIntoleranta(chestionarEvalGenModal.isAlergiiSauIntoleranta())
                .isGravida(chestionarEvalGenModal.isGravida())
                .lesin(chestionarEvalGenModal.isLesin())
                .leucemie(chestionarEvalGenModal.isLeucemie())
                .limfom(chestionarEvalGenModal.isLimfom())
                .mentionari(chestionarEvalGenModal.getMentionari())
                .nrSaptamaniSarcina(chestionarEvalGenModal.getNrSaptamaniSarcina())
                .problemeDacaIntrerupetiConsumul(chestionarEvalGenModal.isProblemeDacaIntrerupetiConsumul())
                .produs(chestionarEvalGenModal.getProdus())
                .refluxEsofagian(chestionarEvalGenModal.isRefluxEsofagian())
                .sangeratiUsor(chestionarEvalGenModal.isSangeratiUsor())
                .sedareGenerala(chestionarEvalGenModal.isSedareGenerala())
                .sedareInhalatorie(chestionarEvalGenModal.isSedareInhalatorie())
                .sedareIntravenoasa(chestionarEvalGenModal.isSedareIntravenoasa())
                .silicoza(chestionarEvalGenModal.isSilicoza())
                .sufocare(chestionarEvalGenModal.isSufocare())
                .suntetiDependent(chestionarEvalGenModal.isSuntetiDependent())
                .TBC(chestionarEvalGenModal.isTBC())
                .tipBauturi(chestionarEvalGenModal.getTipBauturi())
                .tipDroguri(chestionarEvalGenModal.getTipDroguri())
                .tratamentAntibiotic(chestionarEvalGenModal.isTratamentAntibiotic())
                .tratamenteChirugicale(chestionarEvalGenModal.isTratamenteChirugicale())
                .tratamenteStomatologice(chestionarEvalGenModal.isTratamenteStomatologice())
                .tromboFlebite(chestionarEvalGenModal.isTromboFlebite())
                .ulcer(chestionarEvalGenModal.isUlcer())
                .urmatiTratament(chestionarEvalGenModal.isUrmatiTratament())
                .valvulopatii(chestionarEvalGenModal.isValvulopatii())
                .varice(chestionarEvalGenModal.isVarice())
                .sida(chestionarEvalGenModal.isSida())
                .hepatitaViralaCronica(chestionarEvalGenModal.isHepatitaViralaCronica())
                .build();
    }

    public ChestionarEvalGenModal convertToChestionarEvalGenEntity(ChestionarEvalGenDAO chestionarEvalGenDAO){
        return ChestionarEvalGenModal.builder()
                .id(chestionarEvalGenDAO.getId())
                .afectiuneaTrata(chestionarEvalGenDAO.getAfectiuneaTrata())
                .afectiuniColoana(chestionarEvalGenDAO.isAfectiuniColoana())
                .afectiuneCronica(chestionarEvalGenDAO.isAfectiuneCronica())
                .alergii(chestionarEvalGenDAO.getAlergii())
                .alergiiStomatoligice(chestionarEvalGenDAO.isAlergiiStomatoligice())
                .alteBoli(chestionarEvalGenDAO.getAlteBoli())
                .alteBoliCronice(chestionarEvalGenDAO.getAlteBoliCronice())
                .alteleAfectiuniSchelet(chestionarEvalGenDAO.getAlteleAfectiuniSchelet())
                .alteleBoliDigestive(chestionarEvalGenDAO.getAlteleBoliDigestive())
                .alteleBoliEndocrine(chestionarEvalGenDAO.getAlteleBoliEndocrine())
                .alteleBoliHematologice(chestionarEvalGenDAO.getAlteleBoliHematologice())
                .alteleBoliHepatice(chestionarEvalGenDAO.getAlteleBoliHepatice())
                .alteleBoliInima(chestionarEvalGenDAO.getAlteleBoliInima())
                .alteleBoliMetabolice(chestionarEvalGenDAO.getAlteleBoliMetabolice())
                .alteleBoliNeurologice(chestionarEvalGenDAO.getAlteleBoliNeurologice())
                .alteleBoliPlamani(chestionarEvalGenDAO.getAlteleBoliPlamani())
                .alteleBoliPsihice(chestionarEvalGenDAO.getAlteleBoliPsihice())
                .alteleBoliVasculare(chestionarEvalGenDAO.getAlteleBoliVasculare())
                .alteleStomatologice(chestionarEvalGenDAO.getAlteleStomatologice())
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
                .hipotensiuneArteriala(chestionarEvalGenDAO.isHipotensiuneArteriala())
                .boliRenale(chestionarEvalGenDAO.isBoliRenale())
                .insuficientaRenala(chestionarEvalGenDAO.isInsuficientaRenala())
                .sida(chestionarEvalGenDAO.isSida())
                .hepatitaViralaCronica(chestionarEvalGenDAO.isHepatitaViralaCronica())

                .build();
    }

}
