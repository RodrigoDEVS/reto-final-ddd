package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.domain.generic.DomainEvent;

public class CierreActualizado extends DomainEvent {
    private final Cierre cierre;

    public CierreActualizado(Cierre cierre) {
        super("co.com.sofka.comercio.venta.caja.events.CierreActualizado");
        this.cierre = cierre;
    }

    public Cierre getCierre() {
        return cierre;
    }
}
