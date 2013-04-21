/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author AlejandroMC
 */
public class Distancia {
    public static double Calcular(double x1, double y1, double x2, double y2)
    {
        double x = Math.abs(x1 - x2);        
        double y = Math.abs(y1 - y2);
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }
}
