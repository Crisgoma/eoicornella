/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author informaticos
 */
public class Notas {
    private int idNota;
    private double notaTest;
    private double notaOral;
    private double notaRedaccio;
    private Alumne alumne;

    public Notas(int idNota, double notaTest, double notaOral, double notaRedaccio, Alumne alumne) {
        this.idNota = idNota;
        this.notaTest = notaTest;
        this.notaOral = notaOral;
        this.notaRedaccio = notaRedaccio;
        this.alumne = alumne;
    }

    public Notas() {
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public double getNotaTest() {
        return notaTest;
    }

    public void setNotaTest(double notaTest) {
        this.notaTest = notaTest;
    }

    public double getNotaOral() {
        return notaOral;
    }

    public void setNotaOral(double notaOral) {
        this.notaOral = notaOral;
    }

    public double getNotaRedaccio() {
        return notaRedaccio;
    }

    public void setNotaRedaccio(double notaRedaccio) {
        this.notaRedaccio = notaRedaccio;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }
    
    
}
