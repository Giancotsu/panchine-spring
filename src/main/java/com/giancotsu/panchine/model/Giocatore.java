package com.giancotsu.panchine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Giocatore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGiocatore;

    //BASE

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private Integer eta;

    @Column(length = 500)
    private String immagineProfiloUrl;

    //RELAZIONI

    //@JsonBackReference(value = "giocatore-fuoriCasa")
    @JsonIgnore
    @OneToMany(mappedBy = "giocatore")
    private Set<FuoriCasa> fuoriCasa;

    //@JsonBackReference(value = "giocatore-inCasa")
    @JsonIgnore
    @OneToMany(mappedBy = "giocatore")
    private Set<InCasa> inCasa;

    @JsonManagedReference(value = "giocatore-carriera")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarriera", nullable = false)
    private Carriera carriera;

    @JsonManagedReference(value = "giocatore-record")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRecord", nullable = false)
    private Record record;

    @JsonManagedReference(value = "giocatore-statistiche")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idStatistiche", nullable = false)
    private Statistiche statistiche;
}
