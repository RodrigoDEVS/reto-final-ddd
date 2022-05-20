package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.CajeroId;
import co.com.sofka.comercio.venta.caja.values.Cedula;
import co.com.sofka.comercio.venta.caja.values.Telefono;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearCajero extends Command {

    private final CajeroId cajeroId;
    private final Nombre nombre;
    private final Cedula cedula;
    private final Telefono telefono;
    private final CajaId cajaId;

    public CrearCajero(CajeroId cajeroId, Nombre nombre, Cedula cedula, Telefono telefono, CajaId cajaId) {
        this.cajeroId = cajeroId;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.cajaId = cajaId;
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

    public CajaId getCajaId() {
        return cajaId;
    }
}
