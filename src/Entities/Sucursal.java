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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public Set<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(Set<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public Set<Promocion> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(Set<Promocion> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }
}
