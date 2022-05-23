package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.values.ClienteId;
import co.com.sofka.comercio.venta.venta.values.Direccion;
import co.com.sofka.domain.generic.DomainEvent;

public class DireccionClienteActualizada extends DomainEvent {

    private final ClienteId clienteId;
    private final Direccion direccion;

    public DireccionClienteActualizada(ClienteId clienteId, Direccion direccion) {
        super("co.com.sofka.comercio.venta.events.DireccionClienteActualizada");
        this.clienteId = clienteId;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
