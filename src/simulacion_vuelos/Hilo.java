package simulacion_vuelos;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Hilo extends Thread{
	ArrayList<Avion> aviones;
        ArrayList<Punto> puntos;
        Avion avion;
        Punto punto;
        int distancia, mov = 1;
        JPanel jPanel1;
	private final Object lock = new Object();
        public boolean sigue = true;
        
	public Hilo(int recorrido, Avion avion)
	{
            super(Integer.toString(avion.tipo));                
            this.avion = avion;
            distancia = recorrido;
            punto = avion.getPunto();
	}
	public void run()
	{
            while(true)
            {
                while(sigue == true)
                {
                    jPanel1.update(jPanel1.getGraphics());
                avion.Traslacion(mov, punto);
                try
                {
                    Thread.sleep(200);
                }
                catch(Exception ex)
                {
                
                }
                //jPanel1.update(jPanel1.getGraphics());
                mov += 1;
                
                
                }
            }
	}
