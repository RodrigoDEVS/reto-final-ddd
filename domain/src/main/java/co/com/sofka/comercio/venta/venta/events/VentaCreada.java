package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.Factura;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final Factura factura;
    private final Valor valor;
    public VentaCreada(Factura factura, Valor valor) {
        super("co.com.sofka.comercio.VentaCreada");
        this.factura = factura;
        this.valor = valor;
    }

    public Factura getFactura() {
        return factura;
    }

    public Valor getValor() {
        return valor;
    }
}
