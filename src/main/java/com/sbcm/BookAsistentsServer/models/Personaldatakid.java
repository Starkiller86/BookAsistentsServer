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

    @OneToOne
    @JoinColumn(name = "id_kid", referencedColumnName = "id")
    private Kid idKid;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "numeropersonal")
    private String numeropersonal;

    @Column(name = "numeroemergencia")
    private String numeroemergencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kid getIdKid() {
        return idKid;
    }

    public void setIdKid(Kid idKid) {
        this.idKid = idKid;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNumeropersonal() {
        return numeropersonal;
    }

    public void setNumeropersonal(String numeropersonal) {
        this.numeropersonal = numeropersonal;
    }

    public String getNumeroemergencia() {
        return numeroemergencia;
    }

    public void setNumeroemergencia(String numeroemergencia) {
        this.numeroemergencia = numeroemergencia;
    }
}