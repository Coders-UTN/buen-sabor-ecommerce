package Entities;

import Entities.Enums.UnidadMedida;
import com.sun.source.doctree.SeeTree;
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
public abstract class Articulo extends Base{
    protected String denominacion;
    protected double precioVenta;
    protected UnidadDeMedida unidadDeMedida;

    public Articulo(String denominacion, UnidadDeMedida unidadDeMedida) {
        this.denominacion = denominacion;
        this.unidadDeMedida = unidadDeMedida;
    }

    public abstract void calcularPrecioVenta();

    public abstract double calcularCostoTotal();

}
