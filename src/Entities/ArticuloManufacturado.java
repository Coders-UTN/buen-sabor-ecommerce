package Entities;
import java.util.Set;

public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalle> listaArticuloDetalle;

    public ArticuloManufacturado(String descripcion, int tiempoEstimadoMinutos, String preparacion) {
        this.descripcion = descripcion;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.preparacion = preparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempoEstimadoMinutos() {
        return tiempoEstimadoMinutos;
    }

    public void setTiempoEstimadoMinutos(int tiempoEstimadoMinutos) {
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public Set<ArticuloManufacturadoDetalle> getListaDetalles() {
        return listaArticuloDetalle;
    }

    public void setListaDetalles(Set<ArticuloManufacturadoDetalle> listaDetalles) {
        this.listaArticuloDetalle = listaDetalles;
    }

    public void agregarArticuloDetalle(ArticuloManufacturadoDetalle detalleArticulo){
        this.listaArticuloDetalle.add(detalleArticulo);

    }
}
