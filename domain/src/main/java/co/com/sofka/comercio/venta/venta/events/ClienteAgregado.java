package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.values.ClienteId;
import co.com.sofka.comercio.venta.venta.values.Direccion;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteAgregado extends DomainEvent {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Direccion direccion;

    public ClienteAgregado(ClienteId clienteId, Nombre nombre, Direccion direccion) {
        super("co.com.sofka.comercio.events.ClienteAgregado");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
