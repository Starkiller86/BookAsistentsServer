package com.sbcm.BookAsistentsServer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personaldataadult")
public class Personaldataadult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_adulto", referencedColumnName ="id")
    private Adult idAdulto;

    @Column(name = "numeropersonal")
    private String numeropersonal;

    @Column(name = "numeroemergencia")
    private String numeroemergencia;

    @Column(name = "domicilio")
    private String domicilio;


}