package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.EgresoId;
import co.com.sofka.domain.generic.Entity;

public class Egreso extends Entity<EgresoId> {

    public Egreso(EgresoId egresoId) {
        super(egresoId);
    }
}
