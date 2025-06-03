package Entities;

import Entities.Enums.UnidadMedida;
import com.sun.source.doctree.SeeTree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
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
    private Set<Imagen> imagenes = new HashSet();

    public Articulo(String denominacion, UnidadDeMedida unidadDeMedida) {
        this.denominacion = denominacion;
        this.unidadDeMedida = unidadDeMedida;
    }

    public void agregarImagen(Imagen imagen){
        this.imagenes.add(imagen);
    }

    public abstract void calcularPrecioVenta();

    public abstract double calcularCostoTotal();

}
