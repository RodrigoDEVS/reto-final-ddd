package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.CajeroId;
import co.com.sofka.comercio.venta.caja.values.Cedula;
import co.com.sofka.comercio.venta.caja.values.Telefono;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cajero extends Entity<CajeroId> {

    protected Nombre nombre;
    protected Cedula cedula;
    protected Telefono telefono;

    public Cajero(CajeroId cajeroId, Nombre nombre, Cedula cedula, Telefono telefono) {
        super(cajeroId);
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public void actualizarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

}
