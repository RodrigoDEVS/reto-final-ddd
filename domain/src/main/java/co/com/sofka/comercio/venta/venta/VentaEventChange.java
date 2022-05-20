package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.valor = event.getValor();
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
    }
}
