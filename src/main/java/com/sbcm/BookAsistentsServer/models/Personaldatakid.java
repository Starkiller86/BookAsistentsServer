package com.sbcm.BookAsistentsServer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personaldatakid")
public class Personaldatakid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kid")
    private Kid idKid;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "numeropersonal")
    private String numeropersonal;

    @Column(name = "numeroemergencia")
    private String numeroemergencia;

}