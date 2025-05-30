package Entities;

import Entities.Enums.Estado;
import Entities.Enums.FormaPago;
import Entities.Enums.TipoEnvio;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends Base {
    private Cliente cliente;
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    @Builder.Default
    private Set<DetallePedido> detallesDelPedido = new HashSet<>();
    private static double PRECIO_BASE_ENVIO = 900;
    private static double COSTO_MERCADO_PAGO = 0.05;

    public void agregarDetallePedido(DetallePedido... nuevosDetalles) {
        for (DetallePedido detalle : nuevosDetalles) {
            detalle.generarCostoVenta();
        this.detallesDelPedido.add(detalle);
        }
    }

    public void calcularTotal(){
        double total = 0.0;
        for (DetallePedido detalle : detallesDelPedido) {
            total += detalle.getSubTotal();
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

    public void calcularPreciosConPromo(Set<Promocion> promociones){
        for (DetallePedido detalle : detallesDelPedido){
            detalle.calcularPrecioUnitarioEnPromocion(promociones);
        }
    }

    public void mostrarPedido(){
        System.out.println("-------------------------------------------------");
        System.out.println("Pedido Cliente: " + this.cliente.getApellido() + " " + this.cliente.getNombre() + "\n" +
                "Fecha " + this.fechaPedido.toString() + "\n" +
                "Medio de pago: " + this.formaPago.name() + "\n" +
                "Detalle:" );
        for (DetallePedido detalle : this.detallesDelPedido) {
            System.out.println(detalle.getDenominacionDetalle()+ "         $" + detalle.getPrecioUnitario() + "        Cantidad " + detalle.getCantidad() + "        Subtotal $" + detalle.getSubTotal());

        }
        System.out.println("Envio          $" + calcularCostoEnvio());
        System.out.println("Comision MP    $" + calcularComisionMP() +
                "\nTotal costo    $" + this.totalCosto + "***Notacion para control***" +
                "\nTotal          $" + this.total);
        System.out.println("-------------------------------------------------");
    }
}
