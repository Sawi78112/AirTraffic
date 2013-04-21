/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.awt.*;

/**
 *
 * @author AlejandroMC
 */
public class Escala {
    Coordenada coordenada;
    public Escala(int g, int m, int s)
    {
        coordenada = new Coordenada(g, m, s);
    }
    public Coordenada getCoordenada()
    {
        return coordenada;
    }
}
