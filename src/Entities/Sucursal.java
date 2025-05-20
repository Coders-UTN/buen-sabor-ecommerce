package Entities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Set<Empresa> listaEmpresas;
    private Set<Promocion> listaPromociones;

    public Sucursal() {
    }

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.listaEmpresas = new HashSet<>();
        this.listaPromociones = new HashSet<>();
    }
    public void agregarEmpresa(Empresa empresa) {
        this.listaEmpresas.add(empresa);
        System.out.println("Empresa agregada: " + empresa.getNombre());
    }
}
