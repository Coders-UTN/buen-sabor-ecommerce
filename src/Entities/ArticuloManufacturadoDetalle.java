package Entities;

public class ArticuloManufacturadoDetalle extends Base {
    private int cantidad;
    private Articulo articulo;

    public ArticuloManufacturadoDetalle() {
    }

    public ArticuloManufacturadoDetalle(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
