package Entities;

import Entities.Enums.Estado;
import Entities.Enums.FormaPago;
import Entities.Enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Pedido extends Base {
    private Cliente cliente;
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private Set<DetallePedido> detallesDelPedido;
    private static double PRECIO_BASE_ENVIO = 900;
    private static double COSTO_MERCADO_PAGO = 0.05;

    public Pedido(Cliente cliente,LocalDate fechaPedido, FormaPago formaPago, TipoEnvio tipoEnvio, Estado estado, LocalTime horaEstimadaFinalizacion) {
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.formaPago = formaPago;
        this.tipoEnvio = tipoEnvio;
        this.estado = estado;
        this.horaEstimadaFinalizacion = horaEstimadaFinalizacion;
        this.detallesDelPedido = new HashSet<>();
    }

    public Pedido() {
    }

    public LocalTime getHoraEstimadaFinalizacion() {
        return horaEstimadaFinalizacion;
    }

    public void setHoraEstimadaFinalizacion(LocalTime horaEstimadaFinalizacion) {
        this.horaEstimadaFinalizacion = horaEstimadaFinalizacion;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalCosto() {
        return totalCosto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void agregarDetallePedido(DetallePedido nuevoDetalle) {
        this.detallesDelPedido.add(nuevoDetalle);
    }

    public void calcularTotal(){
        double total = 0.0;
        for (DetallePedido detalle : detallesDelPedido) {
            total += detalle.calcularSubtotal();
        }
        total += calcularCostoEnvio() + calcularComisionMP();
        this.total = total;
    }

    public void calcularTotalCosto(){
        double total = 0.0;
        for (DetallePedido detalle : detallesDelPedido){
            total += detalle.calcularCosto();
        }
        this.totalCosto = total;
    }

    public double calcularCostoEnvio(){
        if (this.tipoEnvio == TipoEnvio.DELIVERY) {
            return  PRECIO_BASE_ENVIO;
        }
        return 0.0;
    }

    public double calcularComisionMP(){
        if (this.formaPago == FormaPago.MERCADOPAGO) {
            return this.total * COSTO_MERCADO_PAGO;
        }
        return 0.0;
    }

    public void mostrarPedido(){
        System.out.println("-------------------------------------------------");
        System.out.println("Pedido Cliente: " + this.cliente.getApellido() + " " + this.cliente.getNombre() + "\n" +
                "Fecha " + this.fechaPedido.toString() + "\n" +
                "Medio de pago: " + this.formaPago.name() + "\n" +
                "Detalle:" );
        for (DetallePedido detalle : this.detallesDelPedido) {
            System.out.println(detalle.getDetalle());
        }
        System.out.println("Envio          $" + calcularCostoEnvio());
        System.out.println("Comision MP    $" + calcularComisionMP() +
                "\nTotal costo    $" + this.totalCosto +
                "\nTotal          $" + this.total);
        System.out.println("-------------------------------------------------");
    }
}
