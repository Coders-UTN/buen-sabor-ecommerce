package Entities;

import Entities.Enums.TipoPromocion;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Promocion extends Base{
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<Articulo> articulosEnPromocion = new HashSet<>();

    public void agregarArticuloPromocion(Articulo... articulos){
        for (Articulo articulo : articulos) {
            this.articulosEnPromocion.add(articulo);
        }
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

    public boolean contieneArticulo(Articulo articulo){
        return articulosEnPromocion.contains(articulo);
    }
}
