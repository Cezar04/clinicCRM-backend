package com.crm.clinicCrm.chestionarEvalGenerala;

import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    private int nrSaptamaniSarcina;
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
    private String boliProfesionale;
    private boolean anginaPectorala;
    private boolean infarctMiocardic;
    private boolean valvulopatii;
    private boolean endocardita;
    private boolean durere;
    private boolean sufocare;
    private boolean alteleBoliInima;
    private boolean arteriopatii;
    private boolean varice;
    private boolean tromboFlebite;
    private boolean embolii;
    private boolean hipertensiuneArteriala;
    private boolean alteleBoliVasculare;
    private boolean TBC;
    private boolean bronsitaCronica;
    private boolean astm;
    private boolean silicoza;
    private boolean alteleBoliPlamani;
    private boolean gastrita;
    private boolean ulcer;
    private boolean refluxEsofagian;
    private boolean hernieHiatala;
    private boolean alteleBoliDigestive;
    private boolean hepatita;
    private boolean ciroza;
    private boolean alteleBoliHepatice;
    private boolean diabetZaharat;
    private boolean guta;
    private boolean alteleBoliMetabolice;
    private boolean hipertiroidism;
    private boolean feocromocitom;
    private boolean alteleBoliEndocrine;
    private boolean epilepsie;
    private boolean alteleBoliNeurologice;
    private boolean afectiuniColoana;
    private boolean alteleAfectiuniSchelet;
    private boolean depresii;
    private boolean fobii;
    private boolean alteleBoliPsihice;
    private boolean sangeratiUsor;
    private boolean hemofilie;
    private boolean anemie;
    private boolean leucemie;
    private boolean limfom;
    private boolean alteleBoliHematologice;
    private String alteBoli;

    private boolean boliInfectioase;
    private boolean hepatitaB;
    private boolean hepatitaC;
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
    private boolean alteleStomatologice;

    private boolean tratamenteChirugicale;
    private String interventii;
    private boolean anestezieLocoRegionala;
    private boolean sedareInhalatorie;
    private boolean sedareIntravenoasa;
    private boolean sedareGenerala;

    private boolean fumati;
    private int cateTigari;
    private int catiAni;

    private boolean bauturiAlcoolice;
    private String tipBauturi;
    private String cantitate;
    private boolean problemeDacaIntrerupetiConsumul;

    private boolean consumatiDroguri;
    private String tipDroguri;
    private String cantitateDroguri;
    private boolean suntetiDependent;

    private String mentionari;

    @Temporal(TemporalType.TIME)
    private Date createDateTime;

//    TODO adauga semnatura ca jpg
//    TODO posibil sa fie necesar sa modific altele in string

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientModel client;

}
