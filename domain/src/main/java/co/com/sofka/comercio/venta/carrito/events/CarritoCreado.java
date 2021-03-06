package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class CarritoCreado extends DomainEvent {
    private final Valor valor;

    public CarritoCreado(Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.IngresoCreado");
        this.valor = valor;
    }

    public Valor getValor() {
        return valor;
    }
}
