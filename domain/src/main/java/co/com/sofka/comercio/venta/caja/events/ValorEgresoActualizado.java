package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.EgresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorEgresoActualizado extends DomainEvent {

    private final EgresoId egresoId;
    private final Valor valor;

    public ValorEgresoActualizado(EgresoId egresoId, Valor valor) {
        super("co.com.sofka.comercio.caja.events.ValorEgresoActualizado");
        this.egresoId = egresoId;
        this.valor = valor;
    }

    public EgresoId getEgresoId() {
        return egresoId;
    }

    public Valor getValor() {
        return valor;
    }
}
