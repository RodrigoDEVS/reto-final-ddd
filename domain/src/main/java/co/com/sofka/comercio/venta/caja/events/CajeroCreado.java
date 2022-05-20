package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.CajeroId;
import co.com.sofka.comercio.venta.caja.values.Cedula;
import co.com.sofka.comercio.venta.caja.values.Telefono;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class CajeroCreado extends DomainEvent {
    private final CajeroId cajeroId;
    private final Nombre nombre;
    private final Cedula cedula;
    private final Telefono telefono;

    public CajeroCreado(CajeroId cajeroId, Nombre nombre, Cedula cedula, Telefono telefono) {
        super("co.com.sofka.comercio.venta.caja.events.CajeroCreado");
        this.cajeroId = cajeroId;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public CajeroId getCajeroId() {
        return cajeroId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
