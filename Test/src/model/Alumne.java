/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author informaticos
 */
public class Alumne {
    private String dni;
    private String nom;
    private String cognoms;
    private Date datanaix;
    private String tlf;
    private String numInscripcio;
    private int idExamen;

    public Alumne() {
    }

    public Alumne(String dni, String nom, String cognoms, Date datanaix, String tlf, String numInscripcio) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.datanaix = datanaix;
        this.tlf = tlf;
        this.numInscripcio = numInscripcio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public Date getDatanaix() {
        return datanaix;
    }

    public void setDatanaix(Date datanaix) {
        this.datanaix = datanaix;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getNumInscripcio() {
        return numInscripcio;
    }

    public void setNumInscripcio(String numInscripcio) {
        this.numInscripcio = numInscripcio;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }
    
    
    
    
    
}
