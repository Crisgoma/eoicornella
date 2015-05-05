/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Toshiba-1
 */
public class Pregunta {
    private int codi;
    private String text;
    private ArrayList<Resposta> respostes = new ArrayList<>();
    private int codiExamen;
    private int nivell;

    public Pregunta() {
    }

    public Pregunta(int codi, String text, int codiExamen, int nivell) {
        this.codi = codi;
        this.text = text;
        this.respostes = new ArrayList<>();
        this.codiExamen = codiExamen;
        this.nivell = nivell;
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

    public ArrayList<Resposta> getRespostes() {
        return respostes;
    }

    public void setRespostes(ArrayList<Resposta> respostes) {
        this.respostes = respostes;
    }

    public int getCodiExamen() {
        return codiExamen;
    }

    public void setCodiExamen(int codiExamen) {
        this.codiExamen = codiExamen;
    }
    
    public void addResposta(Resposta resp){
        this.respostes.add(resp);
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
    
    
    
}
