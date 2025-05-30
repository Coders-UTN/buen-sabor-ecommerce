package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedido extends Base {
    private int cantidad;
    private Articulo articulo;
    private double precioUnitario;
    private double subTotal;

    public DetallePedido(Articulo articulo, int cantidad){
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public double calcularCosto(){
        return articulo.calcularCostoTotal();
    }

    private void calcularSubtotal(){
        this.subTotal = precioUnitario * cantidad;
    }

    public void calcularPrecioUnitarioEnPromocion(Set<Promocion> promociones){
        double precioFinal = articulo.getPrecioVenta();
        for (Promocion promocion : promociones){
            if (promocion.estaVigente() && promocion.contieneArticulo(articulo)){
               precioFinal = promocion.getPrecioPromocional();
            }
        }
        this.precioUnitario = precioFinal;
        calcularSubtotal();
    }

    public String getDenominacionDetalle(){
        return articulo.getDenominacion();
    }

    public void generarCostoVenta() {
        articulo.calcularPrecioVenta();
    }
}