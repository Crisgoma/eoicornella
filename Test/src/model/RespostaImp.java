/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Implementacio dels metodes del DAO de Respostes*/

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
public class RespostaImp implements RespostaDAO {

    @Override
    public ArrayList<Resposta> getRespostes(int codiPregunta) {
        ArrayList<Resposta> respostes = new ArrayList<Resposta>();

            try {
                Statement sentencia = GestorDAO.getConnexioDB().createStatement();
                
                String sql = "SELECT * FROM respostes WHERE idpregunta=" +codiPregunta;
                
                ResultSet resultat = sentencia.executeQuery(sql);
                while (resultat.next()){
                    respostes.add(new Resposta(resultat.getInt("idresposta"), resultat.getString("resposta"), resultat.getBoolean("correcta"), resultat.getInt("idpregunta")));
                }
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(RespostaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            return respostes;
    
    }

    @Override
    public Resposta getResposta(int codi) {
        Resposta resp = null;
        Statement sentencia = null;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();

            String sql = "SELECT * FROM respostes WHERE codi=" + codi;

            ResultSet resultat = sentencia.executeQuery(sql); 
            resultat.next();
            resp = new Resposta(resultat.getInt("idresposta"), resultat.getString("resposta"), resultat.getBoolean("correcta"), resultat.getInt("idpregunta"));
            sentencia.close();		

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp ;
    }

    @Override
    public boolean insertarResposta(Resposta r) {
        Statement sentencia;
        try {
           
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "INSERT INTO respostes (resposta, correcta, idpregunta) VALUES ('" + r.getText()+"', "+ r.isEsCorrecte() +", " + r.getCodiPregunta() +")"; 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files afegides: "+ numfiles);
            sentencia.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteResposta(Resposta r) {
        Statement sentencia;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "DELETE FROM respostes WHERE idresposta="+r.getCodi(); 
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
    public boolean updateResposta(Resposta r) {
        Statement sentencia;
        try {
            sentencia = GestorDAO.getConnexioDB().createStatement();
            String sql = "UPDATE genere SET resposta='"+r.getText()+ "', correcta="+ r.isEsCorrecte() +", idpregunta="+r.getCodiPregunta() + " WHERE idresposta="+r.getCodi(); 
            int numfiles = sentencia.executeUpdate(sql);
            System.out.println("Files modificades: "+ numfiles);
            sentencia.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    
    
    
}
