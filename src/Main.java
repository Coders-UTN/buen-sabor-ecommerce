
import Entities.*;
import Entities.Enums.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Crear empresa y sucursal
        Empresa miEmpresa = new Empresa("El Buen Sabor", "Alimentos SRL", 334567439);
        Sucursal sucMendoza = Sucursal.builder().nombre("El Buen Sabor Sucursal Mendoza").horarioApertura(LocalTime.of(11, 00)).horarioCierre(LocalTime.of(23, 30)).build();
        miEmpresa.agregarSucursal(sucMendoza);

        // Crear un cliente
        Cliente cliente = new Cliente("Leandro", "Flores");
        cliente.setTelefono("2611234567");
        cliente.setEmail("leandro@mail.com");
        cliente.setFechaNacimiento(LocalDate.of(1998, 5, 23));

        Usuario usuario = new Usuario("1234", "leaflores", cliente);

        // Crear un artículo manufacturado
        UnidadDeMedida unidad = new UnidadDeMedida("Unidad");
        UnidadDeMedida kg = new UnidadDeMedida("KG");

        ArticuloInsumo coca = ArticuloInsumo.builder().denominacion("Coca Cola 1.5Lts").unidadDeMedida(unidad).esParaElaborar(false).precioCompra(2500).build();
        ArticuloInsumo vino = ArticuloInsumo.builder().denominacion("Vino La Estancia").unidadDeMedida(unidad).esParaElaborar(false).precioCompra(5500).build();
        //Ingredientes usados
        ArticuloInsumo harina = ArticuloInsumo.builder().denominacion("Harina").unidadDeMedida(kg).esParaElaborar(true).precioCompra(3500).build();
        ArticuloInsumo tomate = ArticuloInsumo.builder().denominacion("Tomate").unidadDeMedida(kg).esParaElaborar(true).precioCompra(2000).build();
        ArticuloInsumo ajo = ArticuloInsumo.builder().denominacion("Ajo").unidadDeMedida(kg).esParaElaborar(true).precioCompra(2000).build();
        ArticuloInsumo albahaca = ArticuloInsumo.builder().denominacion("Albahaca").unidadDeMedida(kg).esParaElaborar(true).precioCompra(1500).build();
        ArticuloInsumo queso = ArticuloInsumo.builder().denominacion("Queso Muzzarella").unidadDeMedida(kg).esParaElaborar(true).precioCompra(9000).build();

        //Ingredientes para pizza y creacion de pizza
        ArticuloManufacturadoDetalle harinaPizza = new ArticuloManufacturadoDetalle(harina, 0.4);
        ArticuloManufacturadoDetalle tomatePizza = new ArticuloManufacturadoDetalle(tomate, 0.3);
        ArticuloManufacturadoDetalle ajoPizza = new ArticuloManufacturadoDetalle(ajo, 0.2);
        ArticuloManufacturadoDetalle albahacaPizza = new ArticuloManufacturadoDetalle(albahaca, 0.15);
        ArticuloManufacturadoDetalle quesoPizza = new ArticuloManufacturadoDetalle(queso, 0.4);

        ArticuloManufacturado pizza = ArticuloManufacturado.builder()
                .denominacion("Pizza Napolitana")
                .unidadDeMedida(unidad).
                descripcion("Pizza con tomate, ajo y albahaca")
                .tiempoEstimadoMinutos(30).preparacion("Cocinar en horno de barro")
                .build();

        pizza.agregarIngrediente(harinaPizza, tomatePizza, ajoPizza, albahacaPizza, quesoPizza);

        //Crear una promocion
        Promocion promocion = Promocion.builder().
                denominacion("Vino La Estancia a $4000 la unidad").
                descripcionDescuento("Vinos La Estancia $4000 c/u (máximo 6 vinos por cliente)").
                tipoPromocion(TipoPromocion.PROMOCION_1).
                build();
        promocion.setFechaDesde(LocalDate.now().minusDays(1));
        promocion.setFechaHasta(LocalDate.now().plusDays(7));
        promocion.setHoraDesde(LocalTime.of(0, 0));
        promocion.setHoraHasta(LocalTime.of(23, 0));
        promocion.setPrecioPromocional(5000); //
        promocion.agregarArticuloPromocion(vino);

        //Calcular precio de Venta
        pizza.calcularPrecioVenta();
        coca.calcularPrecioVenta();
        vino.calcularPrecioVenta();

        // Crear un pedido y mostrar detalles por consola
        //Pedido pedido = new Pedido(cliente, LocalDate.now(), FormaPago.MERCADOPAGO, TipoEnvio.DELIVERY, Estado.PENDIENTE, LocalTime.of(13, 30));
        Pedido pedido = Pedido.builder()
                .fechaPedido(LocalDate.now())
                .formaPago(FormaPago.MERCADOPAGO)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .estado(Estado.PENDIENTE)
                .horaEstimadaFinalizacion(LocalTime.of(13, 30))
                .cliente(cliente)
                .build();

        //Crear detallepedido para agregar al pedido
        DetallePedido pedido1 = new DetallePedido(pizza, 2);
        DetallePedido pedido2 = new DetallePedido(coca, 1);
        DetallePedido pedido3 = new DetallePedido(vino, 1);

        //lista de promociones para verificar si los articulos estan en promocion
        Set<Promocion> listaPromociones = new HashSet<>();
        listaPromociones.add(promocion);

        //Agregado de detalles al pedido y verificacion de promociones
        pedido.agregarDetallePedido(pedido1, pedido2, pedido3);
        pedido.calcularPreciosConPromo(listaPromociones);
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


















