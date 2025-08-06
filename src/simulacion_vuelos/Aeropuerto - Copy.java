/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_vuelos;
import java.awt.*;
/**
 *
 * @author AlejandroMC
 */
public class Aeropuerto {
    
    String nombre;
    Coordenada posicion;
    int pistas;
    int Aviones_en_pista;
    
    public String getNombre()
    {
        return nombre;
    }
    public Coordenada getPosicion()
    {
        return posicion;
    }
    public int getPistas()
    {
        return pistas;
    }
    public void setAviones(int aviones)
    {
        Aviones_en_pista = aviones;
    }
    public int getAviones()
    {
        return Aviones_en_pista;
    }
}
