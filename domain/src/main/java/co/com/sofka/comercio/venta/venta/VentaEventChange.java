package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.events.FacturaGenerada;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.factura = new HashSet<>();
            venta.valor = event.getValor();
        });

        apply((FacturaGenerada event)->{
            var facturaId =  event.getFacturaId();
            var factura = new Factura(facturaId, event.getFecha(), event.getValor());
            //TODO: validaciones
            venta.factura.add(factura);
        });
    }
}
