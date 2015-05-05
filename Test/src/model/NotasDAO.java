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
public interface NotasDAO {
    public boolean addNotas(Alumne a, Notas n);
    public Notas getNotasById(String dni);
    public ArrayList<Notas> getNotas();
    public boolean updateNotas(Alumne a, Notas n);
    public boolean deleteNotas(Alumne a, Notas n);
    public boolean updateTest(Alumne a, Notas n);
}
