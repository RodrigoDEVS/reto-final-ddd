package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.venta.values.ClienteId;
import co.com.sofka.comercio.venta.venta.values.Direccion;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class AgregarCliente extends Command {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final VentaId ventaId;

    public AgregarCliente(ClienteId clienteId, Nombre nombre, Direccion direccion, VentaId ventaId) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ventaId = ventaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
