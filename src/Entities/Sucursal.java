package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Empresa empresa;
    @Builder.Default
    private Set<Promocion> listaPromociones = new HashSet<>();
    @Builder.Default
    private Set<Pedido> listaPedidos = new HashSet<>();
    private set<Categoria> categorias = new HashSet<>();
    private Domicilio domicilio;

    public void agregarPromocion(Promocion promocion){
        this.listaPromociones.add(promocion);
        System.out.println("Promocion " + promocion.getDenominacion() + " agregada");
    }

    public void agregarCategorias(Categoria categoria){
        this.categorias.add(categoria);
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
