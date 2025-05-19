package Entities;

import java.time.LocalTime;
import java.util.ArrayList;

public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private ArrayList<Empresa> listaEmpresas;
    private ArrayList<Promocion> listaPromociones;

    public Sucursal() {
    }

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.listaEmpresas = new ArrayList<>();
        this.listaPromociones = new ArrayList<>();
    }
    public void agregarEmpresa(Empresa empresa) {
        this.listaEmpresas.add(empresa);
        System.out.println("Empresa agregada: " + empresa.getNombre());
    }
}