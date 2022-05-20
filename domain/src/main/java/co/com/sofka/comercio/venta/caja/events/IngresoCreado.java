package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.IngresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class IngresoCreado extends DomainEvent {
    private final IngresoId ingresoId;
    private final Valor valor;

    public IngresoCreado(IngresoId ingresoId, Valor valor) {
        super("co.com.sofka.comercio.venta.caja.events.IngresoCreado");
        this.ingresoId = ingresoId;
        this.valor = valor;
    }

    public IngresoId getIngresoId() {
        return ingresoId;
    }

    public Valor getValor() {
        return valor;
    }
}
