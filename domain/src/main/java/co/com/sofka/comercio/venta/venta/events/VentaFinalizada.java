package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class VentaFinalizada extends DomainEvent {

    private final Cierre cierre;
    private final CajaId cajaId;

    public VentaFinalizada(Cierre cierre, CajaId cajaId) {
        super("co.com.sofka.comercio.events.VentaFinalizada");
        this.cierre = cierre;
        this.cajaId = cajaId;
    }

    public Cierre getCierre() {
        return cierre;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
