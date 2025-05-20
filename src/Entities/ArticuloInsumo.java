package Entities;

import java.util.Set;

public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private boolean esParaElaborar;
    private Set<ArticuloManufacturadoDetalle> listaArticuloDetalle;


    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public boolean isEsParaElaborar() {
        return esParaElaborar;
    }

    public void setEsParaElaborar(boolean esParaElaborar) {
        this.esParaElaborar = esParaElaborar;
    }

    public Set<ArticuloManufacturadoDetalle> getListaArticuloDetalle() {
        return listaArticuloDetalle;
    }

    public void setListaArticuloDetalle(Set<ArticuloManufacturadoDetalle> listaArticuloDetalle) {
        this.listaArticuloDetalle = listaArticuloDetalle;
    }

    public void agregarArticuloDetalle(ArticuloManufacturadoDetalle detalle) {
        this.listaArticuloDetalle.add(detalle);
    }
}
