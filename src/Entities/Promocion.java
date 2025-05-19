package Entities;

import Enums.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Promocion {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcion;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    private ArrayList<Imagen> imagenes;

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
        this.imagenes = new ArrayList<>();
    }
}
