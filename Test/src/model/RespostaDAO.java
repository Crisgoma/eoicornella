/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/*Interface DAO per manteniment de Respostes*/
import java.util.ArrayList;

/**
 *
 * @author Toshiba-1
 */
public interface RespostaDAO {
    
    public ArrayList<Resposta> getRespostes(int codiPregunta);
    public Resposta getResposta(int codi);
    public boolean insertarResposta(Resposta r);
    public boolean deleteResposta(Resposta r);
    public boolean updateResposta(Resposta r);
}
