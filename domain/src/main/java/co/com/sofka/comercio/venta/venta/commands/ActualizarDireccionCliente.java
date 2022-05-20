package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.venta.values.ClienteId;
import co.com.sofka.comercio.venta.venta.values.Direccion;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDireccionCliente extends Command {

    private final ClienteId clienteId;
    private final Direccion direccion;
    private final VentaId ventaId;

    public ActualizarDireccionCliente(ClienteId clienteId, Direccion direccion, VentaId ventaId) {
        this.clienteId = clienteId;
        this.direccion = direccion;
        this.ventaId = ventaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
