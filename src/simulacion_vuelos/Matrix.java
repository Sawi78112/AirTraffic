/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_vuelos;

/**
 *
 * @author Administrador
 */
public class Matrix {
    
    private int ren = 0;
    private int col = 0;
    
    public Matrix(Matrix m)
    {
        ren = m.numren();
        col = m.numcol();
    }
    
    public int numren()
    {
        return ren;
    }
    
    public int numcol()
    {
        return col;
    }
    
    
}
