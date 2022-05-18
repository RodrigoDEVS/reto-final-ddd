package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.events.FacturaGenerada;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Venta extends AggregateEvent<VentaId> {
    protected Factura factura;
    protected Valor valor;

    public Venta(VentaId ventaId, Factura factura, Valor valor) {
        super(ventaId);
        appendChange(new VentaCreada(factura, valor)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaId ventaId){
        super(ventaId);
        subscribe(new VentaEventChange(this));
    }

    public static Venta from(VentaId ventaId, List<DomainEvent> events){
        var venta = new Venta(ventaId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public void generarFactura(Fecha fecha, Valor valor){
        var facturaId = new FacturaId();
        appendChange(new FacturaGenerada(facturaId, fecha, valor)).apply();
    }

    public Factura factura() {
        return factura;
    }

    public Valor valor() {
        return valor;
    }
}
