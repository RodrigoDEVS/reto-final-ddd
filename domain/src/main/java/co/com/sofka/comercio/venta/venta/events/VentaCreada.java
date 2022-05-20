package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.Cliente;
import co.com.sofka.comercio.venta.venta.Factura;
import co.com.sofka.comercio.venta.venta.Garantia;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final Valor valor;
    public VentaCreada(Valor valor) {
        super("co.com.sofka.comercio.events.VentaCreada");
        this.valor = valor;
    }

    public Valor getValor() {
        return valor;
    }
}
