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
public interface PreguntaDAO {
    
    public ArrayList<Pregunta> getPreguntes(int codiExamen);
    public int getIdPregunta();
    public boolean insertPregunta(Pregunta p, int codi);
    public boolean deletePregunta(Pregunta p);
    public boolean updatePregunta(Pregunta p);
    public int getCodiExamen(String nom);
    
    
}
