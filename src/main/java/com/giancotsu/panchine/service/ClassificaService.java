package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Classifica;
import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.Giocatore;
import com.giancotsu.panchine.model.InCasa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ClassificaService {

    private final CampionatoService campionatoService;
    private final GiocatoreService giocatoreService;

    public ClassificaService(CampionatoService campionatoService, GiocatoreService giocatoreService) {
        this.campionatoService = campionatoService;
        this.giocatoreService = giocatoreService;
    }

    public List<Classifica> calcoloPuntiClassifica(Long idCampionato){

        List<Long> idGiocatori = campionatoService.partecipantiCampionato(idCampionato);
        List<Classifica> classificaCompleta = new ArrayList<>();


        for(Long idGiocatore : idGiocatori){
            List<InCasa> risCasa = campionatoService.risultatiInCasa(idGiocatore, idCampionato);
            List<FuoriCasa> risTrasferta = campionatoService.risultatiFuoriCasa(idGiocatore, idCampionato);
            Classifica classifica = new Classifica();

            Giocatore giocatore = giocatoreService.findById(idGiocatore).get();
            classifica.setNomeGiocatore(giocatore.getNome());
            classifica.setCognomeGiocatore(giocatore.getCognome());

            for(InCasa partitaCasa : risCasa){

                if(partitaCasa.getGoalFatti() > partitaCasa.getGoalSubiti()){
                    classifica.setVittorie(classifica.getVittorie()+1);
                    classifica.setPunti(classifica.getPunti()+3);
                }

                if(partitaCasa.getGoalFatti() == partitaCasa.getGoalSubiti()){
                    classifica.setPareggi(classifica.getPareggi()+1);
                    classifica.setPunti(classifica.getPunti()+1);
                }

                if(partitaCasa.getGoalFatti() < partitaCasa.getGoalSubiti()){
                    classifica.setSconfitte(classifica.getSconfitte()+1);
                }

                classifica.setGoalFatti(classifica.getGoalFatti() + partitaCasa.getGoalFatti());
                classifica.setGoalSubiti(classifica.getGoalSubiti() + partitaCasa.getGoalSubiti());
                classifica.setTiriTotali(classifica.getTiriTotali() + partitaCasa.getTiriTotali());
            }

            for(FuoriCasa partitaTrasferta : risTrasferta){

                if(partitaTrasferta.getGoalFatti() > partitaTrasferta.getGoalSubiti()){
                    classifica.setVittorie(classifica.getVittorie()+1);
                    classifica.setPunti(classifica.getPunti()+3);
                }

                if(partitaTrasferta.getGoalFatti() == partitaTrasferta.getGoalSubiti()){
                    classifica.setPareggi(classifica.getPareggi()+1);
                    classifica.setPunti(classifica.getPunti()+1);
                }

                if(partitaTrasferta.getGoalFatti() < partitaTrasferta.getGoalSubiti()){
                    classifica.setSconfitte(classifica.getSconfitte()+1);
                }

                classifica.setGoalFatti(classifica.getGoalFatti() + partitaTrasferta.getGoalFatti());
                classifica.setGoalSubiti(classifica.getGoalSubiti() + partitaTrasferta.getGoalSubiti());
                classifica.setTiriTotali(classifica.getTiriTotali() + partitaTrasferta.getTiriTotali());
            }
            
            classificaCompleta.add(classifica);

        }

        Collections.sort(classificaCompleta, new Comparator<Classifica>() {
            @Override
            public int compare(Classifica c1, Classifica c2) {
                return c2.getPunti().compareTo(c1.getPunti());
            }
        });

        return classificaCompleta;
    }
}
