package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private boolean esParaElaborar;
    private static final double PORCENTAJE_GANANCIA = 0.3;

    @Override
    public void calcularPrecioVenta() {
        this.precioVenta = precioCompra + (precioCompra * PORCENTAJE_GANANCIA);
    }

    @Override
    public double calcularCostoTotal() {
        return precioCompra;
    }
}
