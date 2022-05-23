package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.CajeroId;
import co.com.sofka.comercio.venta.caja.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoCajeroActualizado extends DomainEvent {

    private final CajeroId cajeroId;
    private final Telefono telefono;

    public TelefonoCajeroActualizado(CajeroId cajeroId, Telefono telefono) {
        super("co.com.sofka.comercio.caja.events.ValorIngresoActualizado");
        this.cajeroId = cajeroId;
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
