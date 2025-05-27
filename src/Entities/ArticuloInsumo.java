package Entities;

import java.util.Set;

public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private boolean esParaElaborar;
    private static final double PORCENTAJE_GANANCIA = 0.3;

    public ArticuloInsumo(String denominacion, UnidadDeMedida unidadDeMedida, boolean esParaElaborar, double precioCompra) {
        super(denominacion, unidadDeMedida);
        this.esParaElaborar = esParaElaborar;
        this.precioCompra = precioCompra;
        calcularPrecioVenta();
    }

    public ArticuloInsumo() {
    }

    @Override
    public void calcularPrecioVenta() {
        this.precioVenta = precioCompra + (precioCompra * PORCENTAJE_GANANCIA);
    }

    @Override
    public double calcularCostoTotal() {
        return precioCompra;
    }

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

}
