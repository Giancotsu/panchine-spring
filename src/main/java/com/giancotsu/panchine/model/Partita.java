package com.giancotsu.panchine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPartita;

    @Column(nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy", shape=JsonFormat.Shape.STRING)
    private LocalDate dataPartita;

    @Column(nullable = false)
    @JsonFormat(pattern="HH:mm", shape=JsonFormat.Shape.STRING)
    private LocalTime calcioInizio;

    @Column(nullable = false)
    private Integer durataPartita;


    //RELAZIONI

    @JsonIgnore
    @OneToMany(mappedBy = "partita")
    private Set<FuoriCasa> fuoriCasa;

    @JsonIgnore
    @OneToMany(mappedBy = "partita")
    private Set<InCasa> inCasa;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCampionato", nullable = false)
    private Campionato campionato;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idStadio", nullable = false)
    private Stadio stadio;

}
