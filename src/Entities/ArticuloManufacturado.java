package Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> listaIngredientes  = new HashSet<>();
    private static final double PORCENTAJE_GANANCIA = 0.7;

    @Override
    public void calcularPrecioVenta() {
        this.precioVenta = calcularCostoTotal() * ( 1 + PORCENTAJE_GANANCIA);
    }

    @Override
    public double calcularCostoTotal() {
        double costototal = 0.0;
        for (ArticuloManufacturadoDetalle ingrediente : listaIngredientes) {
            costototal += ingrediente.calcularCosto();
        }
        return costototal;
    }

    public void agregarIngrediente(ArticuloManufacturadoDetalle... ingredientes){
        for (ArticuloManufacturadoDetalle nuevoIngrediente : ingredientes) {
            this.listaIngredientes.add(nuevoIngrediente);
        }
    }
}
