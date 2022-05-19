package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.IngresoId;
import co.com.sofka.domain.generic.Entity;

public class Ingreso extends Entity<IngresoId> {

    public Ingreso(IngresoId ingresoId) {
        super(ingresoId);
    }
}
