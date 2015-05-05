/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.Pregunta;

/**
 *
 * @author Toshiba-1
 */
public class Examen {
    private int codi;
    private String nom;
    private int idioma;
    private String redaccioFacil;
    private String redaccioDificil;
    
    private ArrayList<Pregunta> preguntes=new ArrayList<Pregunta>();

    public Examen(int codi, String nom, int idioma, String redaccioFacil, String redaccioDificil) {
        this.codi = codi;
        this.nom = nom;
        this.idioma = idioma;
        this.redaccioFacil = redaccioFacil;
        this.redaccioDificil = redaccioDificil;
        this.preguntes = new ArrayList<Pregunta>();
    }

    public Examen() {
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Pregunta> getPreguntes() {
        return preguntes;
    }

    public void setPreguntes(ArrayList<Pregunta> preguntes) {
        this.preguntes = preguntes;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public String getRedaccioFacil() {
        return redaccioFacil;
    }

    public void setRedaccioFacil(String redaccioFacil) {
        this.redaccioFacil = redaccioFacil;
    }

    public String getRedaccioDificil() {
        return redaccioDificil;
    }

    public void setRedaccioDificil(String redaccioDificil) {
        this.redaccioDificil = redaccioDificil;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
    
}
