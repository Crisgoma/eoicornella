/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author informaticos
 */
public interface AlumneDAO {
    
    public boolean addAlumne(Alumne a);
    public Alumne getAlumneById(String codi);
    public ArrayList<Alumne> getAlumnes();
    public boolean updateAlumne(Alumne a);
    public boolean deleteAlumne(Alumne a);
    public boolean updateExamen(int idexam, Alumne a);    
}
