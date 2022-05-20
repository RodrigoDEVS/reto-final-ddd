package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.carrito.values.ControlId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class OfertaAplicadaControl extends DomainEvent {
    private final ControlId controlId;
    private final Valor valor;

    public OfertaAplicadaControl(ControlId controlId, Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.ConsolaAgregada");
        this.controlId = controlId;
        this.valor = valor;
    }

    public ControlId getControlId() {
        return controlId;
    }

    public Valor getValor() {
        return valor;
    }
}
