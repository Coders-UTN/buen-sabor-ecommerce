package Entities;

public class Domicilio extends Base{
    private String calle;
    private int numero;
    private int cp;
    private Localidad localidad;

    public Domicilio() {
    }

    public Domicilio(String calle, int numero, int cp, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
    }
}
