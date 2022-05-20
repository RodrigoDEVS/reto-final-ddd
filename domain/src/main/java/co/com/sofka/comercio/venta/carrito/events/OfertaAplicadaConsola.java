package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.carrito.values.ConsolaId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class OfertaAplicadaConsola extends DomainEvent {
    private final ConsolaId consolaId;
    private final Valor valor;

    public OfertaAplicadaConsola(ConsolaId consolaId, Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.ConsolaAgregada");
        this.consolaId = consolaId;
        this.valor = valor;
    }

    public ConsolaId getConsolaId() {
        return consolaId;
    }

    public Valor getValor() {
        return valor;
    }
}
