package Modelo;

import java.time.LocalDate;

public class Proveedor extends Persona {
    private String cuit;
    private String razonSocial;

    public Proveedor(int id, String descripcion, Contacto contacto, String cuit, String razonSocial) {
        super(id, descripcion, contacto);
        this.cuit = cuit;
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "cuit='" + cuit + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                '}';
    }
}

