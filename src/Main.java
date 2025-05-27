
import Entities.*;
import Entities.Enums.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        //Crear empresa y sucursal
        Empresa miEmpresa = new Empresa("El Buen Sabor", "Alimentos SRL", 334567439);
        Sucursal sucMendoza = new Sucursal("El Buen Sabor Suc MZA", LocalTime.of(11,00), LocalTime.of(23,00));
        miEmpresa.agregarSucursal(sucMendoza);

        // Crear un cliente
        Cliente cliente = new Cliente("Leandro", "Flores");
        cliente.setTelefono("2611234567");
        cliente.setEmail("leandro@mail.com");
        cliente.setFechaNacimiento(LocalDate.of(1998, 5, 23));

        Usuario usuario = new Usuario("1234", "leaflores");

        // Crear un artículo manufacturado
        ArticuloManufacturado pizza = new ArticuloManufacturado("Pizza Napolitana",  new UnidadDeMedida("U"), "Pizza con tomate, ajo y albahaca", 30, "Cocinar en horno de barro");
        ArticuloInsumo coca = new ArticuloInsumo("Coca Cola 1.5Lts", new UnidadDeMedida("Unidad"), false, 2500);
        ArticuloInsumo vino = new ArticuloInsumo("Vino La Estancia", new UnidadDeMedida("Unidad"), false, 5500 );
        //Ingredientes usados
        ArticuloInsumo harina = new ArticuloInsumo("Harina 000", new UnidadDeMedida("KG"), true, 3500.0);
        ArticuloInsumo tomate = new ArticuloInsumo("Tomate", new UnidadDeMedida("KG"), true, 2000);
        ArticuloInsumo ajo = new ArticuloInsumo("Ajo", new UnidadDeMedida("KG"), true, 2000);
        ArticuloInsumo albahaca = new ArticuloInsumo("Albaca", new UnidadDeMedida("KG"), true, 1000);


        //Agregar ArticuloManufacturadoDetalle a Pizza
        pizza.agregarIngrediente(new ArticuloManufacturadoDetalle(harina, 0.3));
        pizza.agregarIngrediente(new ArticuloManufacturadoDetalle(tomate, 0.2));
        pizza.agregarIngrediente(new ArticuloManufacturadoDetalle(ajo, 0.1));
        pizza.agregarIngrediente(new ArticuloManufacturadoDetalle(albahaca, 0.15));

        //Crear una promocion
        Promocion promocion = new Promocion("Vino La Estancia a $4000 la unidad", "Vinos La Estancia $4000 c/u (máximo 6 vinos por cliente)", TipoPromocion.PROMOCION_1);
        promocion.setFechaDesde(LocalDate.now().minusDays(1));
        promocion.setFechaHasta(LocalDate.now().plusDays(7));
        promocion.setHoraDesde(LocalTime.of(0,0));
        promocion.setHoraHasta(LocalTime.of(23,0));
        promocion.setPrecioPromocional(5000); //
        promocion.agregarArticuloPromocion(vino);

        //Calcular precio de Venta
        pizza.calcularPrecioVenta();
        coca.calcularPrecioVenta();
        vino.calcularPrecioVenta();

        // Crear un pedido y mostrar detalles por consola
        Pedido pedido = new Pedido(cliente, LocalDate.now(), FormaPago.MERCADOPAGO, TipoEnvio.DELIVERY, Estado.PENDIENTE, LocalTime.of(13, 30));
        pedido.agregarDetallePedido(new DetallePedido(pizza, 2));
        pedido.agregarDetallePedido(new DetallePedido(coca, 1));
        pedido.agregarDetallePedido(new DetallePedido(vino, 1));
        pedido.calcularTotal();
        pedido.calcularTotalCosto();
        pedido.mostrarPedido();

        //agregar el pedido a la sucursal
        sucMendoza.agregarPedido(pedido);

        // Crear una factura
        Factura factura = new Factura(pedido, LocalDate.now(), 123, 123, "122", "123", FormaPago.MERCADOPAGO);
        factura.setTotalVenta(pedido.getTotal());





    }
}


















