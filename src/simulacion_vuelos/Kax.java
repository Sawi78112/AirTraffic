package simulacion_vuelos;

public class Lista {
	Nodo _cab;
    int _noNodos;

    public Lista()
    {
        _cab = null;
        _noNodos = 0;
    }

    public void InsBegin(TipoElem oElem)
    {
        Nodo p = new Nodo(oElem);
        p.setSig(_cab);
        _cab = p;
        _noNodos++;
    }
    public void InsEnd(TipoElem oElem)
    {
        Nodo p = new Nodo(oElem);
        p.setSig(null);
        if (this.Empty())
            _cab = p;
        else
        {
            Nodo q = _cab;
            while (q.getSig() != null)
                q = q.getSig();
            q.setSig(p);
        }
        _noNodos++;
    }
    
    public boolean Empty()
    {
        return _cab == null ? true : false; 
    }
    
    public int getNoNodos()
    {
    	return _noNodos; 
    }
    
    public void setNoNodos( int value )
    {
        _noNodos = value; 
    }
    
    public void setCab( Nodo value )
    {
        _cab = value; 
    } 
    
    public Nodo getCab()
    {
        return _cab;
    } 
    
    public void Invertir()
    {
        Lista aux = new Lista();
        Nodo p = _cab;
        while (p != null)
        {
            aux.InsBegin(p.getInfo());
            p = p.getSig();
        }
        _cab = null;
        _noNodos = 0;
        p = aux._cab;
        while (p != null)
        {
            this.InsEnd(p.getInfo());
            p = p.getSig();
        }
    }
    public void EliUlt()
    {
        Nodo p = _cab, q = null;
        while (p.getSig() != null)
        {
            q = p;
            p = p.getSig();
        }
        if (q == null)
            _cab = null;
        else
            q.setSig(p.getSig());
        _noNodos--;
    }
    public void Inter(Lista lista)
    {
        Nodo aux = lista._cab;
        lista._cab = _cab;
        _cab = aux;
        int auxNoNodos = lista._noNodos;
        lista._noNodos = _noNodos;
        _noNodos = auxNoNodos;
    }
    public boolean EliPrimOcurr(TipoElem oViajero)
    {
        Nodo p = _cab, q = null;
        boolean enc = false;
        while (p != null && !enc)
            if (p.getInfo() == oViajero)
                enc = true;
            else
            {
                q = p;
                p = p.getSig();
            }
        if (!enc)
            return false;
        if (q == null)
            _cab = p.getSig();
        else
            q.setSig(p.getSig());
        _noNodos--;
        return true;
    }
    public Nodo Busq(TipoElem oElem)
    {
        Nodo p = _cab;
        while (p != null)
            if (p.getInfo() == oElem)
                return p;
            else
                p = p.getSig();
        return p;
    }
    public void InsAfter(Nodo p, TipoElem oElem)
    {
        if (p != null)
        {
            Nodo q = new Nodo(oElem);
            q.setSig(p.getSig());
            p.setSig(q);
            _noNodos++;
        }
    }
    public void InsBefore(Nodo p, TipoElem oElem)
    {
        if (p != null)
        {
            Nodo q = new Nodo(oElem), r = null, s = _cab;
            while (s != p)
            {
                r = s;
                s = s.getSig();
            }
            if (r == null)
                _cab = q;
            else
                r.setSig(q);
            q.setSig(p);
            _noNodos++;
        }
    }
    public void DelAfter(Nodo p, TipoElem oElem)
    {
        if (p != null && p.getSig() != null)
        {
            oElem.Copia(p.getSig().getInfo());
            p.setSig(p.getSig().getSig());
            _noNodos--;
        }
    }
    public void DelBefore(Nodo p, TipoElem oElem)
    {
        if (p != null && p != _cab)
        {
            Nodo r = null, q = _cab;
            while (q.getSig() != p)
            {
                r = q;
                q = q.getSig();
            }
            if (r == null)
                _cab = p;
            else
                r.setSig(p);
            oElem.Copia(q.getInfo());
            _noNodos--;
        }
    }
    public void InterPrimUlt()
    {
        Nodo p = _cab;
        while (p.getSig() != null)
            p = p.getSig();
        TipoElem oViajero = new TipoElem();
        oViajero = _cab.getInfo();
        _cab.setInfo(p.getInfo());
        p.setInfo(oViajero);
    }

    public void Inicia()
    {
        _cab = null;
        _noNodos = 0;
    }
    public Nodo EncPrimOcurr(TipoElem oViajero)
    {
        Nodo p = _cab;
        while (p != null)
            if (p.getInfo() == oViajero)
                return p;
            else
                p = p.getSig();
        return p;
    }
    public void ElimIesimo(int iesimo)
    {
        if (iesimo == 1)
        {
            _cab = _cab.getSig();
            _noNodos--;
        }
        else
        {
            Nodo p = _cab.getSig(), q = null;
            int cont = 0;
            while (cont++ != iesimo - 1)
            {
                q = p;
                p = p.getSig();
            }
            q.setSig(p.getSig());
            _noNodos--;
        }

    }

    public void SoloCab()
    {
        Nodo p = _cab, q = _cab;
        while (q.getSig() != null)
            q = q.getSig();
        p.setSig(q.getSig());
        _noNodos = 1;
    }
    public Nodo Comparame(Nodo p, Nodo Cab)
    {
        Nodo q = _cab;
        while (_cab.getSig() != null)
        {
            if (q.getInfo() != p.getInfo())
            {
                q = q.getSig();
            }
            else
                return q;
        }
        return q;
    }
}

