
import Entities.*;
import Entities.Enums.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Leandro");
        cliente.setApellido("Flores");
        cliente.setTelefono("2611234567");
        cliente.setEmail("leandro@mail.com");
        cliente.setFechaNacimiento(LocalDate.of(1998, 5, 23));

        // Crear un artículo manufacturado
        ArticuloManufacturado pizza = new ArticuloManufacturado();
        pizza.setDenominacion("Pizza Napolitana");
        pizza.setPrecioVenta(3000);
        pizza.setDescripcion("Pizza con tomate, ajo y albahaca");
        pizza.setTiempoEstimadoMinutos(20);
        pizza.setPreparacion("Cocinar en horno de barro");

        // Crear un detalle de pedido
        DetallePedido detalle = new DetallePedido();
        detalle.setCantidad(2);
        detalle.setSubTotal(pizza.getPrecioVenta() * detalle.getCantidad());

        // Crear un pedido
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(LocalDate.now());
        pedido.setHoraEstimadaFinalizacion(LocalTime.of(13, 30));
        pedido.setEstado(Estado.PENDIENTE);
        pedido.setFormaPago(FormaPago.EFECTIVO);
        pedido.setTipoEnvio(TipoEnvio.DELIVERY);
        pedido.setTotal(detalle.getSubTotal());
        pedido.setTotalCosto(detalle.getSubTotal() * 0.6); // ejemplo costo

        // Crear una factura
        Factura factura = new Factura();
        factura.setFechaFacturacion(LocalDate.now());
        factura.setFormaPago(FormaPago.EFECTIVO);
        factura.setMpPaymentId(123456);
        factura.setMpMerchantOrderId(78910);
        factura.setMpPreferenceId("abc-123");
        factura.setMpPaymentType("cash");
        factura.setTotalVenta(pedido.getTotal());

        // Mostrar todo por consola
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Pedido: " + pedido.getFechaPedido() + " - Estado: " + pedido.getEstado());
        System.out.println("Artículo: " + pizza.getDenominacion() + " - $" + pizza.getPrecioVenta());
        System.out.println("Cantidad: " + detalle.getCantidad());
        System.out.println("Total pedido: $" + pedido.getTotal());
        System.out.println("Factura generada - Total venta: $" + factura.getTotalVenta());
    }
}
