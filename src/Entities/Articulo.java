package Entities;

import Entities.Enums.UnidadMedida;
import com.sun.source.doctree.SeeTree;
import java.util.Set;

public abstract class Articulo extends Base{
    protected String denominacion;
    protected double precioVenta;
    protected UnidadDeMedida unidadDeMedida;
    private Promocion promocion;

    public Articulo() {
    }

    public Articulo(String denominacion, UnidadDeMedida unidadDeMedida) {
        this.denominacion = denominacion;
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }
    public void agregarPromocion(Promocion promocion){
        this.promocion = promocion;
    }

    public abstract void calcularPrecioVenta();

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public double aplicarPromocion(){
        if (promocion != null && promocion.estaVigente()){
            return promocion.getPrecioPromocional();
        } else {
            return precioVenta;
        }
    }

    public abstract double calcularCostoTotal();
}
