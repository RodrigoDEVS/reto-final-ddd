package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.carrito.values.ControlId;
import co.com.sofka.comercio.venta.carrito.values.Disenio;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ControlAgregado extends DomainEvent {
    private final ControlId controlId;
    private final Sistema sistema;
    private final Disenio disenio;
    private final Valor valor;

    public ControlAgregado(ControlId controlId, Sistema sistema, Disenio disenio, Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.ConsolaAgregada");
        this.controlId = controlId;
        this.sistema = sistema;
        this.disenio = disenio;
        this.valor = valor;
    }

    public ControlId getControlId() {
        return controlId;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public Valor getValor() {
        return valor;
    }
}
