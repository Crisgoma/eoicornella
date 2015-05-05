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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toshiba-1
 */
public class ExamenImp implements ExamenDAO{
    private PreguntaDAO consultesPregunta = GestorDAO.obtenirPreguntaDAO();
    @Override
    public ArrayList<Examen> getAllExamens() {
       ArrayList<Examen> examens = new ArrayList<Examen>();
       ArrayList<Pregunta> preguntes = new ArrayList<Pregunta>();

        try {
            Statement sentencia = GestorDAO.getConnexioDB().createStatement();

            String sql = "SELECT * FROM examen";

            ResultSet resultat = sentencia.executeQuery(sql);
            while (resultat.next()){
                Examen exam = new Examen(resultat.getInt("idexamen"), resultat.getString("nom"), resultat.getInt("idioma"), resultat.getString("tema_redac_facil"), resultat.getString("tema_redac_dificil"));
                preguntes = consultesPregunta.getPreguntes(resultat.getInt("idexamen"));
                exam.getPreguntes().addAll(preguntes);
                examens.add(exam);
            }

            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamenImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return examens;

    
    }

    @Override
    public Examen getExamenById(int codiExamen) {
        Examen exam = null;
        Statement sentencia = null;
        ArrayList<Pregunta> preguntes = new ArrayList<Pregunta>();
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * FROM examen WHERE idexamen=" + codiExamen;

            ResultSet resultat = sentencia.executeQuery(sql); 
            resultat.next();
            exam = new Examen(resultat.getInt("idexamen"), resultat.getString("nom"), resultat.getInt("idioma"), resultat.getString("tema_redac_facil"), resultat.getString("tema_redac_dificil"));
            preguntes = consultesPregunta.getPreguntes(resultat.getInt("idexamen"));
            exam.getPreguntes().addAll(preguntes);
            sentencia.close();		

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    
    }

    @Override
    public boolean insertExamen(Examen e) {
        try {
            Statement sentencia;
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "INSERT INTO examen (nom, idioma, tema_redac_facil, tema_redac_dificil) VALUES ('" + e.getNom() +"', " + e.getIdioma() +", '"+ e.getRedaccioFacil()+ "', '" + e.getRedaccioDificil() + "')"; 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files afegides: "+ numfiles);
            sentencia.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExamenImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean deleteExamen(Examen e) {

        try {
            Statement sentencia;
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "DELETE FROM examen WHERE idExamen="+e.getCodi(); 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files esborrades: "+ numfiles);
            sentencia.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ExamenImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updateExamen(Examen e) {
        try {
            Statement sentencia;
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "UPDATE preguntes SET nom='" + e.getNom() +"', idioma=" + e.getIdioma() + ", '"+ e.getRedaccioFacil() +"', '" + e.getRedaccioDificil() + "' WHERE idexamen="+ e.getCodi();
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files modificades: "+ numfiles);
            sentencia.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ExamenImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public int getIdExamen(Examen e) {
        Statement sentencia = null;
        int id = 0;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * FROM examen WHERE nom='" + e.getNom()+"'";

            ResultSet resultat = sentencia.executeQuery(sql); 
            while(resultat.next()){
                id = resultat.getInt(1);
                System.out.println(id);
            }
            sentencia.close();		

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    
    }

    @Override
    public Examen getExamenByIdioma(int idioma) {
        Examen exam = null;
        Statement sentencia = null;
        ArrayList<Pregunta> preguntes = new ArrayList<Pregunta>();
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "SELECT * FROM examen WHERE idioma=" + idioma;

            ResultSet resultat = sentencia.executeQuery(sql); 
            resultat.next();
            exam = new Examen(resultat.getInt("idexamen"), resultat.getString("nom"), resultat.getInt("idioma"), resultat.getString("tema_redac_facil"), resultat.getString("tema_redac_dificil"));
            preguntes = consultesPregunta.getPreguntes(resultat.getInt("idexamen"));
            exam.getPreguntes().addAll(preguntes);
            sentencia.close();		

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }
}
