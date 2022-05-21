package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.comercio.venta.venta.events.*;
import co.com.sofka.comercio.venta.venta.values.EstadoDeVenta;
import co.com.sofka.domain.generic.EventChange;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.valor = event.getValor();
            venta.estadoDeVenta = new EstadoDeVenta(EstadoDeVenta.Estados.POR_INICIAR);
            venta.cierre = new Cierre(0D);
        });

        apply((FacturaGenerada event)->{
            var facturaId =  event.getFacturaId();
            var factura = new Factura(facturaId, event.getFecha(), event.getValor());
            //TODO: validaciones
            venta.factura = factura;
        });

        apply((ClienteAgregado event) -> {
            var clienteId = event.getClienteId();
            var cliente = new Cliente(clienteId, event.getNombre(), event.getDireccion());
            venta.cliente = cliente;
        });

        apply((DireccionClienteActualizada event) -> {
            var direccion = event.getDireccion();
            venta.cliente.actualizarDireccion(direccion);
        });

        apply((ValorFacturaActualizado event) -> {
            var valor = event.getValor();
            venta.factura.actualizarValor(valor);
        });

        apply((VentaFinalizada event) -> {
            venta.cierre = event.getCierre();
            venta.estadoDeVenta = new EstadoDeVenta(EstadoDeVenta.Estados.FINALIZADA);
        });
    }
}
