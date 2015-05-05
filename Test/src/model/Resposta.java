/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Toshiba-1
 */
public class Resposta {
    private int codi;
    private String text;
    private boolean esCorrecte;
    private int codiPregunta;

    public Resposta(String text, boolean esCorrecte) {
        this.text=text;
        this.esCorrecte = esCorrecte;
    }
    
    public Resposta(int codi, String text, boolean esCorrecte, int codiPregunta) {
        this.codi = codi;
        this.text = text;
        this.esCorrecte = esCorrecte;
        this.codiPregunta = codiPregunta;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEsCorrecte() {
        return esCorrecte;
    }

    public void setEsCorrecte(boolean esCorrecte) {
        this.esCorrecte = esCorrecte;
    }

    public int getCodiPregunta() {
        return codiPregunta;
    }

    public void setCodiPregunta(int codiPregunta) {
        this.codiPregunta = codiPregunta;
    }
    
    
    
}
