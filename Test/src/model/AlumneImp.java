/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informaticos
 */
public class AlumneImp implements AlumneDAO{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public boolean addAlumne(Alumne a) {
        Statement sentencia = null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "INSERT INTO alumne (dni, nom, cognoms, datanaix, telefon, numInscripcio, idexamen) VALUES('" + a.getDni() + "', '" + a.getNom() + "', '" + a.getCognoms() + "', '" + sdf.format(a.getDatanaix()) + "', '" + a.getTlf() + "', '" + a.getNumInscripcio() + "', NULL)";
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
    public Alumne getAlumneById(String codi) {
        Statement sentencia = null;
        Alumne a = null;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * from alumne WHERE dni='" + codi +"'";
            ResultSet res = sentencia.executeQuery(sql);
            String dni="", nom="", cognoms="", telf="", numInscripcio="";
            int idexamen = 0;
            Date naix = null;
            while(res.next()){
                dni = res.getString("dni");
                nom = res.getString("nom");
                cognoms = res.getString("cognoms");
                naix = res.getDate("datanaix");
                telf = res.getString("telefon");
                numInscripcio= res.getString("numInscripcio");
                idexamen = res.getInt("idexamen");
            }
            
            a = new Alumne(dni, nom, cognoms, naix, telf, numInscripcio);
            a.setIdExamen(idexamen);
        } catch (SQLException ex) {
            Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumneImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return a;
    
    
    }

    @Override
    public ArrayList<Alumne> getAlumnes() {
        Statement sentencia = null;
        ArrayList<Alumne> alumnes = new ArrayList<Alumne>();
        Alumne a = null;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * from alumne";
            ResultSet res = sentencia.executeQuery(sql);
            String dni="", nom="", cognom="", telf="", numInscripcio="";
            int idexamen=0;
            Date naix = null;
            while(res.next()){
                dni = res.getString("dni");
                nom = res.getString("nom");
                cognom = res.getString("cognoms");
                naix = res.getDate("datanaix");
                telf = res.getString("telefon");
                numInscripcio= res.getString("numInscripcio");
                idexamen=res.getInt("idexamen");
                a = new Alumne(dni, nom, cognom, naix , telf, numInscripcio);
                a.setIdExamen(idexamen);
                alumnes.add(a);
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
        
        return alumnes;
    
    
    }

    @Override
    public boolean updateAlumne(Alumne a) {
        Statement sentencia = null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "UPDATE alumne SET dni='" + a.getDni() +"', nom='" + a.getNom() + "', cognoms='" + a.getCognoms() + "', datanaix='" + a.getDatanaix() +"', telefon='" + a.getTlf() +"', numInscripcio='" + a.getNumInscripcio() + "', idexamen=" +a.getIdExamen() + " WHERE dni='" + a.getDni() + "'"; //falta la date
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
    public boolean deleteAlumne(Alumne a) {
        Statement sentencia= null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "DELETE FROM alumne WHERE dni='" + a.getDni() + "'";
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
    public boolean updateExamen(int idexam, Alumne a) {
        Statement sentencia = null;
        try{
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "UPDATE alumne SET idexamen=" + idexam + " WHERE dni='" + a.getDni() + "'"; //falta la date
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
