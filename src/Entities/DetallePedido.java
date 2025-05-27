package Entities;

public class DetallePedido extends Base {
    private int cantidad;
    private double subTotal;
    private Articulo articulo;

    public DetallePedido(Articulo articulo, int cantidad) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.subTotal = calcularSubtotal();
    }

    public DetallePedido() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public double calcularSubtotal(){
        if (articulo.getPromocion() == null) {
            return articulo.getPrecioVenta() * cantidad;
        } else {
            return articulo.aplicarPromocion() * cantidad;
        }
    }

    public double calcularCosto(){
        return articulo.calcularCostoTotal();
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getDetalle(){
        return this.articulo.getDenominacion() + "         $" + this.articulo.getPrecioVenta() + "        Cantidad " + this.cantidad + "        Subtotal $" + this.getSubTotal();
    }
}