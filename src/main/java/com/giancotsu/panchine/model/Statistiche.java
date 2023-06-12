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
public class Statistiche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStatistiche;

    @Column(nullable = false)
    private Integer velocita;

    @Column(nullable = false)
    private Integer finalizzazione;

    @Column(nullable = false)
    private Integer potenzaTiro;

    @Column(nullable = false)
    private Integer tiroDistanza;

    @Column(nullable = false)
    private Integer tiroVolo;

    @Column(nullable = false)
    private Integer rigori;

    @Column(nullable = false)
    private Integer precisioneTiro;

    @Column(nullable = false)
    private Integer dribbling;

    @Column(nullable = false)
    private Integer intercettazione;

    @Column(nullable = false)
    private Integer contrasto;

    @Column(nullable = false)
    private Integer resistenza;

    @Column(nullable = false)
    private Integer forzaFisica;

    //Relazioni

    @JsonBackReference(value = "giocatore-statistiche")
    @OneToOne(mappedBy = "statistiche")
    private Giocatore giocatore;
}
