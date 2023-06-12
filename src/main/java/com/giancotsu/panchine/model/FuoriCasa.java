package com.giancotsu.panchine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuoriCasa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFuoriCasa;

    private Integer vittorie;

    private Integer pareggi;

    private Integer sconfitte;

    private int[] goalMinuto;

    @Column(nullable = false)
    private Integer goalFatti;

    @Column(nullable = false)
    private Integer goalSubiti;

    @Column(nullable = false)
    private Integer tiriTotali;

    @Column(nullable = false)
    private Integer tiriPorta;

    @Column(nullable = false)
    private Integer pali;

    @Column(nullable = false)
    private Integer punizioni;

    @Column(nullable = false)
    private Integer rigori;

    //2 goal di fila in partita
    private Integer doubleGoal;

    //3 goal di fila in partita

    private Integer multiGoal;

    //4 goal di fila in partita
    private Integer ultraGoal;

    //5 goal di fila in partita
    private Integer fantasticGoal;

    //6 goal di fila in partita
    private Integer unbelievableGoal;

    //7+ goal di fila in partita
    private Integer UnbelievablePlusGoal;

    private Integer punti;


    //RELAZIONI

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idPartita", nullable = false)
    private Partita partita;

    //@JsonManagedReference(value = "giocatore-fuoriCasa")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idGiocatore", nullable = false)
    private Giocatore giocatore;
}
