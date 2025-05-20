package Entities;

import Entities.Enums.UnidadMedida;
import com.sun.source.doctree.SeeTree;
import java.util.Set;

public abstract class Articulo extends Base{
    protected String denominacion;
    protected double precioVenta;
    protected Set<Promocion> promociones;
    protected Set<UnidadMedida> unidadesMedidas;

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Set<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(Set<Promocion> promociones) {
        this.promociones = promociones;
    }

    public Set<UnidadMedida> getUnidadesMedidas() {
        return unidadesMedidas;
    }

    public void setUnidadesMedidas(Set<UnidadMedida> unidadesMedidas) {
        this.unidadesMedidas = unidadesMedidas;
    }

    public void agregarPromocion(Promocion promocion){
        this.promociones.add(promocion);
    }

    public void agregarUnidadMedida(UnidadMedida unidad) {
        this.unidadesMedidas.add(unidad);
    }
}
