package com.crm.clinicCrm.chestionarEvalGenerala;

import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "evalGeneral")
public class ChestionarEvalGenModal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "evalGeneral_id")
    private UUID id;

    private boolean isGravida;
    private String nrSaptamaniSarcina;
    private String dataUltimeiMenstruatii;

    private boolean isAlergiiSauIntoleranta;
    private String alergii;
    private String intoleranta;

    private boolean urmatiTratament;
    private String produs;
    private String dozaTratament;

    private boolean tratamentAntibiotic;
    private String antibioticul;
    private String dozaAntibiotic;
    private String afectiuneaTrata;

    private boolean afectiuneCronica;
    private boolean boliRenale;
    private boolean insuficientaRenala;
    private String boliProfesionale;
    private boolean anginaPectorala;
    private boolean infarctMiocardic;
    private boolean valvulopatii;
    private boolean endocardita;
    private boolean durere;
    private boolean sufocare;
    private String alteleBoliInima;
    private boolean arteriopatii;
    private boolean varice;
    private boolean tromboFlebite;
    private boolean embolii;
    private boolean hipertensiuneArteriala;
    private boolean hipotensiuneArteriala;
    private String alteleBoliVasculare;
    private boolean sida;
    private boolean TBC;
    private boolean bronsitaCronica;
    private boolean astm;
    private boolean silicoza;
    private String alteleBoliPlamani;
    private boolean gastrita;
    private boolean ulcer;
    private boolean refluxEsofagian;
    private boolean hernieHiatala;
    private String alteleBoliDigestive;
    private boolean hepatita;
    private boolean ciroza;
    private String alteleBoliHepatice;
    private boolean diabetZaharat;
    private boolean guta;
    private String alteleBoliMetabolice;
    private boolean hipertiroidism;
    private boolean feocromocitom;
    private String alteleBoliEndocrine;
    private boolean epilepsie;
    private String alteleBoliNeurologice;
    private boolean afectiuniColoana;
    private String alteleAfectiuniSchelet;
    private boolean depresii;
    private boolean fobii;
    private String alteleBoliPsihice;
    private boolean sangeratiUsor;
    private boolean hemofilie;
    private boolean anemie;
    private boolean leucemie;
    private boolean limfom;
    private String alteleBoliHematologice;
    private String alteBoli;

    private boolean boliInfectioase;
    private boolean hepatitaB;
    private boolean hepatitaC;
    private boolean hepatitaViralaCronica;
    private boolean HIV;
    private String alteBoliCronice;

    private boolean atiPrimitSange;
    private String cuCeOcazie;

    private boolean tratamenteStomatologice;
    private boolean faraAnestezie;
    private boolean cuAnestezieLocala;
    private boolean cuAnestezieLocalaSiSedareInhalatorie;
    private boolean cuAnestezieLocalaSiSedareIntravenoasa;
    private boolean anestezieGenerala;

    private boolean auAparutAccidenteLaStomatologie;
    private boolean lesin;
    private boolean greata;
    private boolean alergiiStomatoligice;
    private String alteleStomatologice;

    private boolean tratamenteChirugicale;
    private String interventii;
    private boolean anestezieLocoRegionala;
    private boolean sedareInhalatorie;
    private boolean sedareIntravenoasa;
    private boolean sedareGenerala;

    private boolean fumati;
    private String cateTigari;
    private String catiAni;

    private boolean bauturiAlcoolice;
    private String tipBauturi;
    private String cantitate;
    private boolean problemeDacaIntrerupetiConsumul;

    private boolean consumatiDroguri;
    private String tipDroguri;
    private String cantitateDroguri;
    private boolean suntetiDependent;

    private String mentionari;


    private LocalDate createDateTime;

//    TODO adauga semnatura ca jpg
//    TODO posibil sa fie necesar sa modific altele in string

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientModel client;

}
