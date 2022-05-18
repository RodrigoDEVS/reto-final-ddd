package co.com.sofka.comercio.venta;

import co.com.sofka.comercio.venta.events.FacturaGenerada;
import co.com.sofka.comercio.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.values.FacturaId;
import co.com.sofka.comercio.venta.values.Fecha;
import co.com.sofka.comercio.venta.values.Valor;
import co.com.sofka.comercio.venta.values.VentaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Venta extends AggregateEvent<VentaId> {
    protected Set<Factura> factura;
    protected Valor valor;

    public Venta(VentaId entityId, Factura factura, Valor valor) {
        super(entityId);
        appendChange(new VentaCreada(factura, valor)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaId entityId){
        super(entityId);
        subscribe(new VentaEventChange(this));
    }

    public static Venta from(VentaId entityId, List<DomainEvent> events){
        var venta = new Venta(entityId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public void generarFactura(Fecha fecha, Valor valor){
        var facturaId = new FacturaId();
        appendChange(new FacturaGenerada(facturaId, fecha, valor)).apply();
    }

    public Set<Factura> factura() {
        return factura;
    }

    public Valor valor() {
        return valor;
    }
}
