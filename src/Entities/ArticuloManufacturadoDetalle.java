package Entities;

public class ArticuloManufacturadoDetalle extends Base {
    private ArticuloInsumo articulo;
    private double cantidad;

    public ArticuloManufacturadoDetalle() {
    }

    public ArticuloManufacturadoDetalle(ArticuloInsumo articulo, double cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public ArticuloInsumo getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloInsumo articulo) {
        this.articulo = articulo;
    }

    public double calcularCosto(){
        return (double) cantidad * articulo.getPrecioCompra();
    }
}
