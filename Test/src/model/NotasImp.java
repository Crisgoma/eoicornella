/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informaticos
 */
public class NotasImp implements NotasDAO{

    private static AlumneDAO consultesAlumne = GestorDAO.obtenirAlumneDAO();
    
    @Override
    public boolean addNotas(Alumne a, Notas n) {
        Statement sentencia = null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "INSERT INTO notes (notaTest, notaOral, notaRedaccio, dni_alumne) VALUES(" + n.getNotaTest() + ","+ n.getNotaOral() +","+n.getNotaRedaccio() +",'" + a.getDni() + "')";
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files afegides: " + numfiles);
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
 
    }

    @Override
    public Notas getNotasById(String dni) {
        Statement sentencia = null;
        Notas n = null;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * from notes WHERE dni='" + dni +"'";
            ResultSet res = sentencia.executeQuery(sql);
            String nif="";
            double notaTest = 0, notaOral=0, notaRedaccio=0;
            int idnota = 0;
            
            while(res.next()){
                idnota = res.getInt("idNota");
                nif = res.getString("dni_alumne");
                notaTest= res.getFloat("notaTest");
                notaOral = res.getFloat("notaOral");
                notaRedaccio = res.getFloat("notaRedaccio");
            }
            Alumne a = consultesAlumne.getAlumneById(nif);
            n = new Notas(idnota, notaTest, notaOral, notaRedaccio, a);
        } catch (SQLException ex) {
            Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    @Override
    public ArrayList<Notas> getNotas() {
        Statement sentencia = null;
        ArrayList<Notas> notes = new ArrayList<Notas>();
        Notas n = null;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * from notes";
            ResultSet res = sentencia.executeQuery(sql);
            String dni="";
            double notaTest = 0, notaOral=0, notaRedaccio=0;
            int idnota = 0;
            while(res.next()){
                idnota= res.getInt("idNota");
                dni = res.getString("dni_alumne");
                notaTest = res.getFloat("notaTest");
                notaOral = res.getFloat("notaOral");
                notaRedaccio = res.getFloat("notaRedaccio");
                Alumne a = consultesAlumne.getAlumneById(dni);
                n = new Notas(idnota, notaTest, notaOral, notaRedaccio, a);
                notes.add(n);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return notes;
    }

    @Override
    public boolean updateNotas(Alumne a, Notas n) {
        Statement sentencia = null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "UPDATE notes SET notaTest=" + n.getNotaTest() + ", notaOral=" + n.getNotaOral() + ", notaRedaccio=" + n.getNotaRedaccio() + " WHERE dni_alumne='" + a.getDni() + "'"; 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files actualitzades : " + numfiles);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean deleteNotas(Alumne a, Notas n) {
        Statement sentencia= null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "DELETE FROM notes WHERE dni_alumne='" + a.getDni() + "'";
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files esborrades: " + numfiles);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    
    
    }

    @Override
    public boolean updateTest(Alumne a, Notas n) {
        Statement sentencia = null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "UPDATE notes SET notaTest=" + n.getNotaTest() + " WHERE dni_alumne='" + a.getDni() + "'"; 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files actualitzades : " + numfiles);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
