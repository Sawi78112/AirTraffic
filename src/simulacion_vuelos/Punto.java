package simulacion_vuelos;

import java.awt.*;
import javax.swing.JPanel;

public class Punto {
	
	private int x;
	private int y;
	private Graphics g;
	
	public Punto(int x, int y, Graphics g)
	{
            this.x = x;
            this.y = y;
            this.g = g;
	}
        
        public Punto(JPanel panel)
        {
            x = panel.getWidth();
            y = panel.getHeight();
            g = panel.getGraphics();
        }
	
	public void X(int value)
	{
            x = value;
	}
	
	public int X()
	{
            return x;
	}

	public void Y(int value)
	{
            y = value;
	}
	
	public int Y()
	{
            return y;
	}
        
        public Graphics G()
        {
            return g;
        }
	
	public double DibujaLinea(int x2, int y2)
	{
            g.drawLine(x, y, x2, y2);            
            return Point.distance(x, y, x2, y2);
        }
}