/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.ExamenDAO;
import model.ExamenImp;
import model.PreguntaDAO;
import model.PreguntaImp;
import model.RespostaDAO;
import model.RespostaImp;

/**
 *
 * @author Toshiba-1
 */
public class GestorDAO {
    private final static String url = "jdbc:mysql://localhost/test";
    private final static String user = "root";
    private final static String pwd = "";

    private static Connection connexio = null;

    public static Connection getConnexioDB(){
            if(GestorDAO.connexio==null){
                    conectar();
            }
            return GestorDAO.connexio;
    }

    private static void conectar(){
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    GestorDAO.connexio = DriverManager.getConnection(url, user, pwd);
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            } catch (SQLException e) {
                    e.printStackTrace();
            }



    }

    public static void tancar(){

            try {
                    if(!GestorDAO.connexio.isClosed()){
                            GestorDAO.connexio.close();
                    }
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

    }

    public static RespostaDAO obtenirRespostaDAO(){
            return new RespostaImp();
    }
    
    public static PreguntaDAO obtenirPreguntaDAO(){
            return new PreguntaImp();
    }
    
    public static ExamenDAO obtenirExamenDAO(){
        return new ExamenImp();
    }
    
    public static AlumneDAO obtenirAlumneDAO(){
        return new AlumneImp();
    }
    
    public static NotasDAO obtenirNotasDAO(){
        return new NotasImp();
    }

}
