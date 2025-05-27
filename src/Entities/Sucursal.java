package Entities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Empresa empresa;
    private Set<Promocion> listaPromociones;
    private Set<Pedido> listaPedidos;
    private Categoria categoria;

    public Sucursal() {
    }

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.listaPromociones = new HashSet<>();
        this.listaPedidos = new HashSet<>();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(Set<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public Set<Promocion> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(Set<Promocion> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }

    public void agregarPromocion(Promocion promocion){
        this.listaPromociones.add(promocion);
        System.out.println("Promocion " + promocion.getDenominacion() + " agregada");
    }

    public void eliminarPromocion(Promocion promocion){
        if (this.listaPromociones.remove(promocion)) {
            System.out.println("Promocion " + promocion.getDenominacion() + " eliminada");
        } else {
            System.out.println("La promocion no se encuentra en la lista");
        }
    }

    public void agregarPedido(Pedido pedido){
        this.listaPedidos.add(pedido);
    }

}
