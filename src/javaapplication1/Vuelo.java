/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.ArrayList;
/**
 *
 * @author AlejandroMC
 */
public class Vuelo {
    Aeropuerto origen;
    Aeropuerto destino;
    ArrayList<Escala> escalas;
    public Aeropuerto getOrigen()
    {
        return origen;
    }
    public Aeropuerto getDestino()
    {
        return destino;
    }
    public ArrayList<Escala> getEscalas()
    {
        return escalas;
    }
    public Vuelo(Aeropuerto origen, Aeropuerto destino, int tipo)
    {
        switch(tipo)
        {
            case 1: 
                break;
            case 2: 
                break;
            case 3: 
                break;
            case 4: 
                break;
            case 5: 
                break;
            case 6: 
                break;
            case 7: 
                break;
            case 8: 
                break;
            case 9: 
                break;
            case 10: 
                break;
            case 11: 
                break;
            case 12: 
                break;
            case 13: 
                break;
            case 14: 
                break;
            case 15: 
                break;
            case 16: 
                break;
            case 17: 
                break;
            case 18: 
                break;
            case 19: 
                break;
            case 20: 
                break;
        }
        this.origen = origen;
        this.destino = destino;
        
    }
}
