package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.values.ClienteId;
import co.com.sofka.comercio.venta.venta.values.Direccion;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    protected Nombre nombre;
    protected Direccion direccion;

    public Cliente(ClienteId clienteId, Nombre nombre, Direccion direccion) {
        super(clienteId);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void actualizarDireccion(Direccion direccion){
        this.direccion = Objects.requireNonNull(direccion);
    }

}
