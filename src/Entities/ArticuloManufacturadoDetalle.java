package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalle extends Base {
    private ArticuloInsumo articulo;
    private double cantidad;

    public double calcularCosto(){
        return (double) cantidad * articulo.getPrecioCompra();
    }
}
