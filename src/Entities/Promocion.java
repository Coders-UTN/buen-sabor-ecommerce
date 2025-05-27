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
    private String descripcionDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    private Set<Imagen> imagenes;
    private Set<Articulo> articulosEnPromocion = new HashSet<>();

    public Promocion() {
    }

    public Promocion(String denominacion, String descripcion, TipoPromocion tipoPromocion) {
        this.denominacion = denominacion;
        this.descripcionDescuento = descripcion;
        this.tipoPromocion = tipoPromocion;
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

    public String getDescripcion() { return descripcionDescuento; }

    public void setDescripcion(String descripcion) {
        this.descripcionDescuento = descripcion;
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
    public void agregarArticuloPromocion(Articulo articulo){
        this.articulosEnPromocion.add(articulo);
        articulo.agregarPromocion(this);
    }

    public void eliminarArticuloPromocion(Articulo articulo){
        if (this.articulosEnPromocion.remove(articulo)){
            System.out.println("Articulo " + articulo.getDenominacion() + " eliminado de la promocion");
        } else {
            System.out.println("El articulo no existe en la lista de articulos en promocion");
        }
    }

    public void agregarImagen(Imagen imagen){
        this.imagenes.add(imagen);
    }

    public void eliminarImagen(Imagen imagen){
        if (this.imagenes.remove(imagen)){
            System.out.println("Imagen eliminada");
        } else {
            System.out.println("La imagen no se encuentra en la lista de imágenes");
        }
    }

    public boolean estaVigente(){
        LocalDate fechaHoy = LocalDate.now();
        LocalTime horaHoy = LocalTime.now();

        boolean esValidaPorFecha = (fechaHoy.isEqual(fechaDesde) || fechaHoy.isAfter(fechaDesde)) &&
                (fechaHoy.isEqual(fechaHasta) || fechaHoy.isBefore(fechaHasta));

        boolean esValidaPorHora = (horaHoy.equals(horaDesde) || horaHoy.isAfter(horaDesde)) &&
                (horaHoy.equals(fechaHasta) || horaHoy.isBefore(horaHasta));

        return esValidaPorFecha && esValidaPorHora;
    }
}
