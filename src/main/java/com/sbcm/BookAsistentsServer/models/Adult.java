package com.sbcm.BookAsistentsServer.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/** En esta parte se van a definir los datos que se tendrán en cada uno de los registros
 * al igual en esta parte se van a mapear la tabla de los registros de adultos ("registroaduls") de la base de datos
 * se define como una entidad y cada una de las variables tiene que tener persistencia en la base de datos
 * **/
@Entity
@Table(name= "registroaduls")
@Getter
@Setter
public class Adult {

   @Id
   @Column(name = "id")
    private int id;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "apellido")
   private  String apellido;
   @Column(name = "Fecha de Nacimiento")
   @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
   @Column(name = "genero")
    private String genero;
   @Column(name = "escolaridad")
    private  String escolaridad;
   @Column(name = "discapacidad")
    private String discapacidad;
   @Column(name = "ocupacion")
    private String ocupacion;
   @Column(name  ="nvisitas")
   private int nVisitas;
   @Column(name ="tipodevisitante")
   private String tipoDeVisitante;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnVisitas() {
        return nVisitas;
    }

    public void setnVisitas(int nVisitas) {
        this.nVisitas = nVisitas;
    }

    public String getTipoDeVisitante() {
        return tipoDeVisitante;
    }

    public void setTipoDeVisitante(String tipoDeVisitante) {
        this.tipoDeVisitante = tipoDeVisitante;
    }


}
