/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import formularis.FormulariDadesAlumne;
import formularis.Inici;
import formularis.PanelPregunta;
import formularis.PreguntesInicials;
import formularis.SeleccionaExamen;
import formularis.Vista;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import model.Alumne;
import model.AlumneDAO;
import model.Examen;
import model.ExamenDAO;
import model.GestorDAO;
import model.Notas;
import model.NotasDAO;
import model.Pregunta;
import model.PreguntaDAO;
import model.Resposta;
import model.RespostaDAO;

/**
 *
 * @author informaticos
 */
public class Controller {
        private static ExamenDAO consultesExamen = GestorDAO.obtenirExamenDAO();
        private static PreguntaDAO consultesPregunta = GestorDAO.obtenirPreguntaDAO();
        private static RespostaDAO consultesResposta = GestorDAO.obtenirRespostaDAO();
        private static AlumneDAO consultesAlumne = GestorDAO.obtenirAlumneDAO();
        private static NotasDAO consultesNotes = GestorDAO.obtenirNotasDAO();
        private static Inici inici = new Inici();
        private static FormulariDadesAlumne fda = new FormulariDadesAlumne();
        private static PreguntesInicials pregInici = new PreguntesInicials();
        private static SeleccionaExamen selecExam = new SeleccionaExamen();
        private static Vista vista = new Vista();
        private static Alumne alumno;
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        inici.setLocationRelativeTo(null);
        inici.setVisible(true);
        
    }

    public static Alumne getAlumno() {
        return alumno;
    }

    public static void setAlumno(Alumne alumno) {
        Controller.alumno = alumno;
    }
    
    
    public static ArrayList<Examen> getLlistaExamens(){
        ArrayList<Examen> examens = new ArrayList<Examen>();
        examens = consultesExamen.getAllExamens();
        Iterator<Examen> it = examens.iterator();
        while(it.hasNext()){
            Examen aux = it.next();
            ArrayList<Pregunta> preguntes = consultesPregunta.getPreguntes(aux.getCodi());
            aux.setPreguntes(preguntes);  
        }
        return examens;
    }
    
    public static void accedirAFormAlumne(){
        inici.dispose();
        fda.setLocationRelativeTo(null);
        fda.setVisible(true);
    }
    
    public static void accedirPreguntesInicials(){
        pregInici.setLocationRelativeTo(null);
        pregInici.setVisible(true);
        fda.dispose();
    }
    
    public static void accedirASeleccioExamen(){
        selecExam.setLocationRelativeTo(null);
        selecExam.setVisible(true);
        pregInici.dispose();
    }
    public static void accedirAVista(){
        //selecExam.dispose();
        vista.setExamen(selecExam.getExamen());
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.setExtendedState(vista.getExtendedState() | JFrame.MAXIMIZED_BOTH);   
    }
    
    public static Resposta getAnswer(int codi){ //le entra el codigo de pregunta
        ArrayList<Pregunta> llistaPreguntes = consultesPregunta.getPreguntes(selecExam.getExamen().getCodi()); //coge lista de preguntas del examen seleccionado
        Iterator<Pregunta> i = llistaPreguntes.iterator(); //itera sobre la lista de preguntas de ese examen
        while(i.hasNext()){
            Pregunta aux = i.next();
            if(aux.getCodi()==codi){ //busca la del codigo que le entra
                ArrayList<Resposta> llistaRespostes = aux.getRespostes(); 
                Iterator<Resposta> it = llistaRespostes.iterator(); //itera sobre las respuestas de esa pregunta 
                while(it.hasNext()){
                    Resposta auxR = it.next();
                    if(auxR.isEsCorrecte()){ //busca la isEsCorrecte true 
                        //System.out.println(auxR.getText());
                        return auxR; //devuelve la respuesta correcta
                    }
                }
            }
        }
        return null;
    }
    /**
     * Retorna el numero de respostes correctes de l'examen
     * @return Numero de respostes correctes
     */
    public static int nRespostesCorrectes(){
        int nRes=0;
        Iterator<PanelPregunta> i = vista.getPanels().iterator();
        int numpanel=0;
        while(i.hasNext()){
            PanelPregunta aux = i.next();
            System.out.println("Panel num: " + numpanel);
            if(aux.esCorrecta()){
                System.out.println(aux.esCorrecta());
                nRes++;
            }
            numpanel++;
        }
        return nRes;
    }
    
    /**
     * Retorna el resultat final del examen
     * @return 
     */
    public static double resultatExamen(){
        NumberFormat formatter = new DecimalFormat("#0.00");     
        double encerts = nRespostesCorrectes();
        double nPre = vista.getPanels().size(); //Tamaño de la lista de paneles
        double resFinal = (encerts*10)/nPre;
        System.out.println("Nota final: " + formatter.format(resFinal));
        return resFinal;
    }
   
    public static boolean insertarAlumne(Alumne a){
        return consultesAlumne.addAlumne(a);
    }
    
    public static boolean afegirExamenAlumne(int idexam){
        return consultesAlumne.updateExamen(idexam, alumno);
    }
    
    public static Examen obtenirExamenIdioma(int idioma){
        return consultesExamen.getExamenByIdioma(idioma);
    }
    
    public static boolean updateNotaTest(Notas n){
        return consultesNotes.updateTest(alumno, n);
    }
    
    public static boolean insertarNotas(Notas n){
        return consultesNotes.addNotas(alumno, n);
    }
}
