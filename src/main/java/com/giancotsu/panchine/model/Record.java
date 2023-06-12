package com.giancotsu.panchine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecord;

    //record

    //Record di goal fatti/subiti di fila in generale

    @Column(nullable = false)
    private Integer recordGoalFattiFila;

    @Column(nullable = false)
    private Integer recordGoalSubitiFila;

    //Record di goal fatti/subiti di fila in un unica partita

    @Column(nullable = false)
    private Integer recordGoalFattiFilaPartita;

    @Column(nullable = false)
    private Integer recordGoalSubitiFilaPartita;

    //Record di goal fatti/subiti in un unica partita (non fi fila)

    @Column(nullable = false)
    private Integer recordGoalFattiPartita;

    @Column(nullable = false)
    private Integer recordGoalSubitiPartita;

    //punizioni/rigori

    @Column(nullable = false)
    private Integer recordGoalPunizione;

    @Column(nullable = false)
    private Integer recordGoalRigore;


    //2 goal di fila in partita
    @Column(nullable = false)
    private Integer doubleGoal;

    //3 goal di fila in partita
    @Column(nullable = false)
    private Integer multiGoal;

    //4 goal di fila in partita
    @Column(nullable = false)
    private Integer ultraGoal;

    //5 goal di fila in partita
    @Column(nullable = false)
    private Integer fantasticGoal;

    //6 goal di fila in partita
    @Column(nullable = false)
    private Integer unbelievableGoal;

    //7+ goal di fila in partita
    @Column(nullable = false)
    private Integer UnbelievablePlusGoal;

    //Relazioni

    @JsonBackReference(value = "giocatore-record")
    @OneToOne(mappedBy = "record")
    private Giocatore giocatore;
}
