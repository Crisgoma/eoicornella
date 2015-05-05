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
public interface ExamenDAO {
    
    public ArrayList<Examen> getAllExamens();
    public Examen getExamenById(int codiExamen);
    public int getIdExamen(Examen e);
    public boolean insertExamen(Examen e);
    public boolean deleteExamen(Examen e);
    public boolean updateExamen(Examen e);
    public Examen getExamenByIdioma(int idioma);
    
    
}
