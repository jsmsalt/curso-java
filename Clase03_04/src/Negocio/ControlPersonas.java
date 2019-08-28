package Negocio;
import Modelo.Persona;
import java.util.ArrayList;

public class ControlPersonas {
    private ArrayList<Persona> _personas = new ArrayList<Persona>();

    public void agregarPersona(Persona _persona) {
        if (_persona.getId() == 0) {
            _persona.setId(_personas.size() + 1);
        }

        this._personas.add(_persona);
    }

    public Persona personaPorID(int id) {
        for (Persona persona: _personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }

        return null;
    }

    public ArrayList<Persona> getPersonas() {
        return _personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        _personas = personas;
    }
}