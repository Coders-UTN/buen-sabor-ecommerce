package Entities;

import Entities.Enums.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Promocion extends Base{
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcion;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    private Set<Imagen> imagenes;
    private Set<Articulo> articulosEnPromocion;

    public Promocion() {
    }

    public Promocion(TipoPromocion tipoPromocion, double precioPromocional, String descripcion, LocalTime horaHasta, LocalTime horaDesde, LocalDate fechaHasta, LocalDate fechaDesde, String denominacion) {
        this.tipoPromocion = tipoPromocion;
        this.precioPromocional = precioPromocional;
        this.descripcion = descripcion;
        this.horaHasta = horaHasta;
        this.horaDesde = horaDesde;
        this.fechaHasta = fechaHasta;
        this.fechaDesde = fechaDesde;
        this.denominacion = denominacion;
        this.imagenes = new HashSet<>();
        this.articulosEnPromocion = new HashSet<>();
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public LocalTime getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(LocalTime horaDesde) {
        this.horaDesde = horaDesde;
    }

    public LocalTime getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(LocalTime horaHasta) {
        this.horaHasta = horaHasta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPromocional() {
        return precioPromocional;
    }

    public void setPrecioPromocional(double precioPromocional) {
        this.precioPromocional = precioPromocional;
    }

    public TipoPromocion getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(TipoPromocion tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public Set<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Set<Articulo> getArticulosEnPromocion() {
        return articulosEnPromocion;
    }

    public void setArticulosEnPromocion(Set<Articulo> articulosEnPromocion) {
        this.articulosEnPromocion = articulosEnPromocion;
    }
}
