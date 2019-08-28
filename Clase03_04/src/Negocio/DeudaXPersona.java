package Negocio;

import Modelo.Persona;
import Modelo.TipoMovimiento;

public class DeudaXPersona {
    private Persona _persona;
    private  float deuda = 0;

    public DeudaXPersona() {
    }

    public DeudaXPersona(Persona persona, float deuda) {
        _persona = persona;
        this.deuda = deuda;
    }

    public Persona getPersona() {
        return _persona;
    }

    public void setPersona(Persona persona) {
        _persona = persona;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return "DeudaXPersona{" +
                "_persona=" + _persona +
                ", deuda=" + deuda +
                '}';
    }
}
