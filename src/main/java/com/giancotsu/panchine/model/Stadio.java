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
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stadio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStadio;

    @Column(nullable = false)
    private String nome;

    private Integer posti;

    //@JsonFormat(pattern="yyyy", shape=JsonFormat.Shape.STRING)
    private Year annoCreazione;

    @JsonIgnore
    @OneToMany(mappedBy = "stadio")
    private List<Partita> partite;
}
