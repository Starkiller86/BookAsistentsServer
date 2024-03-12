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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adulto")
    private Adult idAdulto;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "numeropersonal")
    private String numeropersonal;

    @Column(name = "numeroemergia")
    private String numeroemergia;

}