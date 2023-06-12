package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.model.*;
import com.giancotsu.panchine.model.Record;
import com.giancotsu.panchine.service.*;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;


@Log
@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class TestController {

    public final GiocatoreService giocatoreService;
    public final PartitaService partitaService;
    public final StadioService stadioService;
    public final InCasaService inCasaService;
    public final FuoriCasaService fuoriCasaService;
    public final GiocatoreController giocatoreController;
    public final StadioController stadioController;
    public final PartitaController partitaController;
    public final CampionatoController campionatoController;

    public TestController(GiocatoreService giocatoreService, PartitaService partitaService, StadioService stadioService, InCasaService inCasaService, FuoriCasaService fuoriCasaService, GiocatoreController giocatoreController, StadioController stadioController, PartitaController partitaController, CampionatoController campionatoController) {
        this.giocatoreService = giocatoreService;
        this.partitaService = partitaService;
        this.stadioService = stadioService;
        this.inCasaService = inCasaService;
        this.fuoriCasaService = fuoriCasaService;
        this.giocatoreController = giocatoreController;
        this.stadioController = stadioController;
        this.partitaController = partitaController;
        this.campionatoController = campionatoController;
    }

    @GetMapping
    public void generaDati() {

        //campionati

        Campionato campionato = Campionato.builder()
                .tipoCompetizione(TipoCompetizione.SERIE_A)
                .edizioneCampionato(1)
                .numPartite(30)
                .build();

        //stadio
        Stadio stadio = Stadio.builder()
                .nome("Colella Stadium")
                .posti(50)
                .annoCreazione(Year.of(1950))
                .build();

        //record
        Record record = Record.builder()
                .recordGoalFattiFila(0)
                .recordGoalSubitiFila(0)
                .recordGoalFattiFilaPartita(0)
                .recordGoalSubitiFilaPartita(0)
                .recordGoalFattiPartita(0)
                .recordGoalSubitiPartita(0)
                .recordGoalPunizione(1)
                .recordGoalRigore(1)
                .doubleGoal(1)
                .multiGoal(1)
                .ultraGoal(1)
                .fantasticGoal(1)
                .unbelievableGoal(1)
                .UnbelievablePlusGoal(1)
                .build();

        Record record2 = Record.builder()
                .recordGoalFattiFila(1)
                .recordGoalSubitiFila(2)
                .recordGoalFattiFilaPartita(2)
                .recordGoalSubitiFilaPartita(2)
                .recordGoalFattiPartita(2)
                .recordGoalSubitiPartita(2)
                .recordGoalPunizione(1)
                .recordGoalRigore(1)
                .doubleGoal(1)
                .multiGoal(1)
                .ultraGoal(1)
                .fantasticGoal(1)
                .unbelievableGoal(1)
                .UnbelievablePlusGoal(1)
                .build();

        //statistiche

        Statistiche statistiche = Statistiche.builder()
                .velocita(55)
                .finalizzazione(24)
                .potenzaTiro(56)
                .tiroDistanza(99)
                .tiroVolo(44)
                .rigori(55)
                .precisioneTiro(22)
                .dribbling(12)
                .intercettazione(45)
                .contrasto(75)
                .resistenza(83)
                .forzaFisica(33)
                .build();

        Statistiche statistiche2 = Statistiche.builder()
                .velocita(34)
                .finalizzazione(85)
                .potenzaTiro(24)
                .tiroDistanza(35)
                .tiroVolo(89)
                .rigori(56)
                .precisioneTiro(87)
                .dribbling(35)
                .intercettazione(17)
                .contrasto(58)
                .resistenza(67)
                .forzaFisica(58)
                .build();

        //Carriere

        Carriera carriera1 = Carriera.builder()
                .scudetti(0)
                .champions(0)
                .coppe(0)
                .partiteGiocate(1)
                .vittorie(1)
                .pareggi(0)
                .sconfitte(0)
                .goalFatti(7)
                .goalSubiti(6)
                .partiteGiocateA(1)
                .vittorieA(1)
                .pareggiA(0)
                .sconfitteA(0)
                .goalFattiA(7)
                .goalSubitiA(6)
                .puntiA(3)
                .puntiChamp(1)
                .partiteGiocateChamp(0)
                .vittorieChamp(0)
                .pareggiChamp(0)
                .sconfitteChamp(0)
                .goalFattiChamp(0)
                .goalSubitiChamp(0)
                .build();


        Carriera carriera2 = Carriera.builder()
                .scudetti(0)
                .champions(0)
                .coppe(0)
                .partiteGiocate(1)
                .vittorie(0)
                .pareggi(0)
                .sconfitte(1)
                .goalFatti(6)
                .goalSubiti(7)
                .partiteGiocateA(1)
                .vittorieA(0)
                .pareggiA(0)
                .sconfitteA(1)
                .goalFattiA(6)
                .goalSubitiA(7)
                .puntiA(0)
                .puntiChamp(0)
                .partiteGiocateChamp(0)
                .vittorieChamp(0)
                .pareggiChamp(0)
                .sconfitteChamp(0)
                .goalFattiChamp(0)
                .goalSubitiChamp(0)
                .build();


        //giocatori

        Giocatore giocatore = Giocatore.builder()
                .nome("Gianfranco")
                .cognome("Larocca")
                .eta(25)
                .immagineProfiloUrl("http://www.innovatoripa.it/sites/default/files/styles/user_full/public/default_images/765-default-avatar_4.png?itok=-1-90-7C")
                .carriera(carriera1)
                .record(record)
                .statistiche(statistiche)
                .build();



        Giocatore giocatore2 = Giocatore.builder()
                .nome("Antonio")
                .cognome("Colella")
                .eta(30)
                .carriera(carriera2)
                .record(record2)
                .statistiche(statistiche2)
                .build();

        //Partita

        Partita partita1 = Partita.builder()
                .dataPartita(LocalDate.of(2023, Month.MAY, 02))
                .calcioInizio(LocalTime.of(16,00))
                .durataPartita(10)
                .campionato(campionato)
                .stadio(stadio)
                .build();

        Partita partita2 = Partita.builder()
                .dataPartita(LocalDate.of(2023, Month.MAY, 05))
                .calcioInizio(LocalTime.of(16,00))
                .durataPartita(10)
                .campionato(campionato)
                .stadio(stadio)
                .build();

        Partita partita3 = Partita.builder()
                .dataPartita(LocalDate.of(2023, Month.MAY, 10))
                .calcioInizio(LocalTime.of(16,00))
                .durataPartita(10)
                .campionato(campionato)
                .stadio(stadio)
                .build();


        //Fuori casa

        FuoriCasa fuoriCasa1 = FuoriCasa.builder()
                .goalFatti(6)
                .goalSubiti(7)
                .tiriTotali(20)
                .tiriPorta(15)
                .pali(3)
                .punizioni(1)
                .rigori(0)
                .goalMinuto(new int[]{5, 8, 10})
                .fantasticGoal(1)
                .partita(partita1)
                .giocatore(giocatore2)
                .build();

        FuoriCasa fuoriCasa2 = FuoriCasa.builder()
                .goalFatti(2)
                .goalSubiti(1)
                .tiriTotali(210)
                .tiriPorta(115)
                .pali(13)
                .punizioni(11)
                .rigori(01)
                .partita(partita2)
                .giocatore(giocatore)
                .build();

        FuoriCasa fuoriCasa3 = FuoriCasa.builder()
                .goalFatti(1)
                .goalSubiti(5)
                .tiriTotali(220)
                .tiriPorta(125)
                .pali(23)
                .punizioni(21)
                .rigori(20)
                .partita(partita3)
                .giocatore(giocatore2)
                .build();


        //In casa

        InCasa inCasa1 = InCasa.builder()
                .goalFatti(7)
                .goalSubiti(6)
                .tiriTotali(31)
                .tiriPorta(21)
                .pali(2)
                .punizioni(0)
                .rigori(0)
                .goalMinuto(new int[]{2, 6})
                .doubleGoal(1)
                .multiGoal(3)
                .partita(partita1)
                .giocatore(giocatore)
                .build();

        InCasa inCasa2 = InCasa.builder()
                .goalFatti(1)
                .goalSubiti(2)
                .tiriTotali(311)
                .tiriPorta(211)
                .pali(12)
                .punizioni(10)
                .rigori(10)
                .partita(partita2)
                .giocatore(giocatore2)
                .build();

        InCasa inCasa3 = InCasa.builder()
                .goalFatti(5)
                .goalSubiti(1)
                .tiriTotali(321)
                .tiriPorta(221)
                .pali(22)
                .punizioni(20)
                .rigori(20)
                .partita(partita3)
                .giocatore(giocatore)
                .build();


        stadioController.createStadio(stadio);
        campionatoController.createCampionato(campionato);
        giocatoreController.saveGiocatore(giocatore);
        giocatoreController.saveGiocatore(giocatore2);

        //giocatoreService.createGiocatore(giocatore);
        //giocatoreService.createGiocatore(giocatore2);
        //stadioService.createStadio(stadio);

        //partita1
        partitaController.createPartita(partita1);
        //partitaService.createPartita(partita1);
        inCasaService.createInCasa(inCasa1);
        fuoriCasaService.createFuoriCasa(fuoriCasa1);

        //partita2
        partitaController.createPartita(partita2);
        //partitaService.createPartita(partita2);
        inCasaService.createInCasa(inCasa2);
        fuoriCasaService.createFuoriCasa(fuoriCasa2);

        //partita3
        partitaController.createPartita(partita3);
        //partitaService.createPartita(partita3);
        inCasaService.createInCasa(inCasa3);
        fuoriCasaService.createFuoriCasa(fuoriCasa3);


    }

    @GetMapping("/stadio/{id}")
    public Stadio getStadio(@PathVariable("id") Long id){
        return stadioService.findById(id).get();
    }

    @GetMapping("/{id}")
    public Partita getPartita(@PathVariable("id") Long id){
        return partitaService.findById(id).get();
    }

    @GetMapping("/casa/{id}")
    public InCasa getInCasa(@PathVariable("id") Long id){
        return inCasaService.findById(id).get();
    }

    @GetMapping("/fuoricasa/{id}")
    public FuoriCasa getFuoriCasa(@PathVariable("id") Long id){
        return fuoriCasaService.findById(id).get();
    }

}
