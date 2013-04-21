/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author AlejandroMC
 */
public class Coordenada {
    int minutos;
    int grados;
    int segundos;
    
    public void setMIN(int min){
      minutos=min;
    }

    public int getMIN(){
       return minutos;
    }
    
    public void setGRA(int gra){
      grados=gra;
    }

    public int getGRA(){
       return minutos;
    }
    
    public void setSEG(int seg){
      segundos=seg;
    }

    public int getSEG(){
       return segundos;
    }
    public Coordenada(int gra, int min, int seg)
    {
        minutos = min;
        grados = gra;
        segundos = seg;
             
    }

}

