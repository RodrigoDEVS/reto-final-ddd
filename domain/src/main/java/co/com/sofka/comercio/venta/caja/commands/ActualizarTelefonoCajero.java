package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.CajeroId;
import co.com.sofka.comercio.venta.caja.values.Cedula;
import co.com.sofka.comercio.venta.caja.values.Telefono;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarTelefonoCajero extends Command {

    private final CajeroId cajeroId;

    private final Telefono telefono;
    private final CajaId cajaId;

    public ActualizarTelefonoCajero(CajeroId cajeroId, Telefono telefono, CajaId cajaId) {
        this.cajeroId = cajeroId;
        this.telefono = telefono;
        this.cajaId = cajaId;
    }

    public CajeroId getCajeroId() {
        return cajeroId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
