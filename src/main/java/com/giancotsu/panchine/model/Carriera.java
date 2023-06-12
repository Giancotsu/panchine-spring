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
public class Carriera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarriera;

    @Column(nullable = false)
    private Integer scudetti;

    @Column(nullable = false)
    private Integer champions;

    @Column(nullable = false)
    private Integer coppe;

    //Carriera tutto (amichevoli + competitive)

    @Column(nullable = false)
    private Integer partiteGiocate;

    @Column(nullable = false)
    private Integer vittorie;

    @Column(nullable = false)
    private Integer pareggi;

    @Column(nullable = false)
    private Integer sconfitte;

    @Column(nullable = false)
    private Integer goalFatti;

    @Column(nullable = false)
    private Integer goalSubiti;

    //Carriera (serie A)

    @Column(nullable = false)
    private Integer partiteGiocateA;

    @Column(nullable = false)
    private Integer vittorieA;

    @Column(nullable = false)
    private Integer pareggiA;

    @Column(nullable = false)
    private Integer sconfitteA;

    @Column(nullable = false)
    private Integer goalFattiA;

    @Column(nullable = false)
    private Integer goalSubitiA;

    @Column(nullable = false)
    private Integer puntiA;

    //Carriera (champ)

    @Column(nullable = false)
    private Integer partiteGiocateChamp;

    @Column(nullable = false)
    private Integer vittorieChamp;

    @Column(nullable = false)
    private Integer pareggiChamp;

    @Column(nullable = false)
    private Integer sconfitteChamp;

    @Column(nullable = false)
    private Integer goalFattiChamp;

    @Column(nullable = false)
    private Integer goalSubitiChamp;

    @Column(nullable = false)
    private Integer puntiChamp;

    //Relazioni

    @JsonBackReference(value = "giocatore-carriera")
    @OneToOne(mappedBy = "carriera")
    private Giocatore giocatore;
}
