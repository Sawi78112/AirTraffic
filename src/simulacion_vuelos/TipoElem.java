package simulacion_vuelos;

public class TipoElem {
	String _nombre;
    String _nacion;
    int _edad;
    char _sexo;

    public TipoElem()
    {
    }

    public void Copia(TipoElem oElem)
    {
        _nombre = oElem._nombre;
        _nacion = oElem._nacion;
        _edad = oElem._edad;
        _sexo = oElem._sexo;
    }
/*
    public TipoElem(string nom, string nacion, int edad, char sexo)
    {
        _nombre = nom;
        _nacion = nacion;
        _edad = edad;
        _sexo = sexo;
    }
    static public bool operator ==(TipoElem oElem1, TipoElem oElem2)
    {
        return oElem1._nombre == oElem2._nombre && oElem1._nacion == oElem2._nacion &&
            oElem1._edad == oElem2._edad && oElem1._sexo == oElem2._sexo ? true : false;
    }
    static public bool operator !=(TipoElem oElem1, TipoElem oElem2)
    {
        return oElem1._nombre != oElem2._nombre || oElem1._nacion != oElem2._nacion ||
            oElem1._edad != oElem2._edad || oElem1._sexo != oElem2._sexo ? true : false;
    }
    public TipoElem(DataGridView dGV)
    {
        _nombre=dGV[0,0].Value.ToString();
        _nacion = dGV[1, 0].Value.ToString();
        _edad = Convert.ToInt32(dGV[2, 0].Value);
        _sexo = Convert.ToChar(dGV[3, 0].Value);
    }
    public void Visua(DataGridView dGV, int col)
    {
        dGV[col, 0].Value = _nombre;
        dGV[col, 1].Value = _nacion;
        dGV[col, 2].Value = _edad.ToString();
        dGV[col, 3].Value = _sexo.ToString();
    }
    public Char Sexo
    {
        get { return _sexo; }
        set { _sexo = value; }
    }*/
}

