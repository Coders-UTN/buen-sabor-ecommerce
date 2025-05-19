package Entities;

public class Localidad extends Base{
    private String nombre;
    private Provincia provincia;

    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
}
