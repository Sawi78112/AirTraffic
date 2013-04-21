/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.Point;
/**
 *
 * @author AlejandroMC
 */
public class Avion {
    
    public float combustible;
    public float gasto_combustible;
    public float  velocidad_min;
    public float  velocidad_crucero;
    public int tipo;
    public float peso_max;   
    public float tiempo_llegada;
    public Vuelo vuelo;
    public int evento;
    public Stack<Object> auxiliares;
    public String direccion;        
    public int inclinacion;
    
    
    public Avion(int tipo)
    {
        this.tipo = tipo;
        switch(tipo)
        {
            case 0: //combi
                peso_max = 545000;
                velocidad_crucero = 560;
                gasto_combustible = (float) 8100;
                break;
            case 1: //full pax
                peso_max = 242000;
                velocidad_crucero = (float)541.2;
                gasto_combustible = (float) 8.1;
                break;
            case 2: //all cargo-------
                peso_max = 242000;
                velocidad_crucero = (float)541.2;
                gasto_combustible = (float) 8.1;
                break;
        }
    }
   
    public void Move()
    {   
                    
    }

    /*public float DistanciaTotal(ArrayList<Escala> escalas) {
        double total = 0;
        for(int i = 0; i < escalas.size() - 1; i ++)
        {            
            total += Distancia.Calcular( escalas.get(i).punto.x , escalas.get(i).punto.x , escalas.get(i + 1).punto.y, escalas.get(i + 1).punto.y);
        }
        return 0;
        
    }*/

    private String Direccionar(Aeropuerto origen, ArrayList<Escala> escalas) {
        
        /*double x = origen.punto.x - escalas.get(0).punto.x;
        double y = origen.punto.y - escalas.get(0).punto.y;
        if(x < 0 && y < 0)
            return "LL";
        else if(x > 0 && y < 0)
            return "LR";
        else if(x < 0 && y > 0)
            return "UL";
        else if(x > 0 && y > 0)
            return "UR";
        return new String();*/
        return new String();
    }

    /*private Punto CalcularAvance(Aeropuerto o, Aeropuerto d) {
        /*double cateto_x = Math.abs(o.punto.x - d.punto.x);
        double cateto_y = Math.abs(o.punto.y - d.punto.y);
        int recorrido = (int)(Math.sqrt(Math.pow(cateto_x, 2) + Math.pow(cateto_y, 2)));
        double radianes = (double)Math.atan(recorrido / cateto_y);
        double cat_x = 10 * Math.sin(radianes);
        double cat_y = 10 * Math.cos(radianes);  
        return new Punto(cat_x, cat_y);
    }*/
}
