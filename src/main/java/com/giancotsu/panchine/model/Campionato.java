package com.giancotsu.panchine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Campionato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCampionato;

    @Column(nullable = false)
    private TipoCompetizione tipoCompetizione;

    @Column(nullable = false)
    private Integer edizioneCampionato;

    @Column(nullable = false)
    private Integer numPartite;

    //Relazioni

    @JsonIgnore
    @OneToMany(mappedBy = "campionato")
    private Set<Partita> partite;


}
