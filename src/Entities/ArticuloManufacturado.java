package Entities;
import java.util.HashSet;
import java.util.Set;

public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalle> listaIngredientes;
    private static final double PORCENTAJE_GANANCIA = 0.7;

    public ArticuloManufacturado(String denominacion, UnidadDeMedida unidadDeMedida, String descripcion, int tiempoEstimadoMinutos, String preparacion) {
        super(denominacion,  unidadDeMedida);
        this.descripcion = descripcion;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.preparacion = preparacion;
        this.listaIngredientes = new HashSet<>();
    }

    public ArticuloManufacturado() {

    }

    @Override
    public void calcularPrecioVenta() {
        this.precioVenta = calcularCostoTotal() * ( 1 + PORCENTAJE_GANANCIA);
    }

    @Override
    public double calcularCostoTotal() {
        double costototal = 0.0;
        for (ArticuloManufacturadoDetalle ingrediente : listaIngredientes) {
            costototal += ingrediente.calcularCosto();
        }
        return costototal;
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
        return listaIngredientes;
    }

    public void setListaDetalles(Set<ArticuloManufacturadoDetalle> listaDetalles) {
        this.listaIngredientes = listaDetalles;
    }

    public void agregarIngrediente(ArticuloManufacturadoDetalle ingrediente){
        this.listaIngredientes.add(ingrediente);

    }
}
