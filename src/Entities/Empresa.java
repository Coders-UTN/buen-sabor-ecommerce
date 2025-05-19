package Entities;

public class Empresa extends Base{
    private String nombre;
    private String razonSocial;
    private int cuil;

    public Empresa() {
    }
    public Empresa(String nombre, String razonSocial, int cuil) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.cuil = cuil;
    }

    public int getCuil() {
        return cuil;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getNombre() {
        return nombre;
    }
}
