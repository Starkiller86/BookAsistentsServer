package com.sbcm.BookAsistentsServer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**En esta parte lo que se hará será definir los datos que se tendrán en los registros y de
 * igual manera en esta parte se van a mapear la tabla de los registros ("kidsregister") de la base de datos,
 * esta se define como una entidad y cada una de las variables tiene que tener persistencia en la base de datos
 * **/
@Entity
@Table(name = "kidsregister")
@Getter
@Setter
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "edad")
    private int edad;
    @Column(name = "genero")
    private String genero;
    @Column(name = "escolaridad")
    private String escolaridad;
    @Column(name = "discapacidad")
    private String discapacidad;
    @Column(name = "ocupacion")
    private String ocupacion;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

}
