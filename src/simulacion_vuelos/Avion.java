package simulacion_vuelos;

import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.Graphics2D;
import java.awt.*;

public class Avion extends JPanel{
	//float 	altitud, velocidad, tiempoViaje, distanciaRecorrida, distanciaFaltante, latitud, longitud, grados; //datos de navegacion
	//float 	factorConsumoComb, fuelCapacity, fuelState;  //datos de combustible
	//boolean oktrip = true;
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
    public Punto punto;
        
        int[][] figura = new int[5][2];
        //Punto[] figura = new Punto[5];
    
        public void setDimension()
        {
            figura[0][0] = 50;/*new Punto(5, -5, this.getGraphics());*/	figura[0][1] = -50;
            figura[1][0] = 50;/*new Punto(5, 20, this.getGraphics());*/	figura[1][1] = 200;
            figura[2][0] = 10;/*new Punto(1, 1, this.getGraphics());*/	figura[2][1] = 10;
            figura[3][0] = 100;/*new Punto(10, 1, this.getGraphics());*/ figura[3][1] = 10;
            figura[4][0] = 50;/*new Punto(5, 20, this.getGraphics());*/	figura[4][1] = 200;
        }
        
        public void DibujaFlecha(int x, int y)
        {
            int xup2, yup2, xup1, yup1, xmid, ymid, xdown, ydown;
            Graphics g = this.getGraphics();
            Graphics2D g2d = (Graphics2D) g;
            
            xup2 = x + 10;
            yup2 = y - 10;
            xup1 = x;
            yup1 = -10;
            xmid = x + 10;
            ymid = y;
            xdown = x - 10;
            ydown = y - 10;

            g2d.drawString("Java 2D", 50, 50);
            g2d.drawLine(x, y, xup2, yup2);
            g2d.drawLine(xup2, yup2, xup1, yup1);
            g2d.drawLine(xup2, yup2, xmid, ymid);
            g2d.drawLine(x, y, xdown, ydown);
        }
        
        public Avion(int tipo, Punto avion)
        {
            setDimension();
            punto = avion;
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
         
        paint(figura, avion);
        }
        
        public void paint(int[][] fig, Punto avion)
        {
            int centroY = avion.X() / 2;
            int centroX = avion.Y() / 2;
            int x1, y1, x2, y2;
            
            x1 = fig[2][0];
            y1 = fig[2][1];
            
            //super.paint(g);
            avion.G().setColor(Color.BLUE);
            
            for(int i = 0; i < 5; i++)
            {
                x2 = fig[i][0];
                y2 = fig[i][1];
                
                avion.G().drawLine(x1 + centroX, y1 + centroY, x2 + centroX, y2 + centroY);
                
                x1 = x2;
                y1 = y2;
            }
        }
        
        // Metodo para la rotacion del avion
        public void Rotate(int grados, Punto avion)
        {
            double angulo = grados * Math.PI / 180;
            int[][] FiguraT = new int[5][2];
            double[][] matT = new double[2][2];
            
            matT[0][0] = Math.cos(angulo);          matT[0][1] = Math.sin(angulo);
            matT[1][0] = (-1) * Math.sin(angulo);   matT[1][1] = Math.cos(angulo);
            
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    FiguraT[i][j] = 0;
                    for(int k = 0; k < 2; k++)
                        FiguraT[i][j] = (int)(FiguraT[i][j] + Math.floor(figura[i][k] * matT[k][j]));
                }
            }
            paint(FiguraT, avion);
            
            for(int i = 0; i < 5; i++)
                for(int j = 0; j < 2; j++)
                    figura[i][j] = FiguraT[i][j];
        }
        
        public void Traslacion(int movX, Punto avion)
        {
            int[][] Fig = new int[5][2];
            for(int i = 0; i < 5; i++)
                for(int j = 0; j < 2; j++)
                {
                    Fig[i][j] = 0;
                    Fig[i][j] = Fig[i][j] + figura[i][j];
                    Fig[i][0] += movX;
                }
            
            paint(Fig, avion);
        }
        
        public void Mapeo(int realX, int realY, int panelX, int panelY)
        {
            double px = ((double)realX/(double)panelX);
            double py = ((double)realY / panelY);
            double xp, yp;
            
            for(int i = 0; i < 5; i++)
            {
                xp = (double)figura[i][0] / px;
                yp = (double)figura[i][1] / py;
                
                int y = (int)xp;
                if(xp > ((double)y + 0.5))//Integer.parseInt(Double.toString(x).split(".")[0][i]) > 5)
                    xp = Math.round(xp);
                else
                    xp = Math.floor(xp);
                
                y = (int)yp;
                if(yp > ((double)y + 0.5))
                    yp = Math.round(yp);
                else
                    yp = Math.floor(yp);
                
                figura[i][0] = (int)xp;  figura[i][1] = (int)yp;
            }
        }
        
        public void Inicializa()
        {
            setDimension();
        }
        
        public Punto getPunto()
        {
            return punto;
        }
        
        public float GetCombustible()
        {return combustible;}
        
        public float GetGastoCombustible()
        {return gasto_combustible;}
        
        public float GetVelocidadMin()
        {return velocidad_min;}
        
        public float GetVelocidadCrucero()
        {return velocidad_crucero;}
        
        public int GetTipo()
        {return tipo;}
        
        public float GetPesoMax()
        {return peso_max;}
        
        public float GetTiempoLlegada()
        {return tiempo_llegada;}
        
        public Vuelo GetVuelo()
        {return vuelo;}
        
        public int getEvento()
        {
        	return evento;
        }
        
       public String getDireccion(){
    	   return direccion;
       }
       public int getInclinacion(){
    	   return inclinacion;
       }
}