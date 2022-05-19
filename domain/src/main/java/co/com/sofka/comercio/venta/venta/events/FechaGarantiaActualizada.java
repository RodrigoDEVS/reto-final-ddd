package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.GarantiaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaGarantiaActualizada extends DomainEvent {

    private final GarantiaId garantiaId;
    private final Fecha fecha;

    public FechaGarantiaActualizada(GarantiaId garantiaId, Fecha fecha) {
        super("co.com.sofka.comercio.venta.events.FechaGarantiaActualizada");
        this.garantiaId = garantiaId;
        this.fecha = fecha;
    }

    public GarantiaId getGarantiaId() {
        return garantiaId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
