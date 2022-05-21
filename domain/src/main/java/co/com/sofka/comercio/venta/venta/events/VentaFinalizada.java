package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class VentaFinalizada extends DomainEvent {

    private final Cierre cierre;
    public VentaFinalizada(Cierre cierre) {
        super("co.com.sofka.comercio.events.VentaFinalizada");
        this.cierre = cierre;
    }

    public Cierre getCierre() {
        return cierre;
    }
}
