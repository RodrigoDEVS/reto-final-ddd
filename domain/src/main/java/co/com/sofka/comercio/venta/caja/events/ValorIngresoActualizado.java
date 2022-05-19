package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.IngresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorIngresoActualizado extends DomainEvent {

    private final IngresoId ingresoId;
    private final Valor valor;

    public ValorIngresoActualizado(IngresoId ingresoId, Valor valor) {
        super("co.com.sofka.comercio.caja.events.ValorIngresoActualizado");
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
