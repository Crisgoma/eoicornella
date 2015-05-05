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
public class PreguntaImp implements PreguntaDAO {

    private RespostaDAO consultesResposta = GestorDAO.obtenirRespostaDAO();
    
    @Override
    public ArrayList<Pregunta> getPreguntes(int codiExamen) {
        ArrayList<Pregunta> preguntes = new ArrayList<Pregunta>();
        ArrayList<Resposta> respostes = new ArrayList<Resposta>();
        Statement sentencia = null;
            try {
                sentencia = GestorDAO.getConnexioDB().createStatement();
                
                String sql = "SELECT * FROM preguntes WHERE idexamen=" +codiExamen;
                
                ResultSet resultat = sentencia.executeQuery(sql);
                while (resultat.next()){
                    int idpreg = resultat.getInt("idpregunta");
                    Pregunta p = new Pregunta(idpreg, resultat.getString("pregunta"), resultat.getInt("idexamen"), resultat.getInt("nivell"));
                    respostes = consultesResposta.getRespostes(idpreg);
                    p.getRespostes().addAll(respostes);
                    preguntes.add(p);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PreguntaImp.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PreguntaImp.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            return preguntes;
    }

    @Override
    public boolean insertPregunta(Pregunta p, int codiExam) {
        Statement sentencia;
        try {
                sentencia = GestorDAO.getConnexioDB().createStatement();
                System.out.println("Codigo examen: " + codiExam);
                String sql2 = "INSERT INTO preguntes (pregunta, idexamen) VALUES ('" + p.getText()+ "', "+codiExam+"," + p.getNivell()+")"; 
                int numfiles = sentencia.executeUpdate(sql2); 
                System.out.println("Files afegides: "+ numfiles);
                sentencia.close();
                return true;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePregunta(Pregunta p) {
        Statement sentencia;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "DELETE FROM preguntes WHERE codi="+p.getCodi(); 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files esborrades: "+ numfiles);
            sentencia.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updatePregunta(Pregunta p) {
        Statement sentencia;
            try {
                sentencia = GestorDAO.getConnexioDB().createStatement();
                String sql = "UPDATE preguntes SET pregunta='" + p.getText() + "', idexamen=" + p.getCodiExamen() + ", nivell=" + p.getNivell() +" WHERE idpregunta="+ p.getCodi();
                int numfiles = sentencia.executeUpdate(sql);
                System.out.println("Files modificades: "+ numfiles);
                sentencia.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public int getCodiExamen(String nom) {
        Statement sentencia = null;
        int codiexamen=0;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();

            String sql = "SELECT idexamen FROM examen WHERE nom='" + nom + "'";

            ResultSet resultat = sentencia.executeQuery(sql); 
            resultat.next();
            codiexamen = resultat.getInt(1);
            sentencia.close();		

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codiexamen ;
    }

    @Override
    public int getIdPregunta() {
        int idpregunta = 0;
        try {
            Statement sentencia = GestorDAO.getConnexioDB().createStatement();

            String sql = "SELECT LAST_INSERT_ID()";

            ResultSet resultat = sentencia.executeQuery(sql);
            while (resultat.next()){
                idpregunta = resultat.getInt(1);
            }
            System.out.println("esta es la id insertada " + idpregunta);
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idpregunta;
    }
    
}
