package simulacion_vuelos;

public class Nodo {
	TipoElem _info;
    Nodo _sig;

    public Nodo(TipoElem oElem)
    {
        _info = oElem;
    }
    
    public Nodo getSig() {
        return _sig;     
    }
    
    public void setSig( Nodo value ) {
    	_sig = value;
    }
    
    
    public TipoElem getInfo () {
        return _info; 
    }
    
    public void setInfo ( TipoElem value ) {
        _info = value; 
    }
}
